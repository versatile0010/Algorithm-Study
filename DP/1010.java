import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        long[][] dp = new long[31][31];
        // mCn
        for (int i = 0; i <= 30; i++) {
            dp[i][1] = i;
            dp[i][0] = 1;
            dp[i][i] = 1;
        }
        // dp[n][k] = dp[n-1][k-1] + dp[n-1][k]
        for (int i = 2; i <= 30; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(dp[m][n]);
        }
    }
}
