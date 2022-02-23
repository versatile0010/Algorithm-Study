/*
BOJ : https://www.acmicpc.net/problem/9095
DP Adding 1s, 2s, and 3s
Versatile0010
*/
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
using namespace std;
int dp[11];


int main()
{
	ios::sync_with_stdio(0); cin.tie(0);
	freopen("input.txt", "r", stdin);
	int t, n;
	cin >> t;
	dp[1] = 1, dp[2] = 2, dp[3] = 4;
	for (int i = 4; i <= 11; i++)
	{
		dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
	}
	while (t--)
	{
		cin >> n;
		cout << dp[n] << '\n';
	}
	return 0;
}