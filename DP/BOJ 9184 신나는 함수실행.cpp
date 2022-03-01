#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
using namespace std;

int dp[21][21][21];
int a, b, c;

int solve(int a, int b, int c)
{
	if (a <= 0 || b <= 0 || c <= 0)
	{
		return 1;
	}
	else if (a > 20 || b > 20 || c > 20)
	{
		return solve(20, 20, 20);
	}
	else if (dp[a][b][c] != 0) return dp[a][b][c];
	else if (a < b && b < c)
	{
		dp[a][b][c] = solve(a, b, c - 1) + solve(a, b - 1, c - 1) - solve(a, b - 1, c);
		return dp[a][b][c];
	}
	else
	{
		dp[a][b][c] = solve(a - 1, b, c) + solve(a - 1, b - 1, c) + solve(a - 1, b, c - 1) - solve(a - 1, b - 1, c - 1);
		return dp[a][b][c];
	}


}

int main()
{
	ios::sync_with_stdio(0); cin.tie(0);
	//freopen("input.txt", "r", stdin);
	while (true)
	{
		cin >> a >> b >> c;
		if (a == -1 && b == -1 && c == -1) break;
		cout << "w(" << a << ", " << b << ", " << c << ") = " << solve(a, b, c) << '\n';
	}
	return 0;
}