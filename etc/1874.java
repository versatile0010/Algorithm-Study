import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer ans = new StringBuffer();
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        int num = 1;
        Stack<Integer> st = new Stack<>();
        boolean flag = true;
        for(int i = 0 ; i <n ; i++){
            int t = arr[i];
            while(num <= t){
                st.push(num++);
                ans.append("+\n");
            }
            if(arr[i] != st.peek()){
                System.out.println("NO");
                flag = false;
                break;
            } else {
                st.pop();
                ans.append("-\n");
            }
        }
        if(flag)
            System.out.println(ans.toString());
    }
}
