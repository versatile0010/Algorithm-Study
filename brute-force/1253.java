import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        long [] arr = new long[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int ans=0;
        for(int i = 0 ; i < n ; i++){
            long target = arr[i];
            int start=0;
            int end=n-1;
            long sum=0;
            while(start<end){
                sum = arr[start]+arr[end];
                if(sum==target){
                    if(start != i && end != i){
                        ans++;
                        break;
                    } else if(start == i){
                        start++;
                    } else if(end == i) {
                        end++;
                    }
                } else if(sum < target){
                    start++;
                } else { // sum > target
                    end--;
                }
            }
        }
        System.out.println(ans);
    }

}
