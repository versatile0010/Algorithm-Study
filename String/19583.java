import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(br.readLine());
        String start = stk.nextToken();
        String meetEnd = stk.nextToken();
        String StreamEnd = stk.nextToken();

        HashSet<String> s1 = new HashSet<>();
        HashSet<String> s2 = new HashSet<>();

        String input = "";
        while ((input = br.readLine()) != null) {
            stk = new StringTokenizer(input);
            String time = stk.nextToken();
            String id = stk.nextToken();

            if(isSameOrBefore(time, start)){
                s1.add(id);
            }
            if(isSameOrAfter(time, meetEnd) && isSameOrBefore(time, StreamEnd)){
                s2.add(id);
            }
        }
        int cnt=0;
        for(String id : s1){
            if(s2.contains(id)){
                cnt++;
            }
        }
        System.out.println(cnt);

        bw.flush();
        bw.close();
    }

    public static boolean isSameOrBefore(String a, String b) {
        // a 시간과 b 시간을 비교하여 a 시간이 b 보다 같거나 더 이르면 true 를 반환
        String[] ainfo = a.split(":"); // ainfo[0] : hour, ainfo[1] : minute
        String[] binfo = b.split(":");
        int ah = Integer.parseInt(ainfo[0]);
        int am = Integer.parseInt(ainfo[1]);
        int bh = Integer.parseInt(binfo[0]);
        int bm = Integer.parseInt(binfo[1]);

        if(ah != bh){
            return ah <= bh;
        } else {
            return am <= bm;
        }
    }

    public static boolean isSameOrAfter(String a, String b) {
        // a 시간과 b 시간을 비교하여 a 시간이 b 보다 같거나 더 늦으면 true 를 반환
        String[] ainfo = a.split(":"); // ainfo[0] : hour, ainfo[1] : minute
        String[] binfo = b.split(":");
        int ah = Integer.parseInt(ainfo[0]);
        int am = Integer.parseInt(ainfo[1]);
        int bh = Integer.parseInt(binfo[0]);
        int bm = Integer.parseInt(binfo[1]);

        if(ah != bh){
            return ah >= bh;
        } else {
            return am >= bm;
        }
    }
}
