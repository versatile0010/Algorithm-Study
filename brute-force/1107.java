import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target_channel = sc.nextInt();
        int m = sc.nextInt();

        boolean [] errors = new boolean[10];
        for(int i =  0; i < m ; i ++){
            int t = sc.nextInt();
            errors[t] = true;
        }
        int ans = Math.abs(target_channel-100);
        for(int i = 0; i <= 1000000; i++){
            String c = String.valueOf(i);
            int len = c.length();

            boolean flag = false;
            for(int j = 0 ; j < len; j++){
                if(errors[c.charAt(j)-'0']){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                ans = Math.min(Math.abs(target_channel-i)+len, ans);
            }
        }
        System.out.println(ans);
    }
}
