import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        int[] arr = new int[n];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int[] dp = new int[n];
        int ans = -10;
        for (int i = 0; i < n; i++) {
            int cur = arr[i] == 1 ? -1 : 1;
            if (i == 0) {
                dp[i] = cur;
            } else { // i!=0
                dp[i] = Math.max(dp[i - 1] + cur, cur);
            }
        }
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }

        dp = new int[n];
        for (int i = 0; i < n; i++) {
            int cur = arr[i] == 1 ? 1 : -1;
            if (i == 0) {
                dp[i] = cur;
            } else { // i!=0
                dp[i] = Math.max(dp[i - 1] + cur, cur);
            }
        }
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
