import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static LinkedList<Integer> [] graph;
    static boolean[] visited;
    static boolean isexist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        graph = new LinkedList[n+1];
        visited = new boolean[n+1];

        for(int i = 0 ; i< n ; i++){
            graph[i] = new LinkedList<>();
        }

        for(int i = 0 ; i< m ; i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for(int i = 0 ; i < n ; i++){
            dfs(i, 1);
            if(isexist) break;
        }
        if(isexist) System.out.println(1);
        else System.out.println(0);
    }
    public static void dfs(int v, int depth){
        if(depth==5 || isexist){
            isexist = true;
            return;
        }
        visited[v] = true;
        for(int i : graph[v]){
            if(!visited[i]){
                dfs(i, depth+1);
            }
        }
        visited[v] = false;
    }
}
