import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static PriorityQueue<Edge> pq;
    static int [] parent;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(stk.nextToken()); // 노드 개수
        int e = Integer.parseInt(stk.nextToken()); // 에지 개수
        pq = new PriorityQueue<>();
        for (int i = 0; i < e; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int cost = Integer.parseInt(stk.nextToken());
            pq.add(new Edge(a, b, cost));
        }

        parent = new int[v + 1];
        for (int i = 1; i <= v; i++)
            parent[i] = i; // 유니온&파인트 배열 초기화
        int used = 0;
        int min_cost=0;
        while(used < v-1){
            Edge now_edge = pq.poll();
            if(find(now_edge.s) != find(now_edge.e)){
                // 부모가 다르면 사이클이 형성되지 않는 것
                union(now_edge.s, now_edge.e); // 그러면 연결
                min_cost+=now_edge.w;
                used++;
            }
        }
        System.out.println(min_cost);
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b)
            parent[b] = a;
    }
    static int find(int a){
        if(parent[a] == a)
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
