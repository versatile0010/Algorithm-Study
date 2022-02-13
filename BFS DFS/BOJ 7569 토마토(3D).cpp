/*
BOJ : https://www.acmicpc.net/problem/7569
backtracking 토마토(3D)
Versatile0010
*/


#include <bits/stdc++.h>
using namespace std;

int col, row, h; // m:가로 n:세로 h:높이 ~100
int graph[100][100][100];
int dist[100][100][100];

int dx[6]{ -1,1,0,0,0,0 }; //상하좌우 위아래
int dy[6]{ 0,0,-1,1,0,0 };
int dh[6]{ 0,0,0,0,1,-1 };

int main()
{
	ios::sync_with_stdio(); cin.tie(0);
	cin >> col >> row >> h; //가로 세로 높이 입력
	queue<tuple<int, int, int>> Q;
	for (int i = 0; i < h; i++)
	{
		for (int j = 0; j < row; j++)
		{
			for (int k = 0; k < col; k++)
			{
				cin >> graph[i][j][k];
				if (graph[i][j][k] == 1)
				{
					Q.push({ i,j,k });
				}
				if (graph[i][j][k] == 0) //익지않은토마토
				{
					dist[i][j][k] = -1;
				}
			}
		}
	}

	while (Q.empty() != true)
	{
		auto cur = Q.front(); Q.pop();
		int cur_x, cur_y, cur_h;
		tie(cur_h, cur_x, cur_y) = cur;
		for (int dir = 0; dir < 6; dir++)
		{
			int nh = cur_h + dh[dir];
			int nx = cur_x + dx[dir];
			int ny = cur_y + dy[dir];

			if (nx < 0 || nx >= row || ny < 0 || ny >= col || nh < 0 || nh >= h) continue;
			if (dist[nh][nx][ny] >= 0) continue;
			Q.push({ nh,nx,ny });
			dist[nh][nx][ny] = dist[cur_h][cur_x][cur_y] + 1;
		}
	}

	int answer = 0;
	for (int i = 0; i < h; i++)
	{
		for (int j = 0; j < row; j++)
		{
			for (int k = 0; k < col; k++)
			{
				if (dist[i][j][k] == -1)
				{
					cout << -1;
					return 0;
				}
				answer = max(answer, dist[i][j][k]);
			}
		}
	}
	cout << answer;
	return 0;
}
