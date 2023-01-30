import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main{
	static int [][] graph;
	static boolean [][] visited;
	static int [][] dp;
	static int [] dx = {0,0,-1,1};
	static int [] dy = {-1,1,0,0};
	static int n;
	static int m;
	static boolean inf;
	static int max = -1;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt(); // 세로
		m = sc.nextInt(); // 가로
		graph = new int[n][m];
		dp = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0 ; i < n ; i ++) {
			char [] arr = sc.next().toCharArray();
			for(int j = 0 ; j < m; j ++) {
				graph[i][j] = arr[j]-'0';
			}
		}
		
		dfs(0,0,0);
		
		if(inf)
			System.out.println(-1);
		else
			System.out.println(max+1);
		
	}

	static void dfs(int x, int y, int cnt) {
		visited[y][x] = true;
		dp[y][x] = cnt;
		if(cnt >= max) {
			max = cnt; // 최대 이동 횟수 갱신
		}
		int weight = graph[y][x];
		for(int dir = 0 ; dir< 4 ; dir++) {
			int nx = x + dx[dir]*weight; // 이동할 좌표
			int ny = y + dy[dir]*weight;
			
			if(nx<0||nx>=m||ny<0||ny>=n)
				continue;
			if(graph[ny][nx]=='H'-'0')
				continue;
			if(visited[ny][nx]) {
				inf=true; // 사이클 발생(왔던 곳 다시 방문)
				return;
			}
			if(cnt<dp[ny][nx]) {
				// 어차피 최대값만 알아내면 되니까
				// 굳이 다 계산할 필요는 없겠다.
				continue;
			}
			
			visited[ny][nx] = true;
			dfs(nx, ny, cnt+1);
			visited[ny][nx] = false;
		}
	}
}
