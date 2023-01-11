import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int g = 0;
            if ( a < b)
                g = a*b/gcd(b, a);
            else
                g = a*b/gcd(a, b);
            System.out.println(g);
        }
    }
    public static int gcd(int a, int b){
        if(b==0)
            return a;
        else return gcd(b, a%b);
    }
}