import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int graph[][];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine()); // 노드 개수

        graph = new int[n + 1][n + 1];

        // 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    graph[i][j] = 0;
                else
                    graph[i][j] = 10000000;
            }
        }

        for (int i = 1; i <= n; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= n ; j ++){
                int cost = Integer.parseInt(stk.nextToken());
                if(graph[i][j] > cost && cost != 0){
                    graph[i][j] = cost;
                }
            }
        }
        // 플로이드 - 워셜 알고리즘 O(v^3)
        for (int k = 1; k <= n; k++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    if (graph[s][k] == 1 && graph[k][e] == 1)
                        graph[s][e] = 1;
                }
            }
        }

        // 정답 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == 10000000)
                    bw.write("0 ");
                else
                    bw.write(graph[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
