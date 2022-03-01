#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
using namespace std;
#define MOD 15746

long long dp[1000005];

int main()
{
	ios::sync_with_stdio(0); cin.tie(0);
	//freopen("input.txt", "r", stdin);
	dp[1] = 1, dp[2] = 2;
	int n;
	cin >> n;
	for (int i = 3; i <= n; i++)
	{
		dp[i] = (dp[i - 1] + dp[i - 2])%MOD;
	}
	cout << dp[n];
	return 0;
}