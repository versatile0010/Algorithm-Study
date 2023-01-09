import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        arr = new int[n];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);

        stk = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < m ; i++){
            int target = Integer.parseInt(stk.nextToken());
            int s = 0;
            int e = arr.length-1;
            boolean find = false;
            while(s<=e){
                int mid = (s+e)/2;
                int midv = arr[mid];
                if(midv < target){
                    s = mid+1;
                } else if (midv > target){
                    e = mid-1;
                } else {
                    find = true;
                    break;
                }
            }
            if(find)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
