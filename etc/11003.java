import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int index;
        int value;
        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int l = Integer.parseInt(stk.nextToken());

        Deque<Node> dq = new LinkedList<>();

        stk = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            int ele = Integer.parseInt(stk.nextToken());

            while(!dq.isEmpty() && dq.getLast().value > ele ){
                dq.removeLast();
            }
            dq.addLast(new Node(i, ele));

            if(dq.getFirst().index <= i-l){
                dq.removeFirst();
            }
            bw.write(dq.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }
}
