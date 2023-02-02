import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(stk.nextToken()); // 나무의 수
		long m = Long.parseLong(stk.nextToken()); // target
		
		long left = 0;
		long right = -1;
		
		long [] arr = new long[n];
		stk = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Long.parseLong(stk.nextToken());
			right = Math.max(arr[i], right);
		}

		long ans = 0;
		long mid = 0;
		while(left<=right) {
			mid = (left+right)/2;
			// 높이를 mid 로 설정했을 때 가져갈 수 있는 나무의 길이를 구하기
			long sum = 0;
			for(int i = 0 ; i < n ; i ++) {
				if(arr[i]-mid >= 0) {
					sum+=arr[i]-mid;
				}
			}
			// 이분 탐색
			if(sum < m) {
				right = mid - 1;
			} else{ // sum >= m
				ans = mid;
				left = mid + 1;
			}
		}
		System.out.println(ans);
	}
}
