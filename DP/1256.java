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
        int m = sc.nextInt();
        long k = sc.nextLong();

        long[][] dp = new long[202][202];
        // 1. 조합 테이블 구성하기
        for (int i = 0; i <= 200; i++) {
            dp[i][1] = i; // ex) 3C1 = 3
            dp[i][0] = 1; // ex) 3C0 = 1
            dp[i][i] = 1; // ex) 3C3 = 1
        }
        for (int i = 1; i <= 200; i++) {
            for (int j = 1; j <= i; j++) {
                // i 개에서 j 개를 뽑을 때 j 가 i 보다 클 수는 없음.
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                // 예를 들어 5개 중 3 개를 선택해야 하는 경우의 수를 구한다면
                // 이는 4개 중에서 2개를 선택하고 마지막에 한번 더 선택하는 경우의 수와
                // 4개 중에서 3개를 선택하고 마지막에 선택을 하지 않은 경우의 수의 합과 같음.
                if (dp[i][j] > 1000000000)
                    dp[i][j] = 1000000001; // 오버 플로우를 방지하기 위해 k 값의 최대로 제한함.
            }
        }
        // 2. 예외 처리
        if (dp[m + n][m] < k) {
            // 사전은 a 와 z 로만 이루어져 있으므로 (m+n) 개 중에서 m 개 혹은 n 개를 선택하는
            // 경우의 수 만큼의 문자가 존재하기 때문에,
            // m+n 개 중에서 m 개를 선택하는 경우의 수가 k 개 보다 작다면 
            // k 번째 문자열이 존재하지 않는 경우이다. 그러한 경우에는 -1 을 출력
            System.out.println("-1");
            return; // 메인 메서드 종료
        }
        // 3. 주어진 문자열 만들기
        while (!(n == 0 && m == 0)) { // 'a' 와 'z' 를 다 사용할 때 까지 반복
            // 만약 a 를 선택했다면?
            if (dp[m + n - 1][m] >= k) { // a 를 선택했다고 치고 나머지 문자열의 경우의수와 k 를 비교
                bw.append("a");
                n--; // a 를 하나 사용한 것이니까 개수 감소
            } else { // 근데 k 가 더 크다면, a 를 선택하면 k 번째 문자열을 만들 수 없어서 안된다는 것임
                // 그러니까 z 를 선택해야 함.
                bw.append("z");
                k = k - dp[m + n - 1][m]; // z 를 선택한 것으로 경우의 수를 업데이트 함
                m--; // z 를 하나 사용한 것이니까 개수 감소
            }
        }
        bw.flush();
        bw.close();
    }
}
