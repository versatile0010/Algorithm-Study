import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String given = sc.next();
        String [] subs = given.split("-");
        int ans = 0;
        for(int i = 0 ; i < subs.length; i++){
            int s = sums(subs[i]);
            if (i == 0) {
                ans += s;
            } else {
                ans -= s;
            }
        }
        System.out.println(ans);
    }
    public static int sums(String str){
        String [] subs = str.split("\\+");
        int s=0;
        for (String sub : subs) {
            s+=Integer.parseInt(sub);
        }
        return s;
    }
}
