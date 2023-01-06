import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        int [] arr = new int[n];
        int [] ans = new int[n];

        stk = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++)
            arr[i] = Integer.parseInt(stk.nextToken());
        Stack<Integer> st = new Stack<>();

        st.push(0);
        for(int i = 1 ; i < n ; i ++){
            while(!st.isEmpty() && arr[st.peek()] < arr[i]){
                int idx = st.pop();
                ans[idx] = arr[i];
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int idx = st.pop();
            ans[idx] = -1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0 ; i < n ; i++)
            bw.write(ans[i]+" ");
        bw.flush();
        bw.close();
    }
}
