import javax.lang.model.SourceVersion;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] table = new int[n][2];
        for (int i = 0; i < n; i++) {
            table[i][0] = sc.nextInt();
            table[i][1] = sc.nextInt();
        }

        Arrays.sort(table, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        int prev_end = -1;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (table[i][0] >= prev_end) {
                prev_end = table[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
