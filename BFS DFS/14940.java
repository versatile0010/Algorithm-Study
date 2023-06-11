import java.io.*;
import java.util.*;
// https://www.acmicpc.net/problem/14940
// 쉬운최단거리 (S1)
public class Main {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        Node end;
        Queue<Node> q = new LinkedList<>();
        int[][] dist = new int[n + 1][m + 1];
        int[][] graph = new int[n + 1][m + 1];
        boolean[][] visited = new boolean[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(stk.nextToken());
                if (graph[i][j] == 2) {
                    q.add(new Node(j, i));
                    visited[i][j] = true;
                }
            }
        }


        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (visited[ny][nx] || graph[ny][nx] == 0) continue;
                q.add(new Node(nx, ny));
                visited[ny][nx] = true;
                dist[ny][nx] = dist[now.y][now.x] + 1;
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j ++){
                if(dist[i][j] == 0 && graph[i][j] == 1)
                    bw.write(-1+" ");
                else bw.write(dist[i][j]+" ");
            } bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
