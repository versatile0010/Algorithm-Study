import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int n;
    static int m;
    static int islandCnt;
    static PriorityQueue<Edge> pq;
    static int[] parent;
    static int[][] graph;
    static boolean[][] visited;
    static ArrayList<Node> local_info;
    static ArrayList<ArrayList<Node>> global_info;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken()); // 세로 크기
        m = Integer.parseInt(stk.nextToken()); // 가로 크기
        graph = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) { // 그래프 입력받기
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        // bfs 수행하기
        islandCnt = 1;
        global_info = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0 || visited[i][j]) continue;
                bfs(j, i);
                islandCnt++;
                global_info.add(local_info); // 각 섬들에 해당하는 좌표 정보를 저장함.
            }
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>(); // 크루스칼 알고리즘을 위한 우선순위큐
        for (int i = 0; i < global_info.size(); i++) {
            ArrayList<Node> now = global_info.get(i);
            // 현재 섬에 대하여,
            for (int j = 0; j < now.size(); j++) {
                // 모든 포인트들을 순회하면서 만들 수 있는 다리들을 조사함
                Node now_node = now.get(j);
                int x = now_node.x;
                int y = now_node.y;
                int now_idx = graph[y][x];
                for (int dir = 0; dir < 4; dir++) {
                    int delta_x = dx[dir];
                    int delta_y = dy[dir];
                    int now_length = 0;
                    while (x + delta_x >= 0 && x + delta_x < m && y + delta_y >= 0 && y + delta_y < n) {
                        if (graph[y + delta_y][x + delta_x] == now_idx)
                            break; // 같은 섬끼리는 연결하지 않음
                        else if (graph[y + delta_y][x + delta_x] != 0) {
                            // 바다가 아니면
                            if (now_length > 1)
                                pq.add(new Edge(now_idx, graph[y + delta_y][x + delta_x], now_length));
                            break;
                        } else // 바다이면
                            now_length++;
                        if (delta_y < 0) // 이동 좌표 수정
                            delta_y--;
                        else if (delta_y > 0)
                            delta_y++;
                        else if (delta_x < 0)
                            delta_x--;
                        else if (delta_x > 0)
                            delta_x++;
                    }
                }
            }
        }
        // 이제 저장된 에지 정보들을 이용하여 크루스칼 알고리즘을 적용하여 MST 를 찾는다.
        parent = new int[islandCnt + 1];
        for (
                int i = 1;
                i <= islandCnt; i++) {
            parent[i] = i;
        }

        int used = 0;
        int ans = 0;
        while (!pq.isEmpty()) {
            Edge now_edge = pq.poll();
            if (find(now_edge.s) != find(now_edge.e)) {
                // 같은 부모가 아니라면 연결한다
                union(now_edge.s, now_edge.e);
                ans += now_edge.w;
                used++;
            }
        }
        if (used == islandCnt - 2) {
            System.out.println(ans);
        } else System.out.println(-1);
    }

    static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        graph[y][x] = islandCnt;
        visited[y][x] = true;

        local_info = new ArrayList<>();
        local_info.add(new Node(x, y));

        while (!q.isEmpty()) {
            Node now_node = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = now_node.x + dx[dir];
                int ny = now_node.y + dy[dir];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue; // out of bounds
                if (visited[ny][nx]) continue;
                if (graph[ny][nx] != 0) {
                    // 아직 방문안한 섬의 땅이라면
                    graph[ny][nx] = islandCnt;
                    visited[ny][nx] = true;
                    q.add(new Node(nx, ny));
                    local_info.add(new Node(nx, ny));
                }
            }
        }
    }

    static void show() {
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }
    }

    static class Node {
        int x;
        int y;
        int length = 0;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int length) {
            this.x = x;
            this.y = y;
            this.length = length;
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b)
            parent[b] = a;
    }

    static int find(int a) {
        if (parent[a] == a)
            return a;
        else return parent[a] = find(parent[a]);
    }

    static class Edge implements Comparable<Edge> {
        int s;
        int e;
        int w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge v) {
            return this.w > v.w ? 1 : -1;
        }
    }
}
