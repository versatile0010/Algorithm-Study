import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       int n;
       Scanner sc = new Scanner(System.in);
       n = sc.nextInt();

       Queue<Integer> q = new LinkedList<>();
       for(int i = 1 ; i<= n; i++)
           q.add(i);
       while(q.size()>1){
           q.poll();
           q.add(q.poll());
       }
        System.out.println(q.peek());
    }
}
