import java.lang.reflect.Array;
import java.util.*;

public class Main {
   static ArrayList<Integer> [] graph;
   static int [] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt(); // 거리정보
        int x = sc.nextInt(); // 출발 도시의 번호

        graph = new ArrayList[n+1];
        for(int i = 1 ; i <= n ; i++){
            graph[i] = new ArrayList<>();
        }
        visited = new int[n+1];
        for(int i = 1 ; i <= n ; i++)
            visited[i] = -1;

        for(int i = 0 ; i < m ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
        }
        bfs(x);

        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 1 ; i <= n; i++){
            if(visited[i] == k){
                answer.add(i);
            }
        }
        if(answer.isEmpty()){
            System.out.println(-1);
        } else{
            Collections.sort(answer);
            for (Integer ans : answer) {
                System.out.println(ans);
            }
        }
    }
    public static void bfs(int v){
        visited[v]++;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(v);
        while(!q.isEmpty()){
            int now_node = q.poll();
            for(int i : graph[now_node]){
                if(visited[i]==-1) {
                    // 아직 방문 안했으면
                    visited[i] = visited[now_node]+1;
                    q.add(i);
                }
            }
        }
    }
}
