import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main{
    static int n;
    static int m;
    //static boolean [] visited;
    static int [] arr;
    static BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out)
    );
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        //visited = new boolean[n+1];
        arr = new int[n+1];
        dfs(0);
        bw.flush();
        bw.close();
    }
    static void dfs(int depth) throws IOException {
        if(depth==m){
            for(int i = 0 ; i < m ; i++)
                bw.write(arr[i]+" ");
            bw.write("\n");
            return;
        }
        else{
            int start = 1;
            if(depth!=0) start = arr[depth-1];
            for(int i = start ; i <=n; i++){
                arr[depth]=i;
                dfs(depth+1);
            }
        }
    }
}
