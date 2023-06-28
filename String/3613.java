import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        String input = br.readLine();
        if(isitCppType(input)){
            cppToJava(input);
        } else if(isitJavaType(input)){
            javaToCpp(input);
        } else {
            System.out.println("Error!");
        }

        bw.flush();
        bw.close();
    }

    static boolean isitJavaType(String str) {
        if (str.contains("_") || str.contains(" ")) return false;
        if (str.length() >= 2 && (str.charAt(0) >= 'A' && str.charAt(0) <= 'Z')) return false;
        return true;
    }

    static boolean isitCppType(String str) {
        if(str.charAt(0)=='_'){
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                return false;
            }
        }
        for(int i = 0 ; i < str.length()-1; i++){
            if(str.charAt(i) == str.charAt(i+1) && str.charAt(i+1) == '_'){
                return false;
            }
        }
        int idx = str.length() - 1;
        if (!(str.charAt(idx) >= 'a' && str.charAt(idx) <= 'z')) return false;
        return true;
    }

    static void cppToJava(String str) {
        StringTokenizer stk = new StringTokenizer(str, "_");
        StringBuilder sb = new StringBuilder();
        sb.append(stk.nextToken());
        while (stk.hasMoreTokens()) {
            StringBuilder token = new StringBuilder(stk.nextToken());
            token.setCharAt(0, (char) (token.charAt(0) - 'a' + 'A'));
            sb.append(token);
        }
        System.out.println(sb);
    }

    static void javaToCpp(String str) {
        StringBuilder sb = new StringBuilder();
        int prevIdx = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                sb.append("_");
                sb.append((char) (str.charAt(i) - 'A' + 'a'));
            } else {
                sb.append(str.charAt(i));
            }
        }
        System.out.println(sb);
    }
}
