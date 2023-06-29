import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();
        while (n-- > 0) {
            String[] input = br.readLine().split("\\.");
            list.add(input[1]);
        }
        list.sort(String::compareTo);
        TreeMap<String, Integer> hm = new TreeMap<>();
        for (String ele : list) {
            hm.put(ele, hm.getOrDefault(ele, 0) + 1);
        }
        for (String key : hm.keySet()){
            System.out.println(key + " " +  hm.get(key));
        }

        bw.flush();
        bw.close();
    }
}
