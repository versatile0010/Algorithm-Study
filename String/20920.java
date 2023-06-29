import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());  // 단어 개수
        int m = Integer.parseInt(stk.nextToken());  // m 이상인 단어만 외움
        HashMap<String, Integer> hm = new HashMap<>();
        while (n-- > 0) {
            String word = br.readLine();
            if (word.length() >= m) {
                hm.put(word, hm.getOrDefault(word, 0) + 1);
            }
        }
        ArrayList<String> list = new ArrayList<>(hm.keySet());

        list.sort((String a, String b) -> {
           if(hm.get(a) != hm.get(b)){
               return hm.get(b) - hm.get(a);
           } else if(a.length() != b.length()){
               return b.length() - a.length();
           } return a.compareTo(b);
        });
        for(String ele : list){
            bw.write(ele+"\n");
        }

        bw.flush();
        bw.close();
    }
}
