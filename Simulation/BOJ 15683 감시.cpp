/*
BOJ : https://www.acmicpc.net/problem/15683
backtracking 감시 ( 삼성 SW 역량 평가 )
Versatile0010
*/

#include <bits/stdc++.h>
using namespace std;
int row, col;
int graph[8][8]; // 사무실 정보 입력

struct CCTV
{
	int x;
	int y;
	int type;
};

CCTV cctv[8];
int cctv_size = 0;

int answer;
int rot_size[]{ 4,2,4,4,1 };

void copy(int desc[8][8], int src[8][8])
{
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			desc[i][j] = src[i][j];
		}
	}
}

void update(int dir, CCTV c)
{
	dir = dir % 4;
	if (dir == 0) // 동
	{
		for (int y = c.y + 1; y< col; y++)
		{
			if (graph[c.x][y] == 6) break;
			graph[c.x][y] = -1;
		}
	}
	if (dir == 1) // 북
	{
		for (int x = c.x - 1; x >= 0; x--)
		{
			if (graph[x][c.y] == 6) break;
			graph[x][c.y] = -1;
		}
	}
	if (dir == 2) // 서
	{
		for (int y = c.y - 1; y >=0; y--)
		{
			if (graph[c.x][y] == 6) break;
			graph[c.x][y] = -1;
		}
	}
	if (dir == 3) // 남
	{
		for (int x = c.x + 1; x < row ; x++)
		{
			if (graph[x][c.y] == 6) break;
			graph[x][c.y] = -1;
		}
	}

}


void solve(int k)
{
	if (k == cctv_size)
	{
		int safe_area = 0;
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j ++ )
			{
				if (graph[i][j] == 0) safe_area++;
			}
		}
		answer = min(safe_area, answer);
		return;
	}
	
	int backup[8][8];
	int type = cctv[k].type;
	for (int dir = 0; dir < rot_size[type]; dir++)
	{
		copy(backup, graph);
		
		if (type == 0)
		{
			update(dir, cctv[k]);
		}
		if (type == 1)
		{
			update(dir, cctv[k]);
			update(dir+2, cctv[k]);
		}
		if (type == 2)
		{
			update(dir, cctv[k]);
			update(dir+1, cctv[k]);
		}
		if (type == 3)
		{
			update(dir, cctv[k]);
			update(dir+1, cctv[k]);
			update(dir+2, cctv[k]);
		}
		if (type == 4)
		{
			update(dir, cctv[k]);
			update(dir+1, cctv[k]);
			update(dir+2, cctv[k]);
			update(dir+3, cctv[k]);

		}

		solve(k + 1);
		copy(graph, backup);
	}

}

int main()
{
	ios::sync_with_stdio(0); cin.tie(0);
	cin >> row >> col;
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			cin >> graph[i][j];
			if (graph[i][j] != 0 && graph[i][j] != 6)
			{
				cctv[cctv_size].x = i;
				cctv[cctv_size].y = j;
				cctv[cctv_size].type = graph[i][j] - 1;
				cctv_size++;
			}
		}
	}
	answer = 100;
	solve(0);
	cout << answer;

	return 0;
}
