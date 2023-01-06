import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] arr = new Node[n];
        for(int i = 0 ; i < n ; i++){
            int t = Integer.parseInt(br.readLine());
            arr[i] = new Node(t, i);
        }
        Arrays.sort(arr);

        int max_dist=0;
        for(int i = 0 ; i < n ; i++){
            if(max_dist < arr[i].idx - i)
                max_dist = arr[i].idx - i;
        }
        System.out.println(max_dist+1);
    }
    static class Node implements Comparable<Node>{
        int value;
        int idx;
        public Node(int value, int idx){
            this.value = value;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o){
            return this.value - o.value;
        }
    }
}
