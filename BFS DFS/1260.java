import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int start;
    static LinkedList<Integer> [] graph;
    static boolean[] visited;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        start = Integer.parseInt(stk.nextToken());

        graph = new LinkedList[n+1];
        visited = new boolean[n+1];

        for(int i = 1 ; i<= n ; i++){
            graph[i] = new LinkedList<>();
        }

        for(int i = 0; i < m ; i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i = 1 ; i<= n ;i++){
            Collections.sort(graph[i]);
        }
        dfs(start);
        System.out.println();
        reset_visit();
        bfs(start);
    }
    public static void reset_visit(){
        for(int i = 1 ; i <= n ; i++)
            visited[i] = false;
    }
    public static void dfs(int v){
        System.out.print(v+" ");
        visited[v] = true;
        for(int i : graph[v]){
            if(!visited[i]){
                dfs(i);
            }
        }
    }
    public static void bfs(int v){
        q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            System.out.print(node+" ");
            for(int i : graph[node]){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
