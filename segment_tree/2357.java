import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static long [] base = new long[100001];
    static long [] min_tree = new long[400001];
    static long [] max_tree = new long[400001];
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        for(int i = 1 ;i<=n; i++)
            base[i] = Long.parseLong(br.readLine());
        mintree_init(1, 1, n);
        maxtree_init(1, 1, n);

        for(int i = 0 ; i < m ; i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            long min = get_min(1, 1, n, a, b);
            long max = get_max(1, 1, n, a, b);
            bw.write(String.valueOf(min)+" "+String.valueOf(max)+"\n");
        }

        bw.flush();
        bw.close();
    }
    private static long mintree_init(int node, int start, int end){
        if(start==end){
            return min_tree[node] = base[start];
        } else{
            int mid = (start+end)/2;
            return min_tree[node] = Math.min(mintree_init(node*2, start, mid), mintree_init(node*2+1, mid+1, end));
        }

    }
    private static long maxtree_init(int node, int start, int end){
        if(start==end){
            return max_tree[node] = base[start];
        } else{
            int mid = (start+end)/2;
            return max_tree[node] = Math.max(maxtree_init(node*2, start, mid), maxtree_init(node*2+1, mid+1, end));
        }
    }
    private static long get_min(int node, int start, int end, int left, int right){
        if(left>end||right<start)
            return Long.MAX_VALUE;
        if(left<=start&&end<=right){
            return min_tree[node];
        }
        int mid = (start+end)/2;
        return Math.min(get_min(node*2, start, mid, left, right), get_min(node*2+1, mid+1, end, left, right));
    }
    private static long get_max(int node, int start, int end, int left, int right){
        if(left>end||right<start)
            return -1;
        if(left<=start&&end<=right)
            return max_tree[node];
        int mid = (start+end)/2;
        return Math.max(get_max(node*2, start, mid, left, right), get_max(node*2+1, mid+1, end, left, right));
    }

}
