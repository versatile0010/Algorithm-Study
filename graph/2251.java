import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] now;
    static boolean[][] visited;
    static boolean ans[];
    static int[] receiver = {0, 0, 1, 1, 2, 2};
    static int[] sender = {1, 2, 0, 2, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        now = new int[3];
        now[0] = sc.nextInt();
        now[1] = sc.nextInt();
        now[2] = sc.nextInt();
        visited = new boolean[201][201];
        ans = new boolean[201];
        bfs();
        for (int i = 0; i < 201; i++) {
            if (ans[i])
                System.out.print(i + " ");
        }
    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        visited[0][0] = true;
        ans[now[2]] = true;
        while (!q.isEmpty()) {
            Node p = q.poll();
            int a = p.a;
            int b = p.b;
            int c = now[2] - a - b;
            for (int dir = 0; dir < 6; dir++) {
                int[] next = {a, b, c};
                next[receiver[dir]] += next[sender[dir]];
                next[sender[dir]] = 0;
                if (next[receiver[dir]] > now[receiver[dir]]) {
                    // 물이 넘치면
                    next[sender[dir]] = next[receiver[dir]] - now[receiver[dir]];
                    next[receiver[dir]] = now[receiver[dir]];
                }
                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    q.add(new Node(next[0], next[1]));
                    if (next[0] == 0) {
                        ans[next[2]] = true;
                    }
                }
            }
        }
    }

    static class Node {
        int a;
        int b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
