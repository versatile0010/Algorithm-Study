/*
BOJ : https://www.acmicpc.net/problem/1149
DP RGB Street
Versatile0010
*/
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
using namespace std;

int n;
int dp[1005][3];
int R[1005], G[1005], B[1005];

int main()
{
	ios::sync_with_stdio(0); cin.tie(0);
	freopen("input.txt", "r", stdin);

	cin >> n;
	for (int i = 1; i <= n; i++)
	{
		cin >> R[i] >> G[i] >> B[i];
	}
	
	dp[1][0] = R[1], dp[1][1] = G[1], dp[1][2] = B[1];
	for (int i = 2; i <= n; i++)
	{
		dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + R[i];
		dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + G[i];
		dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + B[i];
	}
	int answer = min({ dp[n][0],dp[n][1], dp[n][2] });
	cout << answer;
	return 0;
}