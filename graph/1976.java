import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] parent;
    static int[][] graph;
    static int[] plan;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new int[n + 1][n + 1];
        plan = new int[m];
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++)
            parent[i] = i;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            plan[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        for(int i = 0 ; i < m ; i++){
            plan[i] = find(plan[i]);
        }
        boolean flag = Arrays.stream(plan).distinct().count() == 1;
        if(flag)
            System.out.println("YES");
        else System.out.println("NO");
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a) {
        if (a == parent[a])
            return a;
        else {
            return parent[a] = find(parent[a]);
        }
    }
}
