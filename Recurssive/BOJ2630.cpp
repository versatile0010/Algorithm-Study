/*
BOJ : https://www.acmicpc.net/problem/2630
Recurssive, Divide & Conquer
Versatile0010
*/

#include <bits/stdc++.h>
using namespace std;

int paper[150][150];
int answer_arr[2]; // arr[0] 에는 흰종이 개수, arr[1] 에는 파란종이개수

bool isitSame(int x, int y, int n)
{
	for (int i = x; i < x + n; i++)
		for (int j = y; j < y + n; j++)
			if (paper[i][j] != paper[x][y]) return false;
	return true;
}
void solve(int x, int y, int z)
{
	if (isitSame(x,y,z))
	{
		answer_arr[paper[x][y]]+= 1;
		return;
	}
	// 종이가 같지 않다.
	int n = z / 2; //반으로 쪼갠다.
	for (int i = 0; i < 2; i++)
		for (int j = 0; j < 2; j++)
			solve(x + i * n, y + j * n, n);
}

int main()
{
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int N;
	cin >> N;

	for (int i = 0; i < N; i++)
		for (int j = 0; j < N; j++)
			cin >> paper[i][j];

	solve(0, 0, N);

	for (auto& ele : answer_arr)
		cout << ele << '\n';

	return 0;
}