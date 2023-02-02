import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static boolean[] visited;
    static int[] arr;
    static int[] base;
    static BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out)
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        visited = new boolean[n + 1];
        arr = new int[n + 1];
        base = new int[n + 1];

        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            base[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(base);
        dfs(0);
        bw.flush();
        bw.close();
    }

    static void dfs(int depth) throws IOException {
        if (depth == m) {
            for (int i = 0; i < m; i++)
                bw.write(base[arr[i]] + " ");
            bw.write("\n");
            return;
        } else {
            for (int i = 1; i <= n; i++) {
                arr[depth] = i;
                dfs(depth + 1);
            }
        }
    }
}
