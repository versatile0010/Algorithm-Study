import java.io.*;
import java.util.*;

public class Main {
    static String X;
    static int[] arr;
    static boolean[] used;
    static int[] num;
    static int ans = Integer.MAX_VALUE;

    public static void dfs(int depth) {
        if (depth == X.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < depth; i++) {
                sb.append(num[i]);
            }
            int number = Integer.parseInt(sb.toString());
            if (Integer.parseInt(X) < number) {
                ans = Math.min(ans, number);
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    num[depth] = arr[i];
                    dfs(depth + 1);
                    used[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        X = br.readLine();
        arr = new int[X.length()];
        used = new boolean[X.length()];
        num = new int[X.length()];
        for (int i = 0; i < X.length(); i++) {
            arr[i] = X.charAt(i) - '0';
        }
        Arrays.sort(arr);

        dfs(0);

        if(ans == Integer.MAX_VALUE){
            System.out.println("0");
        } else {
            System.out.println(ans);
        }
        bw.flush();
        bw.close();
    }
}
