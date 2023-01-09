import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int n;
        long k;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextLong();

        long st, mid, end;
        st = 1;
        end = k;
        long ans=0;
        while(st<=end){
            mid = (st+end)/2;

            // counting
            int cnt = 0;
            for(int i = 1 ; i <= n ; i++){
                cnt += Math.min(mid/i, n);
            }
            if(cnt < k){
                st = mid+1;
            } else {
                ans = mid;
                end = mid-1;
            }
        }
        System.out.println(st);
    }
}
