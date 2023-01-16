import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.spi.AbstractSelectionKey;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        int [] arr = new int [n];

        stk = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i ++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int sum = 0;
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            int cur = arr[i] == 1 ? -1 : 1;
            sum += cur;
            if(sum < 0) sum = 0;
            if(sum > max) max = sum;
        }
        sum = 0;
        for(int i = 0 ; i < n ; i++){
            int cur = arr[i] == 1 ? 1 : -1;
            sum += cur;
            if(sum < 0) sum = 0;
            if(sum > max) max = sum;
        }
        System.out.println(max);
    }
}
