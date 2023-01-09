import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int n, m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        int [] arr = new int[n];
        stk = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        int s = Arrays.stream(arr).max().getAsInt();
        int e = Arrays.stream(arr).sum();

        while(s<=e){
            int mid = (s+e)/2;
            int sum = 0;
            int cnt = 0;
            for(int i = 0 ; i < n ; i++){
                if(sum+arr[i] > mid){
                    cnt++;
                    sum=0;
                }
                sum += arr[i];
            }
            if(sum!=0)
                cnt++;
            if(cnt > m){
                s = mid+1;
            }
            else { // cnt <= m
                e = mid - 1;
            }
        }
        System.out.println(s);
    }
}
