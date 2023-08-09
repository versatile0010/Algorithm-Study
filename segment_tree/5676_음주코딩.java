import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        String input;
        while ((input = br.readLine()) != null) {
            stk = new StringTokenizer(input);
            int n = Integer.parseInt(stk.nextToken()); // 수열의 크기
            int k = Integer.parseInt(stk.nextToken()); // 라운드 수
            long[] arr = new long[n];
            stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(stk.nextToken());
            }
            SegmentTree segmentTree = new SegmentTree(arr, n);
            while (k-- > 0) {
                stk = new StringTokenizer(br.readLine());
                String op = stk.nextToken();
                int i = Integer.parseInt(stk.nextToken());
                long v = Long.parseLong(stk.nextToken());

                if (op.equals("C")) { // 변경
                    segmentTree.update(i - 1, v);
                }
                if (op.equals("P")) { // 곱셈
                    long mul = segmentTree.query(i - 1, (int) v - 1);
                    if (mul > 0) bw.write("+");
                    else if (mul < 0) bw.write("-");
                    else bw.write("0");
                }
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class SegmentTree {
        long[] tree;
        int N;

        public SegmentTree(long[] arr, int n) {
            N = n;
            tree = new long[N * 4];
            build(arr, 1, 0, N - 1);
        }

        public long merge(long leftVal, long rightVal) {
            if (leftVal > 0 && rightVal > 0)
                return 1;
            if (leftVal > 0 && rightVal < 0)
                return -1;
            if (leftVal < 0 && rightVal > 0)
                return -1;
            if (leftVal < 0 && rightVal < 0)
                return 1;
            else return 0;
        }

        public long build(long[] arr, int node, int nodeLeft, int nodeRight) {
            if (nodeLeft == nodeRight) {
                return tree[node] = arr[nodeLeft];
            }
            long mid = nodeLeft + (nodeRight - nodeLeft) / 2;
            long leftVal = build(arr, node * 2, nodeLeft, (int) mid);
            long rightVal = build(arr, node * 2 + 1, (int) mid + 1, nodeRight);

            return tree[node] = merge(leftVal, rightVal);
        }

        public Long queryRecursive(int left, int right, int node, int nodeLeft, int nodeRight) {
            if (right < nodeLeft || nodeRight < left) {
                return 1L;
            }
            if (left <= nodeLeft && nodeRight <= right) {
                return tree[node];
            }
            long mid = nodeLeft + (nodeRight - nodeLeft) / 2;
            return merge(queryRecursive(left, right, node * 2, nodeLeft, (int) mid),
                    queryRecursive(left, right, node * 2 + 1, (int) mid + 1, nodeRight));
        }

        public Long query(int left, int right) {
            if (left > right) {
                return query(right, left);
            }
            return queryRecursive(left, right, 1, 0, N - 1);
        }

        public Long updateRecursive(int index, long newValue, int node, int nodeLeft, int nodeRight) {
            if (index < nodeLeft || nodeRight < index) {
                return tree[node];
            }
            if (nodeLeft == nodeRight) {
                return tree[node] = newValue;
            }
            long mid = nodeLeft + (nodeRight - nodeLeft) / 2;
            long leftValue = updateRecursive(index, newValue, node * 2, nodeLeft, (int) mid);
            long rightValue = updateRecursive(index, newValue, node * 2 + 1, (int) mid + 1, nodeRight);
            return tree[node] = merge(leftValue, rightValue);
        }

        public void update(int index, long newValue) {
            updateRecursive(index, newValue, 1, 0, N - 1);
        }
    }
}
