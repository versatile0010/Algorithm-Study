import java.util.Scanner;

public class Main {
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++)
            parent[i] = i;
        for (int i = 0; i < m; i++) {
            int type = sc.nextInt();
            int ele1 = sc.nextInt();
            int ele2 = sc.nextInt();
            if (type == 0) {
                // union
                union(ele1, ele2);
            } else {
                if (isSame(ele1, ele2)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
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

    public static boolean isSame(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return true;
        } else {
            return false;
        }
    }
}
