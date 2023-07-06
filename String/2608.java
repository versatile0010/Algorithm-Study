import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
    static HashMap<String, Integer> table = new HashMap<>();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        String a = br.readLine();
        String b = br.readLine();

        initTable();
        int target = decode(a) + decode(b);
        System.out.println(target);
        System.out.println(encode(target));
        bw.flush();
        bw.close();
    }

    static int decode(String str) {
        int idx = 0;
        int n = str.length();
        int val = 0;
        while (idx < str.length()) {
            if (idx + 1 < n && (str.charAt(idx) == 'I' || str.charAt(idx) == 'X' || str.charAt(idx) == 'C')) {
                if (table.containsKey(str.substring(idx, idx + 2))) {
                    val += table.get(str.substring(idx, idx + 2));
                    idx += 2;
                    continue;
                }
            }
            val += table.get(str.substring(idx, idx + 1));
            idx++;
        }
        return val;
    }

    static String encode(int code) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Entry<String, Integer>> list = new ArrayList<>(table.entrySet());
        list.sort((Entry<String, Integer> a, Entry<String, Integer> b) -> {
            return b.getValue() - a.getValue();
        });
        while (code > 0) {
            int div = 0;
            int re = 0;
            for (Entry<String, Integer> ele : list) {
                String key = ele.getKey();
                int val = ele.getValue();
                div = code / val;
                re = code % val;
                while (div-- > 0) {
                    sb.append(key);
                }
                code = re;
            }
        }

        return sb.toString();
    }

    static void initTable() {
        table.put("M", 1000);
        table.put("CM", 900);
        table.put("D", 500);
        table.put("CD", 400);
        table.put("C", 100);
        table.put("XC", 90);
        table.put("L", 50);
        table.put("XL", 40);
        table.put("X", 10);
        table.put("IX", 9);
        table.put("V", 5);
        table.put("IV", 4);
        table.put("I", 1);
    }
}
