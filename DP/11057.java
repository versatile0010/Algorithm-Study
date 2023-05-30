import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];
        for (int i = 0; i <= 9; i++)
            dp[1][i] = 1;
        for (int i = 2; i <=n ; i++){
            for(int j = 0; j <=9; j++){
                long t = 0;
                for(int k = j ; k <= 9 ; k++){
                     t += (dp[i-1][k])%10007;
                }
                dp[i][j] = t%10007;
                //System.out.println("dp["+i+"]["+j+"]="+dp[i][j]);
            }
        }

        long ans  = 0;
        for(int i = 0 ; i <=9 ; i++){
            ans += (dp[n][i])%10007;
        }
        bw.write(ans%10007+"\n");
        bw.flush();
        bw.close();
    }
}
/*
    n=1
     0 1 2 3 4 5 6 7 8 9 = dp[1] = 10
     dp[1][0] ~ dp[1][9] = 1
    n=2
    0 (0~9) = 10 dp[2][0] = 10
    1 (1~9) = 9  dp[2][1] = 9
    2 (2~9) = 8
    3 (3~9) = 7
    4 (4~9) = 6
    5 (5~9) = 5
    6 (6~9) = 4 ...
    7 (7~9) = 3
    8 (8~9) = 2
    9 (9) = 1   dp[2][9] = 1
    dp=3
    dp[3][0] = dp[2][0] + dp[2][1] + dp[2][2] + ... + dp[2][9]
    dp[3][1] = dp[2][1] + ... + dp[2][9]
    dp[x][y] = dp[x-1][y] + ... + dp[x-1][9]
 */
