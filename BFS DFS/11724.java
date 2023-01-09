import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static LinkedList<Integer>[] graph;
    static boolean[] visited;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        graph = new LinkedList[n+1];
        visited = new boolean[n+1];
        for(int i = 1 ; i <= n ; i++){
            graph[i] = new LinkedList<>();
        }
        for(int i = 0 ; i < m ; i ++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        int cnt = 0;
        for(int i = 1; i<=n ; i++){
            if(!visited[i]){
                cnt++;
                dfs(i);
            }
        }
        System.out.println(cnt);
    }
    public static void dfs(int v){
        if(visited[v])
            return;
        visited[v] = true;
        for(int i : graph[v]){
            if(!visited[i])
                dfs(i);
        }
    }
}
