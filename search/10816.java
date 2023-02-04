//500000*log(10000000)

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int n = Integer.parseInt(br.readLine()); // 숫자카드의 개수
        int [] arr = new int[n];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        int m = Integer.parseInt(br.readLine()); // 쿼리 개수

        Arrays.sort(arr);

        stk = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < m ; i++){
            int ele = Integer.parseInt(stk.nextToken());
            bw.write(upper_bound(arr, ele)-lower_bound(arr, ele)+" ");
        }
        bw.flush();
        bw.close();
    }
    private static int lower_bound(int [] arr, int target){
        int left = 0;
        int right = arr.length;
        int mid = 0;
        while(left<right){
            mid = (left+right)/2;
            if(arr[mid]>=target){
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return right;
    }
    private static int upper_bound(int [] arr, int target){
        int left = 0;
        int right = arr.length;
        int mid = 0;
        while(left<right){
            mid = (left+right)/2;
            if(arr[mid]<=target){
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
