import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        String str = br.readLine();
        int n = str.length();
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int now = str.charAt(i);
            if (st.isEmpty()) {
                st.add(now);
            } else if (st.peek() == ')' && now == '(') {
                st.pop();
            } else if (st.peek() == ')' && now != '('){
                st.add(now);
            } else if (st.peek() == '(' && now == '('){
                st.add(now);
            } else if (st.peek() == '(' && now == ')'){
                st.add(now);
            }
        }
        System.out.println(st.size());
        bw.flush();
        bw.close();
    }
}
