/*
BOJ : https://www.acmicpc.net/problem/1182
backtracking 부분수열의 합
Versatile0010
*/

#include <bits/stdc++.h>
using namespace std;

int n, s;
int arr[30];
int cnt = 0;

void solve(int cur, int present_sum)
{
	if (cur == n)
	{
		if (present_sum == s)
			cnt++;
		return;
	}
	else
	{
		solve(cur + 1, present_sum);
		solve(cur + 1, present_sum+arr[cur]);
	}
}

int main()
{
	ios::sync_with_stdio(0); cin.tie(0);
	cin >> n >> s;
	for (int i = 0; i < n; i++)
		cin >> arr[i];
	solve(0, 0);
	if (s == 0) cnt--;
	cout << cnt;
	return 0;
}