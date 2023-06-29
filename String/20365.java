import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        ArrayList<String> blues = new ArrayList<>();
        ArrayList<String> reds = new ArrayList<>();

        stk = new StringTokenizer(str, "R");
        while(stk.hasMoreTokens()){
            blues.add(stk.nextToken());
        }

        stk = new StringTokenizer(str, "B");
        while(stk.hasMoreTokens()){
            reds.add(stk.nextToken());
        }

        int cnt = 1;
        if(blues.size() >= reds.size()){
            cnt += reds.size();
        } else {
            cnt += blues.size();
        }
        System.out.println(cnt);
        bw.flush();
        bw.close();
    }
}
