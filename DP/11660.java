import javax.swing.text.StyledEditorKit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int n;
        int m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        int [][] arr = new int[n+1][n+1];
        int [][] dp = new int[n+1][n+1];

        for(int i = 1 ; i <= n; i++){
            stk = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= n ; j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        // struct 2d - dp table
        for(int i = 1; i <=n;i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1] + arr[i][j];
            }
        }
        for(int i = 0 ; i < m ;i++){
            stk = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(stk.nextToken());
            int y1 = Integer.parseInt(stk.nextToken());
            int x2 = Integer.parseInt(stk.nextToken());
            int y2 = Integer.parseInt(stk.nextToken());
            int ans = dp[x2][y2]-dp[x1-1][y2]-dp[x2][y1-1]+dp[x1-1][y1-1];

            System.out.println(ans);
        }
    }

}
