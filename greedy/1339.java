import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main{
	static int [] m = new int [26];
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 단어의 개수 // 10개이하
		String [] word = new String[n+1];
		for(int i = 0 ; i < n ; i ++) {
			word[i] = sc.next();
		}
		
		for(int i = 0 ; i < n ; i++) {
			int t = (int) Math.pow(10, word[i].length()-1);
			for(int j = 0 ; j < word[i].length() ; j++) {
				m[(int)word[i].charAt(j)-'A']+=t;
				t/=10;
			}
		}
		
		int weight = 9;
		
		Arrays.sort(m);
		int ans = 0;
		for(int i = 25 ; i >= 0; i--){
			if(m[i]==0)
				break;
			int t = m[i]*weight;
			ans+=t;
			weight--;
		}
		System.out.println(ans);
	}
}
