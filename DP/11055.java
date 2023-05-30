import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine());
        int [] dp = new int[n];
        int [] arr = new int[n];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0 ; i <n ;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        dp[0] = arr[0];

        for(int i = 1 ; i < n ; i++){
            dp[i] = arr[i];
            for(int j = 0; j < i ; j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int ele : dp){
            if(ele >= ans)
                ans = ele;
        }
        bw.write(ans+"\n");
        bw.flush();
        bw.close();
    }
}


/*
        1 100   2    50     60  3 5 6 7 8
  dp    1 101  101  101    113


        dp[i] = math.max(dp[i] + )




 */
