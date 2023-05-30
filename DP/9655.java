import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine());
        int [] dp = new int[1001];
        dp[1] = 1; dp[2] = 2;
        for(int i = 3 ; i <=n; i++){
            dp[i] = Math.min(dp[i-1]+1, dp[i-3]+1);
        }
        if(dp[n]%2==0)
            System.out.println("CY");
        else System.out.println("SK");
        bw.flush();
        bw.close();
    }
}
