import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean visited[];
    static int parent[];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(br.readLine()); // 전체 노드의 개수
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        parent = new int[n + 1];

        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < n-1; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for(int i = 1; i<=n; i++){
            dfs(i);
        }
        for(int i = 2 ; i <= n; i++){
            System.out.println(parent[i]);
        }
    }
    static void dfs(int v){
        visited[v] = true;
        for(int cur : graph[v]){
            if(!visited[cur]){
                // 방문 안했다면
                parent[cur] = v;
                dfs(cur);
            }
        }
    }
}
