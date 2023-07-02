import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringBuilder target = new StringBuilder();
        for (int i = 1; i <= 2 * n + 1; i++) {
            if (i % 2 == 1) {
                target.append("I");
            } else {
                target.append("O");
            }
        }
        int cnt = 0;
        int ans = 0;
        for (int i = 1; i+1 < m; i++) {
            if(str.charAt(i-1) == 'I' && str.charAt(i) == 'O' && str.charAt(i+1) == 'I'){
                cnt++;
                if(cnt == n){
                    cnt--;
                    ans++;
                }
                i++;
            } else {
                cnt = 0;
            }
        }
        System.out.println(ans);

        bw.flush();
        bw.close();
    }
}
