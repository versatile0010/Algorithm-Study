import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] graph;
    static final int INF = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<Node>();

        dist = new int[n + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            graph[a].add(new Node(b, e));
        }
        stk = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(stk.nextToken());
        int end = Integer.parseInt(stk.nextToken());

        visited = new boolean[n + 1];
        dijkstra(start, end);
        System.out.println(dist[end]);
    }

    public static void dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (!visited[now.toNode]) {
                visited[now.toNode] = true;
                for (Node cur : graph[now.toNode]) {
                    if (!visited[cur.toNode] && dist[cur.toNode] > dist[now.toNode] + cur.w) {
                        dist[cur.toNode] = dist[now.toNode] + cur.w;
                        pq.offer(new Node(cur.toNode, dist[cur.toNode]));
                    }
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int toNode;
        int w;

        public Node(int toNode, int w) {
            this.toNode = toNode;
            this.w = w;
        }

        @Override
        public int compareTo(Node v) {
            return this.w - v.w;
        }
    }
}
