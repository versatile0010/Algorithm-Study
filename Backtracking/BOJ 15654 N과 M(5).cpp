/*
BOJ : https://www.acmicpc.net/problem/15654
backtracking N과 M(5)
Versatile0010
*/

#include <bits/stdc++.h>
using namespace std;

int n, m; // N 개의 자연수 중에서 M 개를 고른 수열
int arr[10];
vector<int> input_arr;
bool isused[10];

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
		for (int i = 0; i < n; i++)
		{
			if (!isused[i])
			{
				arr[k] = input_arr[i];
				isused[i] = true;
				solve(k + 1);
				isused[i] = false;
			}
		}
	}
}

int main()
{
	ios::sync_with_stdio(0); cin.tie(0);
	cin >> n >> m;
	for (int i = 0; i < n; i++)
	{
		int temp;
		cin >> temp;
		input_arr.push_back(temp);
	}
	sort(input_arr.begin(), input_arr.end());
	solve(0);
	return 0;
}