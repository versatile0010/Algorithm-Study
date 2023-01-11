import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static LinkedList<Node> [] graph;
    static boolean [] visited;
    static long [] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        graph = new LinkedList[n];
        for(int i = 0; i < n ; i++)
            graph[i] = new LinkedList<Node>();

        long l = 1;
        for (int i = 0; i < n-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            graph[a].add(new Node(b, p, q));
            graph[b].add(new Node(a, q, p));
            l *= (p*q/gcd(p,q));
        }
        arr = new long[n];
        visited = new boolean[n];
        arr[0] = l;
        dfs(0);
        long temp = arr[0];
        for(int i = 1 ; i < n; i++){
            temp = gcd(temp, arr[i]); // 최대공약수 구하기
        }
        for(int i = 0 ; i < n; i++){
            System.out.print(arr[i]/temp + " ");
        }
    }

    public static void dfs(int v){
        visited[v] = true;
        for(Node n : graph[v]){
            int next = n.idx;
            if(!visited[next]){
                // 방문하지 않은 노드라면
                arr[next] = arr[v] * n.getQ() / n.getP();
                dfs(next);
            }
        }
    }
    public static long gcd(long a, long b){
        if(b==0)
            return a;
        else
            return gcd(b, a%b);
    }
    static class Node {
        int idx;
        int p;
        int q;

        public Node(int idx, int p, int q) {
            this.idx = idx;
            this.p = p;
            this.q = q;
        }

        public int getIdx() {
            return idx;
        }

        public int getP() {
            return p;
        }

        public int getQ() {
            return q;
        }
    }
}
