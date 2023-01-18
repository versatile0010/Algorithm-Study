import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken()); // 노드 개수
        int m = Integer.parseInt(stk.nextToken()); // 에지 개수
        int k = Integer.parseInt(stk.nextToken()); // k
        // 먼저 그래프에 데이터를 저장하자.
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<Node>();
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int cost = Integer.parseInt(stk.nextToken());
            graph[a].add(new Node(b, cost));
        }
        PriorityQueue<Integer>[] distQueue = new PriorityQueue[n + 1];
        Comparator<Integer> cp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : -1; // 오름차순
            }
        };
        for (int i = 0; i <= n; i++) {
            distQueue[i] = new PriorityQueue<>(k, cp);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0)); // 시작점
        distQueue[1].add(0);
        while (!pq.isEmpty()) {
            Node now_node = pq.poll();
            for (Node cur : graph[now_node.toNode]) {
                // 연결관계 탐색
                if (distQueue[cur.toNode].size() < k) {
                    // 저장된 경로가 k 개 보다 작으면 경로 저장
                    distQueue[cur.toNode].add(now_node.w + cur.w);
                    pq.add(new Node(cur.toNode, now_node.w + cur.w));
                } else if (distQueue[cur.toNode].peek() > now_node.w + cur.w) {
                    // 저장된 경로가 k 개이고, 새로운 경로가 현재 가장 큰 값보다 작으면 추가
                    distQueue[cur.toNode].poll();
                    distQueue[cur.toNode].add(now_node.w + cur.w);
                    pq.add(new Node(cur.toNode, now_node.w + cur.w));
                }
            }
        }
        for(int i = 1 ; i <= n ; i++){
            if(distQueue[i].size()==k){
                bw.write(distQueue[i].peek()+"\n");
            } else bw.write("-1\n");
        }
        bw.flush();
        bw.close();
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
            return this.w < v.w ? -1 : 1;
        }

    }
}
