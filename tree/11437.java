import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(br.readLine()); // 노드의 개수
        tree = new ArrayList[n + 1];
        parent = new int[n + 1];
        depth = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++)
            tree[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        bfs(1);

        int m = Integer.parseInt(br.readLine()); // 쿼리 수
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            System.out.println(LCA(a, b));
        }

    }

    static int LCA(int a, int b) {
        if (depth[a] < depth[b]) {
            int t = a; // swap
            a = b;
            b = t;
        }
        while (depth[a] != depth[b]) {
            a = parent[a];
        }
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }

    static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        int level = 1;
        int now_size = 1;
        int cnt = 0; // 현재 level 에서 몇 개의 노드를 처리했는가
        while (!q.isEmpty()) {
            int now_node = q.poll();
            for (int cur : tree[now_node]) {
                if (!visited[cur]) {
                    q.add(cur);
                    visited[cur] = true;
                    parent[cur] = now_node;
                    depth[cur] = level;
                }
            }
            cnt++;
            if (cnt == now_size) {
                cnt = 0;
                now_size = q.size();
                level++;
            }
        }
    }
}
