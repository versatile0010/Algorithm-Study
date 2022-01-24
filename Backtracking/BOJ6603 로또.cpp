/*
BOJ : https://www.acmicpc.net/problem/6603
backtracking ·Î¶Ç
Versatile0010
*/


#include <bits/stdc++.h>
using namespace std;

int input_arr[15];
int arr[6];
bool isused[15];
int n;

void solve(int k, int start)
{
	if (k == 6)
	{
		for (int i = 0; i < 6; i++)
			cout << arr[i] << ' ';
		cout << '\n';
		return;
	}
	else
	{
		int temp = 0;
		for (int i = start; i < n; i++)
		{
			if (!isused[i]&&temp != input_arr[i])
			{
				arr[k] = input_arr[i];
				isused[i] = true;
				solve(k + 1, i+1);
				isused[i] = false;
			}
		}
	
	}
}

int main()
{
	ios::sync_with_stdio(0); cin.tie(0);
	while (1)
	{
		cin >> n;
		if (n == 0) break;
		for (int i = 0; i < n; i++)
			cin >> input_arr[i];
		sort(input_arr, input_arr + n);
		solve(0,0);
		cout << '\n';
		fill(input_arr, input_arr + n, 0);
		fill(arr, arr+ n, false);
	}
	return 0;
}