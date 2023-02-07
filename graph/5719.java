import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N; // 노드의 개수
    static int M; // 엣지의 개수
    static int S; // 시작점
    static int D; // 도착점
    static final long INF = Long.MAX_VALUE;
    static long[] dist;
    static boolean[] visited;
    static boolean[][] isused;
    static ArrayList<Node>[] graph;
    static PriorityQueue<Node> pq;
    static ArrayList<Integer>[] list;

    static class Node implements Comparable<Node> {
        int to;
        long w;

        public Node(int to, long w) {
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Node v) {
            if (this.w > v.w)
                return 1;
            else
                return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        while (true) {
            stk = new StringTokenizer(br.readLine());
            N = Integer.parseInt(stk.nextToken());
            M = Integer.parseInt(stk.nextToken());
            if (N == 0 && M == 0)
                break; // 프로그램 종료

            stk = new StringTokenizer(br.readLine());
            S = Integer.parseInt(stk.nextToken());
            D = Integer.parseInt(stk.nextToken());

            graph = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++)
                graph[i] = new ArrayList<Node>();
            dist = new long[N + 1];
            visited = new boolean[N + 1];

            for (int i = 0; i < M; i++) {
                // 엣지 정보를 입력받는다.
                stk = new StringTokenizer(br.readLine());
                int U = Integer.parseInt(stk.nextToken());
                int V = Integer.parseInt(stk.nextToken());
                int P = Integer.parseInt(stk.nextToken());
                // U ~(P)~> V
                graph[U].add(new Node(V, P));
            }
            // 입력받을 거 다 입력 받음
            isused = new boolean[N + 1][N + 1]; // 최단거리에 사용된 노드를 마킹할 배열

            dijkstra();
            if (dist[D] == Long.MAX_VALUE) {
                bw.write("-1\n");
                continue;
            }
            delete_path(S, D);
            dijkstra();

            if (dist[D] == Long.MAX_VALUE) {
                bw.write("-1\n");
            } else {
                bw.write(dist[D] + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    static void delete_path(int start, int now) {
        if (start == now)
            return;
        for (int i = 0; i < list[now].size(); i++) {
            int next = list[now].get(i);
            if (!isused[next][now]) {
                isused[next][now] = true;
                delete_path(start, next);
            }
        }
    }

    static void dijkstra() {
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();

        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(visited, false);
        dist[S] = 0; // 시작점은 0 으로 세팅
        pq = new PriorityQueue<>();
        pq.add(new Node(S, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (!visited[now.to]) {
                visited[now.to] = true; // 방문
                for (Node cur : graph[now.to]) {
                    if (isused[now.to][cur.to] == true)
                        continue;
                    if (visited[cur.to])
                        continue;
                    // 연결 성분 탐색
                    if (dist[cur.to] == dist[now.to] + cur.w) {
                        list[cur.to].add(now.to);
                    }
                    if (dist[cur.to] > dist[now.to] + cur.w) {
                        list[cur.to].clear();
                        list[cur.to].add(now.to);

                        dist[cur.to] = dist[now.to] + cur.w; // update
                        pq.offer(new Node(cur.to, dist[cur.to]));
                    }
                }
            }
        }
    }
}
