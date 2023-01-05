import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int ans=0;
        int n;
        int sum=1;
        int start=1;
        int end=1;
        int cnt=1;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        while(end != n){
            if(sum==n){
                cnt++;
                end++;
                sum += end;
            }
            else if(sum<n){
                end++;
                sum += end;
            }
            else{ /*sum>n*/
                sum -= start;
                start++;
            }
        }
        ans = cnt;
        System.out.println(ans);
    }

}
