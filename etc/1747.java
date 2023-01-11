import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] arr = new int [1004001];
        for(int i = 2 ; i < arr.length; i++){
            arr[i] = i;
        }
        for(int i = 2; i < Math.sqrt(arr.length); i++){
            if(arr[i]==0)continue;
            for(int j = i+i; j<arr.length; j += i){
                arr[j] = 0;
            }
        }

        int k = N;
        while(true){
            if(arr[k] != 0){
                // 소수이면
                int prime = arr[k];
                if(check(prime)/*팰린드롬 수이면*/){
                    System.out.println(prime);
                    break;
                }
            }
            k++;
        }
    }
    public static boolean check(int prime){
        char str [] = String.valueOf(prime).toCharArray();
        int s = 0;
        int e = str.length-1;
        boolean flag = true;
        while(s<e){
            if(str[s]!=str[e]){
                flag = false;
                break;
            }
            s++;
            e--;
        }
        return flag;
    }
}
