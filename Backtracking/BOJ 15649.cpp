/*
BOJ : https://www.acmicpc.net/problem/15649
backtracking N과 M(1)
Versatile0010
*/

#include <bits/stdc++.h>
using namespace std;

int n, m; // 1~n 까지의 수를 m의 길이의 수열로 중복없이 출력할 것
int arr[10]; // 수열을 담을 배열
bool isusedNumber[10]; // 해당 수가 사용되었는지 확인하는 용도(중복제거)

void solve(int k)
{
	if (k == m)//base condition 
	{
		// 원하는 수열의 길이만큼 수열을 만든 경우
		for (int i = 0; i < m; i++)
			cout << arr[i] << ' ';
		cout << '\n';
		return; // 종료
	}
	// 아직 원하는 수열의 길이만큼 수열을 만들지 못한 경우
	for (int i = 1; i <= n; i++) // 1부터 n까지 숫자를 차례대로 순회함.
	{
		if (isusedNumber[i] == false) // 해당 index 의 수를 아직 사용하지 않은 경우
		{
			arr[k] = i; // 수열의 k 번째 index에 i를 저장
			isusedNumber[i] = true;
			solve(k + 1); // 수열의 길이를 1개 증가해서 재귀호출
			//재귀호출이 끝나면 하나의 경우의 수를 탐색 완료한 것이니까
			//사용했던 수를 '사용 안했다고' 바꿔줘야함
			isusedNumber[i] = false;
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