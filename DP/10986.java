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

        int [] arr = new int[n+1];
        long [] sums = new long[n+1];
        long [] rarr = new long[m+1];

        stk = new StringTokenizer(br.readLine());
        sums[0] = Integer.parseInt(stk.nextToken());
        for(int i = 1 ; i < n; i++){
            sums[i] = sums[i-1] + Integer.parseInt(stk.nextToken());
        }

        long ans = 0;
        for(int i = 0; i<n; i++){
            int rem = (int)(sums[i] % m);
            if(rem == 0) ans++;
            rarr[rem]++;
        }
        for(int i = 0 ; i < m; i++){
            if(rarr[i]!=0)
                ans += rarr[i]*(rarr[i]-1)/2;
        }

        System.out.println(ans);
    }

}
