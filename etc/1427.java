import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char [] arr = new char[str.length()];
        Integer [] nums = new Integer[str.length()];
        arr = str.toCharArray();
        for(int i = 0 ; i < str.length(); i++){
            nums[i] = arr[i] - '0';
        }
        Arrays.sort(nums, (o1, o2)->{
           return o2-o1;
        });
        for(int i = 0 ; i < str.length(); i++)
            System.out.print(nums[i]);

    }
}
