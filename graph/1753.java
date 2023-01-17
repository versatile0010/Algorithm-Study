import java.io.*;
import java.util.*;

public class Main {
    static int INF = Integer.MAX_VALUE;
    static ArrayList<Node> graph[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(stk.nextToken()); // 노드 개수
        int e = Integer.parseInt(stk.nextToken()); // 에지 개수

        stk = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(stk.nextToken()); // 시작점

        graph = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < e; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());

            graph[a].add(new Node(b, w));
        }

        int[] dist = new int[v + 1];
        boolean[] visited = new boolean[v + 1];
        for (int i = 1; i <= v; i++) {
            dist[i] = INF;
        }

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (visited[cur.toNode]) continue; // 이미 방문?
            visited[cur.toNode] = true;
            for (int i = 0; i < graph[cur.toNode].size(); i++) {
                Node t = graph[cur.toNode].get(i);
                int next = t.toNode;
                int val = t.e;
                if (dist[next] > dist[cur.toNode] + val) {
                    dist[next] = dist[cur.toNode] + val;
                    q.add(new Node(next, dist[next]));
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            if (!visited[i])
                bw.write("INF\n");
            else bw.write(dist[i] + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    static class Node implements Comparable<Node> {
        int toNode;
        int e;

        public Node(int toNode, int e) {
            this.toNode = toNode;
            this.e = e;
        }

        public int compareTo(Node n) {
            if (this.e > n.e)
                return 1;
            else
                return -1;
        }
    }
}
