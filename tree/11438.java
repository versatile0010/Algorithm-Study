import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
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
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        depth = new int[n + 1];
        parent = new int[n + 1][length + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
            depth[i] = -1;
        }
        depth[1] = 0;
        for (int i = 0; i < n - 1; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        dfs(1);
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= n; j++) {
                parent[j][i] = parent[parent[j][i - 1]][i - 1];
            }
        }
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            bw.write(LCA(a, b) + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void dfs(int v) {
        for (int cur : tree[v]) {
            if (depth[cur] == -1) {
                parent[cur][0] = v;
                depth[cur] = depth[v] + 1;
                dfs(cur);
            }
        }
    }

    private static int LCA(int a, int b) {
        if (depth[a] < depth[b]) {
            int t = a;
            a = b;
            b = t;
        }
        for (int i = length; i >= 0; i--) {
            if (depth[a] - depth[b] >= 1 << i)
                a = parent[a][i];
        }
        if (a == b) return a;
        for (int i = length; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }
        return parent[a][0];
    }
}
