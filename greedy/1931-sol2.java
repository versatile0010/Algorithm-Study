import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        Stack<Integer> pq = new Stack<>();
        ArrayList<int[]> table = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            table.add(new int[]{s, e});
        }

        // 끝나는 시간이 빠른 순으로 정렬
        table.sort((int[] a, int[] b) -> {
            if(a[1]==b[1]){
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        for (int i = 0; i < table.size(); i++) {
            int[] now = table.get(i);
            if (pq.isEmpty()) {
                pq.add(now[1]);
            } else if (now[0] >= pq.peek()) {
                pq.add(now[1]);
            }
        }
        System.out.println(pq.size());

        bw.flush();
        bw.close();
    }
}
