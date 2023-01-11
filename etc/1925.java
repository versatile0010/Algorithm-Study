import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int m, n; // m<=n<=1,000,000
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        int[] arr = new int[n + 1];
        for (int i = 2; i <= n; i++)
            arr[i] = i;

        for (int i = 2; i * i <= n; i++) {
            if (arr[i] == 0) continue;
            for (int j = i + i; j <= n; j += i) {
                arr[j] = 0;
            }
        }
        for (int i = m; i <= n; i++) {
            if (arr[i] != 0)
                System.out.println(arr[i]);
        }
    }
}
