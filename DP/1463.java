import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[1000001];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for(int i = 4 ; i<=n ; i++){
            dp[i] = dp[i-1]+1;
            if(i%3==0){
                dp[i] = Math.min(dp[i/3]+1, dp[i]);
            }
            if(i%2==0){
                dp[i] = Math.min(dp[i/2]+1, dp[i]);
            }
        }
        System.out.println(dp[n]);
    }
}
