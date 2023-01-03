import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    public static int [] max_dp;
    public static int [] min_dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        max_dp = new int[3];
        min_dp = new int[3];
        int [] prev_arr = new int[n];
        int [] next_arr = new int[n];
        int a0, a1, a2;
        for(int i = 0 ; i < n ; i++) {
            stk = new StringTokenizer(br.readLine());
            a0 = Integer.parseInt(stk.nextToken());
            a1 = Integer.parseInt(stk.nextToken());
            a2 = Integer.parseInt(stk.nextToken());

            if(i==0 /*first row*/){
                max_dp[0] = min_dp[0] = a0;
                max_dp[1] = min_dp[1] = a1;
                max_dp[2] = min_dp[2] = a2;
            }
            else{
                // set max_dp
                int t0=max_dp[0]; int t1=max_dp[2];
                max_dp[0] = Math.max(max_dp[0], max_dp[1]) + a0;
                max_dp[2] = Math.max(max_dp[1], max_dp[2]) + a2;
                max_dp[1] = Math.max(Math.max(t0, max_dp[1]), t1) + a1;

                // set min_dp
                t0=min_dp[0]; t1=min_dp[2];
                min_dp[0] = Math.min(min_dp[0], min_dp[1]) + a0;
                min_dp[2] = Math.min(min_dp[1], min_dp[2]) + a2;
                min_dp[1] = Math.min(Math.min(t0, min_dp[1]), t1) + a1;
            }
        }

        int max = Arrays.stream(max_dp).max().getAsInt();
        int min = Arrays.stream(min_dp).min().getAsInt();

        System.out.println(max + " " + min);
    }
}
