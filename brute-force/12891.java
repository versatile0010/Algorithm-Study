import java.io.IOException;
import java.util.*;

public class Main {
    static class limit {
        int A;
        int C;
        int G;
        int T;
        limit(int a, int c, int g, int t){
            this.A = a;
            this.C = c;
            this.G = g;
            this.T = t;
        }
    }
    static limit given;
    static limit present;
    static char [] origin;
    static char [] password;
    static int check;
    static int ans;

    public static void main(String[] args) throws IOException {
        int length_of_dna=0;
        int length_of_substring=0;
        Scanner sc = new Scanner(System.in);
        length_of_dna = sc.nextInt();
        length_of_substring = sc.nextInt();

        origin = new char[length_of_dna];
        password = new char[length_of_substring];

        origin = sc.next().toCharArray();

        given = new limit(0,0,0,0);
        present = new limit(0,0,0,0);

        given.A=sc.nextInt();
        given.C=sc.nextInt();
        given.G=sc.nextInt();
        given.T=sc.nextInt();

        if(given.A==0) check++;
        if(given.C==0) check++;
        if(given.G==0) check++;
        if(given.T==0) check++;

        for(int i = 0 ; i < length_of_substring; i++){
            add(origin[i]);
        }
        if(check == 4){
            ans++;
        }

        for(int i = length_of_substring; i < length_of_dna; i++){
            int j = i-length_of_substring;
            add(origin[i]);
            remove(origin[j]);
            if(check==4)
                ans++;
        }
        System.out.println(ans);
    }
    public static void add(char ele){
        switch(ele){
            case 'A':
                present.A++;
                if(present.A == given.A)
                    check++;
                break;
            case 'G':
                present.G++;
                if(present.G == given.G)
                    check++;
                break;
            case 'C':
                present.C++;
                if(present.C == given.C)
                    check++;
                break;
            case 'T':
                present.T++;
                if(present.T == given.T)
                    check++;
                break;
        }
    }
    public static void remove(char ele){
        switch(ele){
            case 'A':
                if(present.A == given.A)
                    check--;
                present.A--;
                break;
            case 'G':
                if(present.G == given.G)
                    check--;
                present.G--;
                break;
            case 'C':
                if(present.C == given.C)
                    check--;
                present.C--;
                break;
            case 'T':
                if(present.T == given.T)
                    check--;
                present.T--;
                break;
        }
    }
}
