import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        long a, b;
        Scanner sc = new Scanner(System.in);
        a=sc.nextLong();
        b=sc.nextLong();
        long g = gcd(a, b);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(long i = 0; i < g; i++){
            bw.append('1');
        }
        bw.flush();
        bw.close();
    }

    public static long gcd(long a, long b){
        if(b==0)
            return a;
        else return gcd(b, a%b);
    }
}
