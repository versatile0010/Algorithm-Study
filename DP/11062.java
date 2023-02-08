import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static final int first = 0;
	static final int last = 1;
	static int [][] dp;
	static int [] cards;
	private static int sol(int start, int end, int status) {
		if(start > end)
			return 0;
		if(dp[start][end]!=0) {
			return dp[start][end]; // memorization
		}
		if(status%2==1) { // 근우
			return dp[start][end] = Math.max(cards[start] + sol(start+1, end, status+1),
					cards[end] + sol(start, end-1, status+1));
		} else { 
			return dp[start][end] = Math.min(sol(start+1, end, status+1),
					sol(start, end-1, status+1));
		}
	}
	
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stk;
		
		int tc = Integer.parseInt(br.readLine());
		while(tc>0) {
			tc--;
			int N = Integer.parseInt(br.readLine()); // 카드의 개수
			dp = new int[N+1][N+1];
			cards = new int[N+1];
			stk = new StringTokenizer(br.readLine());
			for(int i = 1 ; i <= N ; i++) {
				cards[i] = Integer.parseInt(stk.nextToken());
			}
			sol(1, N, 1);
			
			int score = dp[1][N];
			bw.write(score+"\n");
		}
		
		
		bw.flush();
		bw.close();
	}
}
