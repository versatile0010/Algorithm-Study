/*
BOJ : https://www.acmicpc.net/problem/2573
backtracking 빙산
Versatile0010
*/


#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second

int row, col; // 3~300
int graph[300][300];
bool vis[300][300];

int dx[]{ -1,1,0,0 };
int dy[]{ 0,0,-1,1 };


bool check(int nx, int ny)
{
	if (nx < 0 || nx >= row || ny < 0 || ny >= col) return true;
	else return false;
}
void melting()
{
	int adj_num[300][300] = { 0, };
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			if (graph[i][j] == 0) continue; // 물이면 체크할 필요 없음
			for (int dir = 0; dir < 4; dir++)
			{
				int nx = i + dx[dir];
				int ny = j + dy[dir];
				if (check(nx,ny)||graph[nx][ny] == 0) adj_num[i][j]++;
			}
		}
	}

	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			graph[i][j] = max(0, graph[i][j] - adj_num[i][j]);
		}
	}

}
int  status()
{
	int x = -1, y = -1;
	int count_A = 0, count_B = 0;
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			if (graph[i][j] != 0)
			{
				x = i; y = j; count_A++;
			}
		}
	}
	if (count_A == 0) return 0;
	queue<pair<int, int>> Q;
	vis[x][y] = true;
	Q.push({ x,y });
	while (!Q.empty())
	{
		auto cur = Q.front(); Q.pop();
		count_B++;
		for (int dir = 0; dir < 4; dir++)
		{
			int nx = cur.X + dx[dir];
			int ny = cur.Y + dy[dir];

			if (check(nx, ny)) continue;
			if (graph[nx][ny] == 0 || vis[nx][ny] == true)continue;
			Q.push({ nx,ny });
			vis[nx][ny] = true;
		}
	}
	if (count_A == count_B) return 1;
	else return 2;

}

int main()
{
	ios::sync_with_stdio(0); cin.tie(0);
	cin >> row >> col;
	for (int i = 0; i < row; i++)
		fill(graph[i], graph[i] + col, 0);
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			cin >> graph[i][j];
		}
	}
	int year = 0;
	while (true)
	{
		for (int i = 0; i < row; i++)
			fill(vis[i], vis[i] + col, false);
		year++;
		melting();
		int var = status();
		if (var == 0)
		{
			cout << 0 << '\n';
			break;
		}
		else if (var == 1)
		{
			continue;
		}
		else
		{
			cout << year << '\n';
			break;
		}
	}

	return 0;
}