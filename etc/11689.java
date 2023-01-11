import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long ans = n;
        for(long p = 2 ; p <= Math.sqrt(n); p++){
            if(n%p==0){
                ans = ans - ans/p;
                while(n%p==0)
                    n/=p;
            }
        }
        if(n>1)
            ans = ans-ans/n;
        System.out.println(ans);
    }

}
