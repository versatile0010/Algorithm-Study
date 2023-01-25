import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); // 색상의 개수
        int[] dp = new int[51];
        int total = 0;
        for (int i = 0; i < m; i++) {
            dp[i] = sc.nextInt();
            total += dp[i];
        }
        int k = sc.nextInt(); // 몇 개를 뽑을 것인지
        double ans = 0.0;
        double [] prob = new double[51];
        for (int i = 0; i < m; i++) {
            if(dp[i]>=k){
                prob[i]=1.0;
                for(int j = 0; j < k ; j++){
                    prob[i]*=(double)(dp[i]-j)/(total-j);
                }
            }
            ans += prob[i];
        }
        System.out.println(ans);
    }
}
