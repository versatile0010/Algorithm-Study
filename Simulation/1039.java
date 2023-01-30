import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main{
    static int max = -1;
    static int n;
    static int m;
    static int k;
    static boolean [][] visited;
    static boolean possible;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //
        k = sc.nextInt(); // 연산 횟수
        visited = new boolean[1000001][11];

        int t = n;
        while(t>0) { // 자릿수 알아내기
            t/=10;
            m++;
        }

        bfs(new Node(n, 0));
    }

    static void bfs(Node v) {
        Queue<Node> q = new LinkedList<>();
        q.offer(v);
        visited[n][0] = true;

        while(!q.isEmpty()) {
            if(q.peek().cnt == k) {
                break;
            }
            Node now_node = q.poll();

            for(int i = 0; i < m-1; i++) {
                for(int j = i+1; j<m; j++){
                    // i 번째와 j 번째 자릿수를 swap 하기
                    int t = swap(now_node, i, j); // t 는 i 와 j 를 바꾼 숫자임
                    if(t!=-1&&!visited[t][now_node.cnt+1]) {
                        visited[t][now_node.cnt+1]=true;
                        q.offer(new Node(t, now_node.cnt+1));
                    }
                }
            }
        }
        while(!q.isEmpty()){
            Node now_node = q.poll();
            max = Math.max(max, now_node.num);
        }
        System.out.println(max);
    }
    static int swap(Node v, int a, int b) {
        char [] arr = String.valueOf(v.num).toCharArray();
        if(a==0&&arr[b]=='0') {
            return -1;
        }
        if(b==0&&arr[a]=='0') {
            return -1;
        }
        char t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;

        int w = (int)Math.pow(10, arr.length-1);

        int result=0;
        for(int i = 0 ; i < arr.length; i++) {
            result+=w*(arr[i]-'0');
            w/=10;
        }
        return result;
    }
    static class Node{
        int num;
        int cnt; // iteration
        public Node(int num, int cnt) {
            this.num=num;
            this.cnt=cnt;
        }
    }
}
