import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        Node root = new Node();
        int cnt = 0;
        // 트라이 구축
        while (n > 0) {
            String str = br.readLine();
            Node now = root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                int idx = c - 'a';
                if (now.next[idx] == null) {
                    now.next[idx] = new Node();
                }
                now = now.next[idx];
                if (i == str.length() - 1) {
                    now.isEnd = true;
                }
            }
            n--;
        }
        while (m > 0) {
            String str = br.readLine();
            Node now = root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                int idx = c - 'a';
                if (now.next[idx] == null)
                    break;
                now = now.next[idx];
                if (i == str.length() - 1 && now.isEnd) {
                    cnt++;
                }
            }
            m--;
        }
        System.out.println(cnt);
    }

static class Node {
    Node[] next = new Node[26];
    boolean isEnd;
}
}
