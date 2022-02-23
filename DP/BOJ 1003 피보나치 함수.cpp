/*
BOJ : https://www.acmicpc.net/problem/1003
DP 피보나치 함수
Versatile0010
*/

#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
using namespace std;

int dp[45][2];
int main()
{
	ios::sync_with_stdio(0); cin.tie(0);
	//freopen("input.txt", "r", stdin);
	int testcase;
	cin >> testcase;

	dp[0][0] = 1, dp[0][1] = 0;
	dp[1][0] = 0, dp[1][1] = 1;

	for (int i = 2; i <= 45; i++)
	{
		dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
		dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
	}

	while (testcase--)
	{
		int n;
		cin >> n;
		cout << dp[n][0] << ' ' << dp[n][1] << '\n';
	}

	return 0;
}