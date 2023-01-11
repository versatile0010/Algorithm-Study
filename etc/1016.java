import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        boolean[] arr = new boolean[(int) (max - min + 1)];
        for (int i = 2; i <= Math.sqrt(max); i++) {
            long p = (long) i * i;
            long st = min / p;
            if (min % p != 0)
                st++;
            for (long j = st; j * p <= max; j++) {
                int idx = (int) (j * p - min);
                arr[idx] = true;
            }
        }
        int cnt = 0;
        for (int i = 0; i <= max - min; i++) {
            if (!arr[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
