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

        stk = new StringTokenizer(br.readLine());
        int [] arr = new int[n+1];
        int [] sums = new int[n+1];
        for(int i = 1 ; i <= n ; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        for(int i = 1 ; i <= n ;i++) {
            sums[i] = sums[i-1] + arr[i];
        }

        for(int i = 0 ; i < m ; i++){
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            System.out.println(sums[end]-sums[start-1]);
        }
    }

}
