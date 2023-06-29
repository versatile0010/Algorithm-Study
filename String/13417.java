import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine()); // 카드 개수
            char[] cards = new char[n];
            stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                cards[i] = stk.nextToken().charAt(0);
            }
            LinkedList<Character> list = new LinkedList<>();
            list.addFirst(cards[0]);
            for (int i = 1; i < n; i++) {
                if(cards[i] <= list.get(0)){
                    list.addFirst(cards[i]);
                } else {
                    list.addLast(cards[i]);
                }
            }
            for(int i = 0 ; i < n ; i++){
                System.out.print((char)list.get(i));
            }
            System.out.println();
        }

        bw.flush();
        bw.close();
    }
}
