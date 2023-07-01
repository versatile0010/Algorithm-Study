import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        HashMap<String, Integer> hm = new HashMap<>();
        String word = "";
        int cnt = 0;
        while ((word = br.readLine()) != null) {
            cnt++;
            hm.put(word, hm.getOrDefault(word, 0)+1);
        }
        ArrayList<String> list = new ArrayList<>(hm.keySet());
        list.sort(String::compareTo);
        for(String ele : list){
            double f = (double)(hm.get(ele) * 100 )/ cnt;
            System.out.print(ele + " ");
            System.out.printf("%.4f \n", f);
        }

        bw.flush();
        bw.close();
    }
}
