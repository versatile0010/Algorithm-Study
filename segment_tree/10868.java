import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static long [] base = new long[100001];
    static long [] tree = new long[100001*4];
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken()); // 리프노드 개수
        int m = Integer.parseInt(stk.nextToken()); // 쿼리 개수
        for(int i = 1 ; i<=n; i++){
            base[i] = Long.parseLong(br.readLine());
        }
        init(1, 1, n);
        for(int i = 0 ; i < m ; i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b= Integer.parseInt(stk.nextToken());
            // a~b 까지의 최솟값을 찾자.
            System.out.println(get_min(1, 1, n, a, b));
        }

        bw.flush();
        bw.close();
    }
    private static long get_min(int node, int start, int end, int left, int right){
        if(left > end || right < start)
            return Integer.MAX_VALUE;
        if(left<=start&&end<=right){
            return tree[node];
        }
        int mid = (start+end)/2;
        return Math.min(
                get_min(node*2, start, mid, left, right) , get_min(node*2+1, mid+1, end, left, right)
        );
    }
    private static void update(int node, int start, int end, int idx, long val){
        long diff = Math.min(val, base[idx]);
        base[idx] = val;
        update_diff(node, start, end, idx, diff);
    }
    private static void update_diff(int node, int start, int end, int idx, long diff){
        if(idx < start || idx > end)
            return;
        tree[node] = Math.min(tree[node], diff);
        if(start==end){
            base[idx] = tree[node];
            return;
        }
        int mid =(start+end)/2;
        update_diff(node*2, start, mid, idx, diff);
        update_diff(node*2+1, mid+1, end, idx, diff);
    }
    private static long init(int node, int start, int end){
        if(start==end) { // 리프노드
            return tree[node] = base[start];
        } else {
            int mid = (start+end)/2;
            return tree[node] = Math.min(init(node*2, start, mid), init(node*2+1, mid+1, end));
        }
    }
}
