/*
BOJ : https://www.acmicpc.net/problem/2447
Recurssive, Divide & Conquer 별찍기-10
Versatile0010
*/

#include <bits/stdc++.h>
using namespace std;

char star[2188][2188];
void setting(int x, int y, int n)
{
	if (n == 1) // 더이상 사이즈를 분할할 수 없으면
	{
		star[x][y] = '*'; // * 을 저장
		return;
	}
	else
	{
		int new_n = n / 3; // size를 1/3 로 축소
		int ifis5meansCenter = 0;
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++) // 1/3로 축소하면 총 9개의 구역이 생긴다.
			{// 9개의 구역을 순회하며 검사
				ifis5meansCenter++; // 해당 값이 5라는 것은 현재 가운데 구역을 탐색 중이라는 것
				if (ifis5meansCenter != 5)
				{
					setting(x + i * new_n, y + j * new_n, new_n); // 가운데가 아닐 때에만 재귀 호출
				}
			}
		}
	}
}
int main()
{
	int n; // 도형의 크기 입력받음
	cin >> n;

	for (int i = 0; i < 2188; i++)
		fill(star[i], star[i] + 2188, ' '); // 출력하기 전에 일단 공백으로 채워두고

	setting(0, 0, n); //원하는 크기만큼 도형을 미리 만듦

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cout << star[i][j];
		}
		cout << '\n';
	}

	return 0;
}
