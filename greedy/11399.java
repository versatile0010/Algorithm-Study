import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        int [] sums = new int [n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i ++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);
        sums[0] = arr[0];
        for(int i = 1 ; i < n ; i ++){
            sums[i] = sums[i-1] + arr[i];
        }
        int ans = 0;
        for(int i = 0 ; i < n ; i ++){
            ans += sums[i];
        }
        System.out.println(ans);
    }
}
