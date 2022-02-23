/*
BOJ : https://www.acmicpc.net/problem/11726
DP 2*N ≈∏¿œ∏µ
Versatile0010
*/
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
using namespace std;

int n;
int dp[1005];
int main()
{
	ios::sync_with_stdio(0); cin.tie(0);
	freopen("input.txt", "r", stdin);
	cin >> n;
	dp[1] = 1; dp[2] = 2;
	for (int i = 3; i <= n; i++)
	{
		dp[i] = (dp[i - 1] + dp[i-2])%10007;
	}
	cout << dp[n];
	return 0;
}