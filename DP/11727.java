import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine());

        int [] dp = new int[2000];
        dp[1] = 1;
        dp[2] = 3;

        for(int i = 3; i <=n; i++){
            dp[i] = (dp[i-1] + 2*dp[i-2])%10007;
        }

        bw.write(dp[n]+"\n");
        bw.flush();
        bw.close();
    }
}
