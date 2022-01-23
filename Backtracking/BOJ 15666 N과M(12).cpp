/*
BOJ : https://www.acmicpc.net/problem/15666
backtracking N°ú M(12)
Versatile0010
*/

#include <bits/stdc++.h>
using namespace std;
int n, m;
int input_arr[10];
int arr[10];
void solve(int k, int start)
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
		int temp = -1;
		for (int i = start; i < n; i++)
		{
			if (input_arr[i] != temp)
			{
				arr[k] = input_arr[i];
				temp = arr[k];
				solve(k + 1, i);
			}
		}
	}
}

int main()
{
	ios::sync_with_stdio(0); cin.tie(0);
	cin >> n >> m;
	for (int i = 0; i < n; i++)
		cin >> input_arr[i];
	sort(input_arr, input_arr + n);
	solve(0, 0);
	return 0;
}