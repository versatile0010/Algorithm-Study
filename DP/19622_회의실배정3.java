import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine()); // 회의 수
        int[][] table = new int[n + 1][3];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            table[i][0] = Integer.parseInt(stk.nextToken());
            table[i][1] = Integer.parseInt(stk.nextToken());
            table[i][2] = Integer.parseInt(stk.nextToken());
        }

        long[] dp = new long[n + 1];

        dp[0] = table[0][2];
        dp[1] = Math.max(dp[0], table[1][2]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + table[i][2], dp[i - 1]);
        }
        bw.write(dp[n - 1] + "\n");

        bw.flush();
        bw.close();
    }
}
