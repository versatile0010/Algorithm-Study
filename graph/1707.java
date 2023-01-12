import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean visited[];
    static int set[];
    static boolean isitbiparte;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt(); // 테스트 개수
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            graph = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            set = new int[V + 1];
            for (int j = 1; j <= V; j++)
                graph[j] = new ArrayList<>();
            for (int j = 0; j < E; j++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph[u].add(v);
                graph[v].add(u); // graph 에 data 저장
            }
            // dfs

            isitbiparte = true;
            for (int j = 1; j <= V; j++) {
                // 모든 노드에 대하여
                if (isitbiparte) {
                    dfs(j);
                } else {
                    // 이분그래프가 아니면
                    break;
                }
            }
            // dfs 수행 이후
            if (isitbiparte)
                ans.add("YES");
            else
                ans.add("NO");
        }
        for (String an : ans) {
            System.out.println(an);
        }
    }

    public static void dfs(int v) {
        /*
        . 현재 노드(v) 방문 기록하기
        if(현재 노드와 연결된 방문하지 않은 노드를 탐색)
        - 현재 노드와 다른 집합으로 분류
        - 해당 노드에 대하여 dfs 실행
        else (현재 노드와 연결된 이미 방문한 노드일 경우)
        - 만약 현재 노드와 같은 집합이라면
        - 이분 그래프가 아닌 것
         */
        visited[v] = true;
        for (int i : graph[v]) {
            // 현재 노드 v 와 연결된 노드를 탐색
            if (!visited[i]) {
                // 아직 방문 안한 노드라면
                set[i] = (set[v] + 1) % 2; // 현재 노드와 다른 집합으로 분류
                visited[i] = true; // 방문 표시
                dfs(i); // 재귀 탐색
            } else {
                // 이미 방문한 노드라면
                if (set[i] == set[v]) // 근데 같은 집합으로 분류되어있다면
                {
                    isitbiparte = false; // 사이클이 존재하므로 이분그래프가 아닌 것
                    break;
                }
            }
        }
    }
}
