import java.io.*;
import java.util.Scanner;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);

    }
    public static void dfs(int n, int digit){
        if(digit==N){
            if(isprime(n))
                System.out.println(n);
            return;
        }
        for(int i = 1 ; i<=9; i++){
            if(isprime(10*n + i)){
                dfs(10*n+i, digit+1);
            }
        }
    }
    public static boolean isprime(int n){
        for(int i = 2; i < n; i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
}
