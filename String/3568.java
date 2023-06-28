import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        String prefix = stk.nextToken();
        while (stk.hasMoreTokens()) {
            gen(prefix, stk.nextToken());
        }

        bw.flush();
        bw.close();
    }

    public static void gen(String prefix, String data) {
        StringBuilder variableName = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            if ((data.charAt(i) >= 'a' && data.charAt(i) <= 'z') ||
                    (data.charAt(i) >= 'A' && data.charAt(i) <= 'Z')) {
                variableName.append(data.charAt(i));
            } else break;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = data.length() - 1; i >= variableName.length(); i--) {
            if (data.charAt(i) == ',' || data.charAt(i) == ';') {
                continue;
            }
            if (data.charAt(i) == ']') {
                sb.append("[]");
                i--;
            } else {
                sb.append(data.charAt(i));
            }
        }
        System.out.print(prefix + sb + " ");
        System.out.println(variableName + ";");
    }
}
