import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine()); // 포도주의 개수
        int [] arr = new int[10001];

        for(int i = 1 ; i <= n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int [] dp = new int[10001];
        dp[1] = arr[1];
        dp[2] = arr[1]+arr[2];
        for(int i = 3 ; i<=n; i++){
            dp[i] = Math.max(dp[i-3]+arr[i-1]+arr[i], dp[i-2]+arr[i]);
            dp[i] = Math.max(dp[i-1], dp[i]);
        }
        System.out.println(dp[n]);

    }
}
