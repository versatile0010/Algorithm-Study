import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 2];
        int[] p = new int[n + 2];
        int[] t = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            stk = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(stk.nextToken());
            p[i] = Integer.parseInt(stk.nextToken());
        }
        for (int i = n; i >= 1; i--) {
            if(i+t[i]-1>n){
                dp[i] = dp[i+1];
            } else {
                dp[i] = Math.max(dp[i+1], dp[i+t[i]]+p[i]);
            }
        }
        System.out.println(dp[1]);
    }
}
