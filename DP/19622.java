import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int n = Integer.parseInt(br.readLine());
        int[] peoples = new int[n + 1];

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            int p = Integer.parseInt(stk.nextToken());
            peoples[i] = p;
        }
        // 회의 K는 K-1과 K+1과만 시간이 겹치며 다른 회의와는 시간이 겹치지 않는다.
        // 순차 탐색을 고려하였을 때,
        // K 번째 상황에서의 최적은 1. K 번째 회의를 배정하지 않고 K-1 번째 회의를 배정한 경우와
        //                       2. k-2, K 번째 회의를 배정한 경우 중 사람의 수가 더 많은 경우이다.

        int[] dp = new int[n];
        dp[0] = peoples[0];
        if(n > 1) dp[1] = Math.max(peoples[0], peoples[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + peoples[i]);
        }
        System.out.println(dp[n - 1]);

        bw.flush();
        bw.close();
    }
}
