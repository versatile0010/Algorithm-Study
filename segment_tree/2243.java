import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long tree[];
    static long arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        // 리프 노드의 개수는 1000000
        tree = new long[1000000 * 4];
        arr = new long[1000001];

        init(1,1000000, 1);

        int n = Integer.parseInt(br.readLine()); // 쿼리 개수
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            if(stk.countTokens()==2){
                // 사탕을 꺼내는 경우
                long a = Long.parseLong(stk.nextToken());
                long b = Long.parseLong(stk.nextToken());
                int r = bisearch(1, 1000000, b);
                System.out.println(r);
                update(1, 1000000, 1, r, -1);
            } else {
                // 사탕을 넣는 경우
                long a = Long.parseLong(stk.nextToken());
                long b = Long.parseLong(stk.nextToken());
                long c = Long.parseLong(stk.nextToken());
                update(1, 1000000, 1, (int)b, c);
            }
        }
    }

    private static int bisearch(int left, int right, long target) {
        while(left<=right) {
            int mid = (left + right) / 2;
            long sum = sum(1, 1000000, 1, 1, mid);
            if (sum < target)
                left = mid + 1;
            else if (sum >= target)
                right = mid - 1;
        }
        return left;
    }

    private static long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) +
                init(mid + 1, end, node * 2 + 1);
    }

    private static long sum(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    private static void update(int start, int end, int node, int idx, long val) {
        if (idx < start || idx > end) {
            return;
        }
        tree[node] = tree[node] + val;
        if (start == end) {
            arr[idx] = tree[node];
            return;
        }
        int mid = (start + end) / 2;
        update(start, mid, node * 2, idx, val);
        update(mid + 1, end, node * 2 + 1, idx, val);
    }
}
