import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine());
        long [] dp = new long[n+1];
        dp[0] = 0; dp[1] = 1;
        for(int i = 2; i <=n; i++)
            dp[i] = dp[i-1] + dp[i-2];
        bw.write(dp[n]+"\n");

        bw.flush();
        bw.close();
    }
}

/*
    dp[0] = 0
    N=1
    1 DP[1] = 1
    N=2
    10 DP[2] = 1
    N=3
    10[0, 1] DP[3] = 2
    N=4
    10[00, 01, 10] DP[4] = DP[3] + DP[2]
    N=5
    10[1[]] DP[5] =  DP[4] + DP[3]
 */
