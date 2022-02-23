/*
BOJ : https://www.acmicpc.net/problem/2579
DP 계단오르기
Versatile0010
*/
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
using namespace std;


int main()
{
	ios::sync_with_stdio(0); cin.tie(0);
	freopen("input.txt", "r", stdin);
	int n;
	cin >> n;
	int s[305];
	int dp[305][3];
	for (int i = 1; i <= n; i++)
		cin >> s[i];
	dp[1][1] = s[1], dp[1][2] = 0, dp[2][1] = s[2], dp[2][2] = s[1] + s[2];
	for (int i = 2; i <= n; i++)
	{
		dp[i][1] = max(dp[i - 2][1], dp[i - 2][2]) + s[i];
		dp[i][2] = dp[i - 1][1] + s[i];
	}

	cout << max(dp[n][1], dp[n][2]);

	return 0;
}