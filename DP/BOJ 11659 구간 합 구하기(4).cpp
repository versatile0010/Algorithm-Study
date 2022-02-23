/*
BOJ : https://www.acmicpc.net/problem/11659
DP prefix sum
Versatile0010
*/
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
using namespace std;
int n, m;
int dp[100005];
int arr[100005];
int main()
{
	ios::sync_with_stdio(0); cin.tie(0);
	freopen("input.txt", "r", stdin);
	cin >> n >> m;
	for (int i = 1; i <= n; i++)
		cin >> arr[i];
	dp[1] = arr[1];
	for (int i = 2; i <= n; i++)
	{
		dp[i] = dp[i - 1] + arr[i];
	}

	while (m--)
	{
		int start, end;
		cin >> start >> end;
		cout << dp[end] - dp[start - 1] << '\n';
	}


	return 0;
}