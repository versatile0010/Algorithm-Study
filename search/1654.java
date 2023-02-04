import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(stk.nextToken()); // 랜선의 개수
        int n = Integer.parseInt(stk.nextToken()); // 만들고자 하는 랜선 개수
        int [] arr = new int[k];
        long max_ele = -1;
        for(int i = 0 ; i < k; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max_ele = Math.max(arr[i], max_ele);
        }
        long left = 1;
        long right = max_ele+1;
        long mid = 0 ;
        long target = n;
        long ans = 0;
        while(left<=right){ // 이분 탐색
            mid = (left+right)/2;  // mid 의 길이로 랜선을 자르는 상황을 가정
            long cnt = 0;
            for(int i = 0 ; i < k ; i++){
                if(mid!=0)
                    cnt += arr[i]/mid;
            }
            // 최대 길이를 얻고자 함
            if(cnt >= target){
                ans = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
//            if(cnt <= target){
//                right = mid-1;
//            } else {
//                left = mid+1;
//            }
        }
        System.out.println(right);
    }
}
