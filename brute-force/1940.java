import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int n;
        int m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int [] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int start=0;
        int end=n-1;
        int cnt=0;
        int sum=0;
        while(start<end){
            sum = arr[start] + arr[end];
            if(sum==m){
                cnt++;
                start++;
                end--;
            } else if(sum > m){
                end--;
            } else { // sum < m
                start++;
            }
        }
        System.out.println(cnt);
    }

}
