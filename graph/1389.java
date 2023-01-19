import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int graph[][];
    static int INF = 500000;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    graph[i][j] = 0;
                else graph[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        // 플로이드 - 워셜
        for (int k = 1; k <= n; k++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    if (graph[s][e] > graph[s][k] + graph[k][e])
                        graph[s][e] = graph[s][k] + graph[k][e];
                }
            }
        }
        int[] num = new int[n + 1];
        int min = INF;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                sum += graph[i][j];
            }
            num[i] = sum;
            if(sum < min)
                min = sum;
        }
        for(int i = 1 ; i<= n; i++)
            if(num[i]==min){
                bw.write(i+"\n");
                break;
            }
        bw.flush();
        bw.close();
    }
}
