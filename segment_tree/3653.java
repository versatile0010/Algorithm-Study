import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static final int max_leafNodes = 100000 * 2;
    static int[] tree;
    static int[] index;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int tc = Integer.parseInt(br.readLine()); // test case
        while (tc > 0) {
            tc--;
            stk = new StringTokenizer(br.readLine());
            n = Integer.parseInt(stk.nextToken()); // 상근이가 가지고 있는 영화 수
            m = Integer.parseInt(stk.nextToken()); // 보려고 하는 영화 수

            // 초기화
            index = new int[n+1];
            for(int i = 1 ; i<=n; i++){
                index[i] = i+m-1;
            }
            tree = new int[max_leafNodes * 4 + 1];
            init(1, 0, n+m-1);
            // 초기화

            stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int x = Integer.parseInt(stk.nextToken());
                // x 번 영화를 보겠다!
                int idx = index[x]; // x 번 영화의 인덱스 찾기
                bw.write(sum(1, 0, n+m-1, 0, idx-1)+" ");
                // 그 위에까지 싹다 더한 값을 출력
                update(1, 0, n+m-1, idx, -1); // 원래 자리에서 빼서
                update(1, 0, n+m-1, m-1-i, 1); // 가장 위로!
                index[x] = m-1-i; // x 번째 영화의 갱신된 위치는 m-1-i
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
    private static int init(int node, int start, int end){
        if(start==end){
            if(start<m)
                return tree[node] = 0;
            else return tree[node] = 1;
        }
        int mid = (start+end)/2;
        return tree[node] = init(node*2, start, mid) +
                init(node*2+1, mid+1, end);
    }
    private static int sum(int node, int start, int end, int left, int right){
        if(right<start||left>end)
            return 0;
        if(left<=start&&end<=right)
            return tree[node];
        int mid = (start+end)/2;
        return sum(node*2, start, mid, left, right) +
                sum(node*2+1, mid+1, end, left, right);
    }
    private static void update(int node, int start, int end, int idx, int diff){
        if(idx<start || idx>end)
            return;
        tree[node]+=diff;
        if(start==end)
            return;
        int mid = (start+end)/2;
        update(node*2, start, mid, idx, diff);
        update(node*2+1, mid+1, end, idx, diff);
    }
}
