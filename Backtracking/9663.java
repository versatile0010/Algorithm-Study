import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int n;
    static int cnt;
    static boolean [] check_1; // 상하
    static boolean [] check_2; // 상향대각
    static boolean [] check_3; // 하향대각
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); //  입력
		
		check_1 = new boolean[50];
		check_2 = new boolean[50];
		check_3 = new boolean[50];
		
		nqueens(0);
		System.out.println(cnt);
	}
	static void nqueens(int depth) {
		if(depth==n) { // n 번째 행에 도달하면
			cnt++; // 카운팅
			return; 
		}
		else {
			for(int i = 0; i < n ; i ++) { // 각 행에는 퀸 한개만 놓을 수 있음
				if(check_1[i]||check_2[depth+i]||check_3[depth-i+n-1]) // 해당 위치에서 퀸을 놓을 수 없다면
					continue; 
				else {
					check_1[i]=true; // 해당 퀸의 공격 범위를 모두 마킹
					check_2[depth+i]=true;
					check_3[depth-i+n-1]=true;
					
					nqueens(depth+1); // 다음 행에 퀸을 놓으러 가기
					
					check_1[i]=false; 
					check_2[depth+i]=false;
					check_3[depth-i+n-1]=false;
				}
			}
		}
	}
	
}
