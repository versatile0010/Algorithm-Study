import java.util.*;

public class Main {
    static ArrayList<Integer> [] graph;
    static boolean [] visited;
    static int [] reliable;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new ArrayList[n+1];
        reliable = new int[n+1];
        for(int i = 1; i<= n; i++)
            graph[i] = new ArrayList<>();
        for(int i = 0 ; i < m ; i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            graph[a].add(b);
        }
        for(int i = 1 ; i <=n ;i++){
            visited = new boolean[n+1];
            bfs(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int max = Arrays.stream(reliable).max().getAsInt();
        for(int i = 1 ; i <= n ; i++){
            if(reliable[i] == max){
                ans.add(i);
            }
        }
        Collections.sort(ans);
        for(int i : ans)
            System.out.print(i+" ");
    }
    private static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i : graph[now]){
                // 연결관계 탐색
                if(!visited[i]){
                    visited[i] = true;
                    reliable[i]++;
                    q.add(i);
                }
            }
        }
    }
}
