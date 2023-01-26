import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();
        long[] dp = new long[21];
        // 순열 테이블 작성
        dp[0] = 1;
        for (int i = 1; i <= 20; i++)
            dp[i] = dp[i - 1] * i;
        // 문제 종류를 입력받음
        boolean[] visited = new boolean[21];
        int type = sc.nextInt();
        if (type == 1) { // 순열을 구하는 소문제
            long k = sc.nextLong(); // 구해야 하는 순열의 순서를 입력받음.
            for (int i = 1; i <= n; i++) {
                for (int j = 1, cnt = 1; j <= n; j++) {
                    if (visited[j])
                        continue; // 중복된 수를 사용하지 않기 위함
                    if (k <= cnt * dp[n - i]) {
                        k = k - (cnt - 1) * dp[n - i];
                        bw.write(j + " ");
                        visited[j] = true;
                        break;
                    }
                    cnt++;
                }
            }
        } else if (type == 2) { // 순열의 순서를 구하는 소문제
            int[] nums = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                nums[i] = sc.nextInt(); // 순열을 입력받음
            }
            long ans = 1;
            for (int i = 1; i <= n; i++) {
                long cnt = 0;
                for (int j = 1; j < nums[i]; j++) {
                    if (!visited[j])
                        cnt++; // 사용하지 않은 숫자를 카운트
                }
                ans = ans + cnt*dp[n-i];
                visited[nums[i]] = true;
            }
            bw.write(String.valueOf(ans));
        } else return;
        bw.flush();
        bw.close();
    }
}
