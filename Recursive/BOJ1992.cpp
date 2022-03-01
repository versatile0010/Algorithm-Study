/*
BOJ : https://www.acmicpc.net/problem/1992
Recurssive, Divide & Conquer 쿼드트리
Versatile0010
*/

#include <bits/stdc++.h>
using namespace std;

int pixel[100][100];

bool isitSame(int x, int y, int n)
{
	for (int i = x; i < x + n; i++)
		for (int j = y; j < y + n; j++)
			if (pixel[i][j] != pixel[x][y]) return false;
	return true;
}

void solve(int x, int y, int z)
{
	if (isitSame(x, y, z))
	{

		if (pixel[x][y] == 0) cout << '0';
		else cout << '1';

		return;
	}
	int n = z / 2; // 반으로 쪼갠다.
	cout << '(';
	for (int i = 0; i < 2; i++)
	{
		for (int j = 0; j < 2; j++) // 4개 구역에 대해서
		{
			solve(x + i * n, y + j * n, n);
		}
	}
	cout << ')';

}

int main()
{
	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			scanf_s("%1d", &pixel[i][j]);
	solve(0, 0, n);
	return 0;

}
