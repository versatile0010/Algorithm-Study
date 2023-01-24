import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long[] tree;
    static long MOD;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken()); // 원소의 개수
        int m = Integer.parseInt(stk.nextToken()); // update 쿼리의 개수
        int k = Integer.parseInt(stk.nextToken()); // get_mul 쿼리의 개수
        MOD = 1000000007;

        int tree_height = 0;
        int length = n;
        while (length != 0) {
            length /= 2;
            tree_height++;
        }
        int tree_size = (int) Math.pow(2, tree_height + 1);
        tree = new long[tree_size + 1];
        Arrays.fill(tree, 1);

        int left_start_idx = tree_size / 2 - 1;

        for (int i = left_start_idx + 1; i <= left_start_idx + n; i++)
            tree[i] = Long.parseLong(br.readLine());

        init(tree_size - 1); // 세그먼트 트리 구축
        for (int i = 0; i < m + k; i++) {
            // 쿼리 처리
            stk = new StringTokenizer(br.readLine());
            long a = Long.parseLong(stk.nextToken());
            long s = Long.parseLong(stk.nextToken());
            long e = Long.parseLong(stk.nextToken());
            if (a == 1) {
                // update
                update(s + left_start_idx, e);
            } else if (a == 2) {
                // get mul
                System.out.println(get_mul(s + left_start_idx, e + left_start_idx));
            } else return;
        }
    }

    private static void init(int i) {
        while (i != 1) {
            tree[i / 2] *= tree[i] % MOD;
            tree[i / 2] %= MOD;
            i--;
        }
    }

    private static long get_mul(long start, long end) {
        long partial_mul = 1;
        while (start <= end) {
            if (start % 2 == 1) {
                partial_mul *= tree[(int) start] % MOD;
                partial_mul %= MOD;
                start++;
            }
            if (end % 2 == 0) {
                partial_mul *= tree[(int) end] % MOD;
                partial_mul %= MOD;
                end--;
            }
            // 부모 노드로
            start /= 2;
            end /= 2;
        }
        return partial_mul;
    }

    private static void update(long idx, long val) {
        tree[(int) idx] = val;
        while (idx > 1) {
            idx /= 2;
            tree[(int) idx] = tree[(int) idx * 2] % MOD * tree[(int) idx * 2 + 1] % MOD;
            tree[(int) idx] %= MOD;
        }
    }
}
