import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        long mod = 1000000000;
        int n = sc.nextInt();
        long [] dp = new long[1000001];

        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;

        for(int i = 3; i <= n; i++){
            dp[i] = (i-1)*(dp[i-2]+dp[i-1])%mod;
        }
        System.out.println(dp[n]);
    }
}
