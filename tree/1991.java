import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] tree;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 노드의 개수
        tree = new int[26][2];
        for (int i = 0; i < n; i++) {
            String [] temp = br.readLine().split(" ");
            int now_node = temp[0].charAt(0)-'A';
            char left = temp[1].charAt(0);
            char right = temp[2].charAt(0);

            if(left=='.'){
                tree[now_node][0] = -1;
            } else {
                tree[now_node][0] = left-'A';
            }
            if(right=='.'){
                tree[now_node][1] = -1;
            } else {
                tree[now_node][1] = right-'A';
            }
        }
        preorder(0);
        System.out.println();
        inorder(0);
        System.out.println();
        postorder(0);
        System.out.println();
    }
    static void preorder(int now){
        if(now==-1)
            return;
        System.out.print((char)(now+'A'));
        preorder(tree[now][0]);
        preorder(tree[now][1]);
    }
    static void postorder(int now){
        if(now==-1)
            return;
        postorder(tree[now][0]);
        postorder(tree[now][1]);
        System.out.print((char)(now+'A'));
    }
    static void inorder(int now){
        if(now==-1)
            return;
        inorder(tree[now][0]);
        System.out.print((char)(now+'A'));
        inorder(tree[now][1]);
    }
}
