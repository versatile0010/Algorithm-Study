/*
BOJ : https://www.acmicpc.net/problem/9663
backtracking N-Queen
Versatile0010
*/

#include <bits/stdc++.h>
using namespace std;

int n;
int cnt = 0;

bool isused_col[30];
bool isused_Increasing_diagonal[30];
bool isused_Decreasing_diagonal[30];

void func(int cur) // cur 번째 행에 퀸을 배치함
{
	if (cur == n)
	{
		cnt++;
		return;
	}

	for (int i = 0; i < n; i++) // cur 행 i 열을 순회
	{
		if (isused_col[i] || isused_Increasing_diagonal[cur+i] || isused_Decreasing_diagonal[cur-i+n-1])
			continue; // 퀸을 놓을 수 없는 경우
		else // 퀸을 놓을 수 있는 경우
		{
			isused_col[i] = true; // 해당 칸 세로에 true
			isused_Increasing_diagonal[cur + i] = true; //해당 칸 우상향 대각선에 true
			isused_Decreasing_diagonal[cur - i + n - 1] = true; //해당 칸 좌하향 대각선에 true 처리
			func(cur + 1);
			isused_col[i] = false; 
			isused_Increasing_diagonal[cur + i] = false;
			isused_Decreasing_diagonal[cur - i + n - 1] = false;
		}
	}


}

int main()
{
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> n;
	func(0);
	cout << cnt;
	return 0;
}