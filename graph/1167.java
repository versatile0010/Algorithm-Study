import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int v;
    static LinkedList<Node>[] graph;
    static boolean [] visited;
    static Queue<Integer> q;
    static int [] dist;
    static class Node{
        int edge;
        int weight;
        public Node(int edge, int weight){
            this.edge = edge;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        v = Integer.parseInt(stk.nextToken());
        graph = new LinkedList[v+1];
        visited = new boolean[v+1];
        dist = new int[v+1];
        for(int i = 1; i<=v; i++){
            graph[i] = new LinkedList<Node>();
        }
        for(int i = 1 ; i <= v; i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            while(true){
                int b = Integer.parseInt(stk.nextToken());
                if(b==-1){
                    break;
                }
                int w = Integer.parseInt(stk.nextToken());
                graph[a].add(new Node(b, w));
            }
        }

        bfs(1);
        // find max
        int max = 1;
        for(int i = 1 ; i <= v; i++){
            if(dist[max] < dist[i]){
                max = i;
            }
        }

        visited = new boolean[v+1];
        dist = new int[v+1];

        bfs(max);
        for(int i = 1 ; i <= v ; i++){
            max = Math.max(max, dist[i]);
        }
        System.out.println(max);
    }
    public static void bfs(int n){
        q = new LinkedList<Integer>();
        q.add(n);
        visited[n] = true;
        while(!q.isEmpty()){
            int nodes = q.poll();
            for(Node i : graph[nodes]){
                if(!visited[i.edge]){
                    q.add(i.edge);
                    visited[i.edge] = true;
                    dist[i.edge] = dist[nodes] + i.weight;
                }
            }
        }
    }
}
