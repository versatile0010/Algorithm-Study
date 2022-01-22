/*
BOJ : https://www.acmicpc.net/problem/15652
backtracking N과 M(4)
Versatile0010
*/

#include <bits/stdc++.h>
using namespace std;

int n, m; // 1~n 까지의 수를 m 개인 수열로 만들것임
int arr[10];
void solve(int k)
{
	if (k == m)
	{
		for (int i = 0; i < m; i++)
			cout << arr[i] << ' ';
		cout << '\n';
		return;
	}
	else
	{
		int start = 1;
		if (k != 0) start = arr[k - 1];
		for (int i = start; i <= n; i++)
		{
			arr[k] = i;
			solve(k + 1);
		}

	}
}

int main()
{
	ios::sync_with_stdio(0); cin.tie(0);
	cin >> n >> m;

	solve(0);

	return 0;
}