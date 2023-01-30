import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main{
	static char[] alpha; // 사용가능한 알파벳을 담음
	static int l;
	static int c;
	static int aeiou_cnt;
	static int other_cnt;
	static boolean isgood;
	static boolean [] isused;
	static int [] arr;
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		l = sc.nextInt(); // 암호의 길이
		c = sc.nextInt(); // 사용 가능한 문자의 개수
		
		alpha = new char[c];
		isused = new boolean[30];
		arr = new int[30];
		
		for(int i = 0 ; i < c; i++) {
			alpha[i] = sc.next().charAt(0);
		} // 입력받음
		Arrays.sort(alpha);
		solve(0);
	}
	public static boolean check(char a) {
		if(a=='a'||a=='e'||a=='i'||a=='o'||a=='u')
			return true;
		else return false;
	}
	public static void solve(int depth) {
		if(depth == l) {
			// l 개의 글자를 가진 암호를 만들었다면
			// 유효성을 검증해야 한다.
			// 먼저 자음/모음 개수를 체크하자
			aeiou_cnt=0;
			other_cnt=0;
			isgood=false;
			
			for(int i = 0 ; i < l ; i++) {
				if(check(alpha[arr[i]])) {
					aeiou_cnt++; // 모음개수
				} else {
					other_cnt++; // 자음개수
				}
			}

			if(aeiou_cnt>=1 && other_cnt>=2) {
				// 모음 최소 1개 이상, 자음 최소 2개 이상이면
				isgood=true; // 유효한 암호임
			}
			if(isgood) {
				// 유효한 코드이면 출력하자
				for(int i = 0 ; i < l; i++) {
					System.out.print(alpha[arr[i]]);
				} System.out.println();
				return;
			}
		} else { // 백트래킹
			int start = 0;
			if(depth!=0) start = arr[depth-1]+1;
			for(int i = start; i < c; i++) {
				if(!isused[i]) {
					// 사용하지 않은 알파벳이라면
					isused[i]=true;// 사용하자
					arr[depth] = i;
					solve(depth+1);
					isused[i]=false;
				}
			}
		}
	}
}
