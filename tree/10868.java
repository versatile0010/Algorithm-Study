import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long[] tree;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken()); // 원소의 개수
        int m = Integer.parseInt(stk.nextToken()); // 쿼리의 개수
        // 원소의 개수를 바탕으로 트리의 높이를 알아내자
        int length = n;
        int tree_height = 0;
        while (length != 0) {
            length /= 2;
            tree_height++;
        }
        // 트리의 높이를 기반으로 세그먼트 트리의 사이즈를 알아내자
        int tree_size = (int) Math.pow(2, tree_height + 1);
        // 세그먼트 트리의 사이즈는 2*2^tree_height 이다.
        tree = new long[tree_size + 1];
        Arrays.fill(tree, Long.MAX_VALUE);

        int left_start_idx = tree_size / 2 - 1;
        for (int i = left_start_idx + 1; i <= left_start_idx + n; i++)
            tree[i] = Long.parseLong(br.readLine()); // 리프 노드 채우기
        // 세그먼트 트리 구축하기
        init(tree_size - 1);
        for (int i = 0; i < m; i++) {
            // 쿼리 수행하기
            stk = new StringTokenizer(br.readLine());
            long a = Long.parseLong(stk.nextToken());
            long b = Long.parseLong(stk.nextToken());
            // a 부터 b 까지의 최솟값을 찾기
            long start = a + left_start_idx;
            long end = b + left_start_idx;
            System.out.println(get_min(start, end));
        }
    }

    private static void init(int i) {
        while (i != 1) {
            tree[i / 2] = Math.min(tree[i], tree[i / 2]);
            i--;
        }
    }

    private static long get_min(long start, long end) {
        long partial_min = Long.MAX_VALUE;
        while (start <= end) {
            if (start % 2 == 1) {
                // 독립적인 노드에 대하여
                partial_min = Math.min(partial_min, tree[(int) start]);
                start++;
            }
            if (end % 2 == 0) {
                // 독립적인 노드에 대하여
                partial_min = Math.min(partial_min, tree[(int) end]);
                end--;
            } // 부모로 향함
            start /= 2;
            end /= 2;
        }
        return partial_min;
    }
}
