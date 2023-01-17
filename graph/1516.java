import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] my_time = new int[n + 1];
        int[] minimum_time = new int[n + 1];
        int[] indegree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stk = new StringTokenizer(br.readLine());
            my_time[i] = Integer.parseInt(stk.nextToken());
            while (true) {
                int t = Integer.parseInt(stk.nextToken());
                if (t == -1)
                    break;
                else {
                    graph.get(t).add(i);
                    indegree[i]++;
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int cur : graph.get(now)) {
                // 연결 성분 탐색
                minimum_time[cur] = Math.max(minimum_time[cur], minimum_time[now] + my_time[now]);
                indegree[cur]--;
                if (indegree[cur] == 0)
                    q.add(cur);
            }
        }
        for (int i = 1; i <= n; i++) {
            minimum_time[i] += my_time[i];
            System.out.println(minimum_time[i]);
        }
    }
}
