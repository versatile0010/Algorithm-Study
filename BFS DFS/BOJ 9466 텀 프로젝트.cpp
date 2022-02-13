/*
BOJ : https://www.acmicpc.net/problem/9466
backtracking 텀 프로젝트
Versatile0010
*/
#include <bits/stdc++.h>
using namespace std;
int n; // n ~ 100,000
int team[100001];
int visited[100001];
int done[100001];
int cnt;


void dfs(int k)
{
	visited[k] = 1;
	int next = team[k];
	if (visited[next] == 0) dfs(next);
	else if (done[next] == 0)
	{
		for (int i = next; i != k; i = team[i])
			cnt++;
		cnt++;
	}
	done[k] = true;
}
int main()
{
	ios::sync_with_stdio(0); cin.tie(0);

	int testcase;
	cin >> testcase;
	while (testcase--)
	{
		cin >> n; //학생의 수
		fill(visited, visited + 100001, 0);
		fill(done, done + 100001, 0);
		for (int i = 1; i <= n; i++)
			cin >> team[i];
		cnt = 0;
		for (int j = 1; j <= n; j++)
		{
			if (!visited[j]) dfs(j);
		}
		cout << n - cnt << endl;
	
	}
	return 0;
}