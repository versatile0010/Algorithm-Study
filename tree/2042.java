import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] tree;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken()); // 노드 개수
        int m = Integer.parseInt(stk.nextToken()); // 변경 횟수
        int k = Integer.parseInt(stk.nextToken()); // 구간 합을 구하는 횟수

        int tree_height = 0; // 세그먼트 트리의 높이
        int length = n; // 원소 개수
        while (length != 0) {
            length /= 2;
            tree_height++; // 트리의 높이를 구함
        } // 원소 개수가 5 개 이면 트리의 높이는 3
        int tree_size = (int) Math.pow(2, tree_height + 1); // 2^(k+1)
        // 1차원 배열로 세그먼트 트리를 표현할 것임.
        // tree 의 높이를 k 라고 하면 2*2^k 만큼의 공간이 필요함
        int left_start_idx = tree_size / 2 - 1;
        // 리프 노드의 시작 인덱스는 2^k
        tree = new long[tree_size + 1];
        // 2^k ~ 2^k+n
        for (int i = left_start_idx + 1; i <= left_start_idx + n; i++)
            tree[i] = Long.parseLong(br.readLine()); // 리프 노드를 채우기

        init(tree_size - 1);
        // 세그먼트 트리 구축

        for (int i = 0; i < m + k; i++) {
            stk = new StringTokenizer(br.readLine());
            long a = Long.parseLong(stk.nextToken());
            long s = Long.parseLong(stk.nextToken());
            long e = Long.parseLong(stk.nextToken());
            // 쿼리를 받고
            if (a == 1) { // update 쿼리면
                update(left_start_idx + s, e); // 업데이트
            } else if (a == 2) { // get sum 구간합을 구함
                s = s + left_start_idx; // 쿼리 인덱스를 세그먼트 트리 인덱스로 바꿔줘야함.
                e = e + left_start_idx;
                long sum = get_sum(s, e);
                System.out.println(sum);
            } else return;
        }
    }

    private static long get_sum(long start, long end) {
        long partial_sum = 0; // 구간합
        while(start<=end){
            if(start%2==1){ // 독립적인 노드이므로 선택
                partial_sum += tree[(int)start];
                start++;
            }
            if(end%2==0){ // 독립적인 노드이므로 선택
                partial_sum+=tree[(int)end];
                end--;
            }
            start/=2; // 부모 탐색
            end/=2;
        }
        return partial_sum;
    }

    private static void update(long idx, long val) {
        long update_diff = val - tree[(int) idx]; // 얼마나 바뀌는지 변화량 계산
        while (idx > 0) { // 부모로 향하면서
            tree[(int) idx] = tree[(int) idx] + update_diff; // 그 변화량만큼 더해주기
            idx /= 2; // 부모로 향하기
        }
    }

    private static void show(int tree_size) {
        for (int i = 0; i < tree_size; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }

    private static void init(int i) { // 세그먼트 트리 (누적합 버전) 구축하기
        while (i != 1) {
            tree[i / 2] += tree[i]; // 리프 노드를 이용해서 부모 노트를 누적합하기
            i--;
        }
    }
}
