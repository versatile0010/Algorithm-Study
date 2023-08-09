import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken()); // 쿼리 개수

        long[] arr = new long[n];
        SegmentTree segmentTree = new SegmentTree(arr, n);

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int idx = Integer.parseInt(stk.nextToken());
            long val = Long.parseLong(stk.nextToken());

            if (x == 0) {
                int left = idx - 1;
                int right = (int) val - 1;
                long sum = segmentTree.query(left, right);
                bw.write(sum + "\n");
            } else if (x == 1) {
                segmentTree.update(idx - 1, val);
            }
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
            return leftVal + rightVal;
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
                return 0L;
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
