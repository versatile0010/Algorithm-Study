import java.io.*;
import java.text.BreakIterator;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int [][] graph;
    static boolean [][] visited;
    static Queue<Node> q;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        graph = new int [n][m];
        visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < m ; j++)
                graph[i][j] = Integer.parseInt(str.substring(j, j+1));
        }
        bfs(0,0);
        System.out.println(graph[n-1][m-1]);
    }
    static class Node{
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void bfs(int x ,int y){
        q = new LinkedList<Node>();
        q.add(new Node(x, y));
        visited[y][x] = true;
        while(!q.isEmpty()){
            Node p = q.poll();
            for(int dir = 0 ; dir< 4 ; dir ++){
                int nx = p.x + dx[dir];
                int ny = p.y + dy[dir];
                if(nx<0 || nx>=m || ny<0|| ny>=n) continue;
                if(graph[ny][nx]==0 || visited[ny][nx]) continue;
                visited[ny][nx] = true;
                graph[ny][nx] += graph[p.y][p.x];
                q.add(new Node(nx, ny));
            }
        }
    }
}
