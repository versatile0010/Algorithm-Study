import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine()); // 수열의 크기
        int [] arr = new int [n];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++)
            arr[i] = Integer.parseInt(stk.nextToken());
        int target = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int left = 0;
        int right = n-1;
        int sum = 0;
        int cnt = 0;
        while(left<right){
            sum = arr[left] + arr[right];
            if(sum < target){
                left++;
            } else if(sum > target){
                right--;
            } else { // sum == target
                cnt++;
                left++;
            }
        }
        System.out.println(cnt);
    }
}
