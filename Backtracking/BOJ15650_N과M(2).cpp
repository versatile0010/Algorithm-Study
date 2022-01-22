/*
BOJ : https://www.acmicpc.net/problem/15650
backtracking N과 M(2)
Versatile0010
*/

#include <bits/stdc++.h>
using namespace std;

int n, m; // 1~n 까지의 자연수 중 중복없이 m 개를 고른다.
bool isused[10];  // 특정 수가 사용되었는지 확인하기 위함
int arr[10]; // 완성된 수열을 차례대로 담기 위함


void solve(int k)
{
	if (k == m) // 원하는 길이의 수열을 만들었다면 출력하고 해당함수 종료
	{
		for (int i = 0; i < m; i++)
			cout << arr[i] << ' ';
		cout << '\n';
		return;
	}
	else
	{
		int start = 1;
		if (k != 0) start = arr[k - 1] + 1;
		for (int i = start; i <= n; i ++ )
		{
			if (!isused[i]) // 해당 수를 사용하지 않았다면?
			{
				arr[k] = i;
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

	solve(0);
	return 0;

	return 0;
}