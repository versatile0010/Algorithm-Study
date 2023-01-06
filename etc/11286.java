import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       int n;
       Scanner sc = new Scanner(System.in);
       n = sc.nextInt();

       PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->{
          int a = Math.abs(o1);
          int b = Math.abs(o2);
          if(a==b){
              return o1>o2?1:-1;
          }
          else{
              return a-b;
          }
       });

       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       for(int i = 0; i < n ; i++){
           int request = sc.nextInt();
           if(request==0){
               if(pq.isEmpty()) bw.write("0\n");
               else {
                   bw.write(pq.poll() + "\n");
               }
           } else{
               pq.add(request);
           }
       }
       bw.flush();
       bw.close();
    }
}
