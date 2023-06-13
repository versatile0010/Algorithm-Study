import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        HashSet<String> nm = new HashSet<>();
        HashSet<String> mm = new HashSet<>();
        for (int i = 0; i < n; i++) {
            nm.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            mm.add(br.readLine());
        }
        ArrayList<String> list = new ArrayList<>();

        if(n < m){
            for(String iter : nm){
                if(mm.contains(iter)){
                    list.add(iter);
                }
            }
        } else {
            for(String iter : mm){
                if(nm.contains(iter)){
                    list.add(iter);
                }
            }
        }

        bw.write(list.size()+"\n");
        Collections.sort(list);
        for(String iter : list){
            bw.write(iter+"\n");
        }
        bw.flush();
        bw.close();
    }
}
