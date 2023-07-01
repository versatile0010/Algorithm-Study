import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();
        boolean[] check = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            String car = br.readLine();
            hm.put(car, i);
        }
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            String out = br.readLine();
            for (int j = 1; j < hm.get(out); j++) {
                if(!check[j]){
                    ans++;
                    break;
                }
            }
            check[hm.get(out)] = true;
        }
        System.out.println(ans);


        bw.flush();
        bw.close();
    }
}
