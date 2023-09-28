import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static long[] dist;
    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken()); // vertex
        m = Integer.parseInt(stk.nextToken()); // edge

        // init
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // input
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());
            graph[a].add(new Node(b, w));
            graph[b].add(new Node(a, w));
        }
        dist = new long[n + 1];
        visited = new boolean[n + 1];
        pq = new PriorityQueue<>();

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            for (Node cur : graph[now.to]) {
                if (dist[cur.to] > dist[now.to] + cur.w) {
                    dist[cur.to] = dist[now.to] + cur.w;
                    pq.add(new Node(cur.to, (int) dist[cur.to]));
                }
            }
        }
        bw.write(dist[n]+"\n");
        bw.flush();
        bw.close();
    }

    static class Node implements Comparable<Node> {
        int to;
        int w;

        public Node(int to, int w) {
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return (int) (this.w - o.w);
        }
    }
}
