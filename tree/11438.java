import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] parent;
    static int[] depth;
    static ArrayList<Integer>[] tree;
    static final int length = 21;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine()); // 노드의 개수
        parent = new int[n+10][length+1];
        depth = new int[n+10];
        tree = new ArrayList[n + 10];
        for (int i = 1; i <= n; i++) { // init
            depth[i] = -1;
            tree[i] = new ArrayList<>();
        }
        depth[1] = 0;

        for (int i = 0; i < n - 1; i++) {
            // 트리 정보 입력
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(1);
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= n + 1; j++) {
                parent[j][i] = parent[parent[j][i - 1]][i - 1];
                // j 의 2^i 번째 부모노드는
                // j 의 2^(i-1) 번째 부모 노드의 2^i-1 번째 부모노드와 같다
            }
        }

        int m = Integer.parseInt(br.readLine()); // 쿼리의 개수
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            bw.write(LCA(a, b) + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static int LCA(int a, int b){
        if (depth[a] < depth[b]) {
            int t = a;
            a = b;
            b = t;
        } // a 를 더 깊은 노드로

        for(int i = length; i>=0; i--) {
            int diff = depth[a] - depth[b];
            if(diff >= 1<<i) {
                a = parent[a][i];
            }
        }
        if(a==b) return a;
        for(int i = length; i>=0; i--) {
            if(parent[a][i]!=parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }
        return parent[a][0];

    }

    private static void dfs(int v) {
        for (int cur : tree[v]) {
            // 자식 노드 탐색
            if (depth[cur] == -1) {
                parent[cur][0] = v;
                depth[cur] = depth[v] + 1;
                dfs(cur);
            }
        }
    }
}
