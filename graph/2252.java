import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken()); // 학생 수
        int m = Integer.parseInt(stk.nextToken()); // 에지 수
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        int[] indegree = new int[n + 1];
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            graph.get(a).add(b);
            indegree[b]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now + " ");
            for (int cur : graph.get(now)) {
                indegree[cur]--;
                if (indegree[cur] == 0)
                    q.offer(cur);
            }
        }
    }

}
