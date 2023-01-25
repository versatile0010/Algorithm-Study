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
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            int k = sc.nextInt();
            int n = sc.nextInt();
            int[][] dp = new int[k + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                dp[0][i] = i;
            }
            for (int i = 0; i <= k; i++) {
                dp[i][1] = 1;
            }
            for (int i = 1; i <= k; i++) {
                for (int j = 2; j <= n; j++) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
            System.out.println(dp[k][n]);
        }
    }
}
