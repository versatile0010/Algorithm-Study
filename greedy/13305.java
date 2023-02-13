import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        long[] dosi = new long[n];
        long[] dist = new long[n];
        long total_cost = 0;
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            dist[i] = Long.parseLong(stk.nextToken());
        }
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dosi[i] = Long.parseLong(stk.nextToken());
        }

        long min = Long.MAX_VALUE;
        for (int i = 0; i < n-1; i++) {
            min = Math.min(min, dosi[i]);
            total_cost += min*dist[i];
        }
        bw.write(total_cost+"\n");

        bw.flush();
        bw.close();
    }
}
