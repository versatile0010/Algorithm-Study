import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            pq.add(t);
        }
        int cnt = 0;

        while(pq.size()!=1){
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a+b);
            cnt += a+b;
        }

        System.out.println(cnt);
    }
}
