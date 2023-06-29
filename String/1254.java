import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        String str = br.readLine();
        System.out.println(gen(str));

        bw.flush();
        bw.close();
    }

    public static int gen(String str) {
        for (int i = 0; i < str.length(); i++) {
            String subString = str.substring(i);
            if (check(subString)) {
                //StringBuilder post = new StringBuilder(str.substring(0, i));
                //System.out.println(str + post.reverse()); // <- 팰린드롬 문자열
                return str.length() + i;
            }
        }
        return str.length() * 2;
    }

    public static boolean check(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
