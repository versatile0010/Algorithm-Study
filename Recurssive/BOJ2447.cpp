/*
BOJ : https://www.acmicpc.net/problem/2447
Recurssive, Divide & Conquer 별찍기-10
Versatile0010
*/

#include <bits/stdc++.h>
using namespace std;

void solve(int x, int y, int n) // x,y 좌표별로 n에 따라 올바른 문자 출력
{
	if (x / n % 3 == 1 && y / n % 3 == 1) // 공백을 출력해야 하는 경우
		cout << ' ';
	else if (n / 3 == 0) // * 을 출력해야 하는 경우
		cout << '*';
	else
		solve(x, y, n / 3); // 재귀호출
}

int main()
{
	int n; // 도형의 크기 입력받음
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{ // 좌표별로 순회하며 solve 함수에 넣어, 해당 좌표에 올바른 문자 * or ' ' 출력
			solve(i, j, n);
		}
		cout << '\n'; // 한 줄을 다 출력했으면 다음줄로
	}
	return 0;
}