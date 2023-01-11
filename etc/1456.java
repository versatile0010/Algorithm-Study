import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long a, b; // m<=n<=1,000,000
        Scanner sc = new Scanner(System.in);
        a = sc.nextLong();
        b = sc.nextLong();

        long[] arr = new long[10000001];
        for (int i = 2; i <= 10000000; i++)
            arr[i] = i;

        for (int i = 2; i <= Math.sqrt(10000000); i++) {
            if (arr[i] == 0) continue;
            for (int j = i + i; j <= 10000000; j = j + i) {
                arr[j] = 0;
            }
        }
        int cnt = 0;
        for (int i = 2; i <= 10000000; i++) {
            if (arr[i] != 0) {
                // 소수에 대하여
                long prime = arr[i];
                while ((double) arr[i] <= (double) b / (double) prime) {
                    if ((double) arr[i] >= (double) a / (double) prime)
                        cnt++;
                    prime = arr[i] * prime;
                }
            }
        }
        System.out.println(cnt);
    }
}
