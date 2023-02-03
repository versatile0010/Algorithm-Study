import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int [] base = new int[100001];
    static int [] tree = new int[400001];
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int n = Integer.parseInt(br.readLine()); // 리프노드 개수

        stk = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            base[i] = Integer.parseInt(stk.nextToken());
        }
        init(1, 1, n);
        int m = Integer.parseInt(br.readLine());// 쿼리의 개수
        for(int i = 0 ; i < m ; i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            if(a==1){
                // update
                update(1, 1, n, b, c);
            } else if(a==2){
                // get_min
                System.out.println(query(1, 1, n, b, c));
            } else return;
        }

        bw.flush();
        bw.close();
    }
    private static void update(int node, int start, int end, int idx, int val){
        if(idx<start || idx>end)
            return;
        if(start==end){
            tree[node] = idx;
            base[idx] = val;
            return;
        }
        int mid = (start+end)/2;
        update(node*2, start, mid, idx, val);
        update(node*2+1, mid+1, end, idx, val);
        if(base[tree[node*2]]<=base[tree[node*2+1]]){
            tree[node] = tree[node*2];
        } else tree[node] = tree[node*2+1];
    }
    private static int query(int node, int start, int end, int left, int right){
        if(left > end || right < start)
            return -1;
        else if(left<=start&&end<=right){
            return tree[node];
        }
        int mid = (start+end)/2;
        int minl = query(node*2, start, mid, left, right);
        int minr = query(node*2+1, mid+1, end, left, right);
        if(minl==-1){
            return minr;
        } else if(minr==-1){
            return minl;
        } else {
            if(base[minl]<=base[minr]){
                return minl;
            } else return minr;
        }
    }
    private static void init(int node, int start, int end){
        if(start==end){
            tree[node] = start;
        } else {
            int mid =(start+end)/2;
            init(node*2, start, mid);
            init(node*2+1, mid+1, end);
            if(base[tree[node*2]]<=base[tree[node*2+1]])
                tree[node] = tree[node*2];
            else tree[node] = tree[node*2+1];
        }
    }

}
