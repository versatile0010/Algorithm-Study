import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 1) {
                    dp[i][j] = i;
                }
                if (i == j) {
                    dp[i][j] = 1;
                }
                if (j == 0) {
                    dp[i][j] = 1;
                }
            }
        }
        int mod = 10007;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                dp[i][j] %= mod;
            }
        }
        System.out.println(dp[n][k]);
    }
}
