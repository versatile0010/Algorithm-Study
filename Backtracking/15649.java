import java.util.Scanner;

public class Main{
    static int n;
    static int m;
    static boolean [] visited;
    static int [] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n+1];
        arr = new int[n+1];
        dfs(0);
    }
    static void dfs(int depth){
        if(depth==m){
            for(int i = 0 ; i < m ; i++)
                System.out.print(arr[i]+" ");
            System.out.println();
            return;
        }
        else{
            for(int i = 1 ; i <=n; i++){
                if(!visited[i]){
                    visited[i]=true;
                    arr[depth]=i;
                    dfs(depth+1);
                    visited[i]=false;
                }
            }
        }
    }
}
