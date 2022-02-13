/*
BOJ : https://www.acmicpc.net/problem/2206
backtracking 벽 부수고 이동하기
Versatile0010
*/

#include <bits/stdc++.h>
using namespace std;

int n, m;
char graph[1000][1000];
int visited[1000][1000][2];
int dx[]{ -1,1,0,0 };
int dy[]{ 0,0,-1,1 };

int bfs()
{
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			visited[i][j][0] = visited[i][j][1] = -1;
	visited[0][0][0] = visited[0][0][1] = 1;
	queue<tuple<int, int, int>> Q;
	Q.push({ 0,0,0 });
	while (!Q.empty())
	{
		int x, y, broken;
		tie(x, y, broken) = Q.front();
		if (x == n - 1 && y == m - 1)
		{
			return visited[x][y][broken];
		}
		Q.pop();
		for (int dir = 0; dir < 4; dir++)
		{
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue; // out of bound
			if (graph[nx][ny] == '1' && !broken && visited[nx][ny][broken] == -1)
			{
				// 다음 위치가 벽이고 && 아직 부순 적 없고 && 방문하지도 않았다면
				visited[nx][ny][1] = visited[x][y][broken] + 1;
				Q.push({ nx,ny,1 });
			}
			if (graph[nx][ny] == '0' && visited[nx][ny][broken] == -1)
			{
				// 다음 위치가 벽이 아니고 아직 방문하지 않았다면
				visited[nx][ny][broken] = visited[x][y][broken] + 1;
				Q.push({ nx,ny,broken });
			}
		}
	}


	return -1;
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> n >> m;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			cin >> graph[i][j];
	cout << bfs();
	return 0;
}