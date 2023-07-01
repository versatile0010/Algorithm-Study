import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> word = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            word.add(br.readLine());
        }
        word.sort((String a, String b) -> {
            return a.length() - b.length();
        });
        ArrayList<String> s = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String now = word.get(i);
            int cnt=0;
            for(int j = i+1 ; j < n; j++){
                String substring = word.get(j).substring(0, now.length());
                if(now.equals(substring)){
                    cnt++;
                }
            }
            if(cnt == 0){
                s.add(now);
            }
        }
        System.out.println(s.size());

        bw.flush();
        bw.close();
    }
}
