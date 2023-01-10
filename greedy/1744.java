import javax.lang.model.SourceVersion;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>();
        int ones=0;
        int zeros=0;
        for(int i = 0 ; i < n ; i++){
            int t = sc.nextInt();
            if(t>1){
                positive.add(t);
            }
            else if(t<0){
                negative.add(t);
            }
            else if (t == 0) {
                zeros++;
            }
            else{
                ones++;
            }
        }
        int sum = 0;
        while(positive.size()>1){
            int a = positive.remove();
            int b = positive.remove();
            sum += a*b;
        }
        if(!positive.isEmpty()){
            sum+=positive.remove();
        }

        while(negative.size()>1){
            int a= negative.remove();
            int b= negative.remove();
            sum += a*b;
        }
        if (!negative.isEmpty()){
            if(zeros==0){
                sum+=negative.remove();
            }
        }
        sum+=ones;
        System.out.println(sum);

    }
}
