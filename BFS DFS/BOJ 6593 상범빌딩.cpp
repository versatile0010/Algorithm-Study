/*
BOJ : https://www.acmicpc.net/problem/6593
backtracking 상범빌딩
Versatile0010
*/

#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
using namespace std;
const int MX = 35;
int dx[6] = { -1,1,0,0,0,0 };
int dy[6] = { 0,0,-1,1,0,0 };
int dh[6] = { 0, 0, 0, 0, 1, -1 };
int l, r, c;

int main(void) {
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);

    char graph[MX][MX][MX];
    int dist[MX][MX][MX];
    //freopen("input.txt", "r", stdin);
    while (1)
    {
        cin >> l >> r >> c;
        if (l == 0 && r == 0 && c == 0) break; // 종료 조건
        queue<tuple<int, int, int>> Q; // 튜플 담은 큐 생성

        for (int i = 0; i < l; i++)
            for (int j = 0; j < r; j++)
                fill(dist[i][j], dist[i][j] + c, 0); // 거리 배열 0으로 초기화

        for (int i = 0; i < l; i++)
        {
            for (int j = 0; j < r; j++)
            {
                for (int k = 0; k < c; k++) // 삼중 for 문 인덱스 : 높이,세로,가로
                {
                    cin >> graph[i][j][k];
                    if (graph[i][j][k] == 'S') // 시작점위치 인덱스 찾으면
                    {
                        Q.push({ i,j,k }); // 큐에 푸쉬 -> bfs 의 시작점이 됨
                        dist[i][j][k] = 0; // 방문을 0으로 저장 (사실 이미 0이긴 함)
                    }
                    if (graph[i][j][k] == '.') // 비어있는 공간
                    {
                        dist[i][j][k] = -1; // -1로 저장 ( 방문해야함 )
                    }
                }
            }
        } // -1 로 저장된 것은 빈 공간 뿐임.  
        bool isescape = false; // 탈출 플래그

        while (!Q.empty()) 
        {
            if (isescape == true) break; // 탈출했다면 while 문 탈출
            auto cur = Q.front(); Q.pop(); // cur 로 큐 받아오고 팝
            int cur_x, cur_y, cur_h; // 튜플 요소로 사용할(아직사용안함) 지역변수 선언
            tie(cur_h, cur_x, cur_y) = cur; // 하나로 묶어서 튜플안에 넣어줌 // cur_h : 높이, cur_x : 세로, cur_y : 가로

            for (int dir = 0; dir < 6; dir++) // 6가지 방향 : 상하좌우 업 다운
            {
                int nx = cur_x + dx[dir];
                int ny = cur_y + dy[dir];
                int nh = cur_h + dh[dir]; // 다음 위치 갱신

                if (nx < 0 || nx >= r || ny < 0 || ny >= c || nh < 0 || nh >= l) continue; // out of bound
                if (graph[nh][nx][ny] == '#' || dist[nh][nx][ny] > 0) continue; // 방문하지 못할 경우이거나 방문할 필요 없는경우 continue
                // <- 62번째 라인으로 왔다는 것은, 어쨋던간에 nh,nx,ny 좌표는 방문이 가능한 곳이고 방문해야한다는 것임
                dist[nh][nx][ny] = dist[cur_h][cur_x][cur_y] + 1;  // 1분 누적
                if (graph[nh][nx][ny] == 'E') // 근데 새롭게 간 nh,nx,ny 가 출구라면?
                {
                    cout << "Escaped in " << dist[nh][nx][ny] << " minute(s)." << '\n'; // 답안 출력
                    isescape = true; // flag = true 
                    break; // while 문 탈출
                }
                Q.push({ nh,nx,ny }); // 출구가 아니였다면 다시 bfs 돌아야하니까 새로운 좌표도 push
            }

        }
        while (!Q.empty()) Q.pop(); // 위 while 에서 여기로 도달했다는 것은 탈출 or 실패라는 것인데, queue 가 안비워져있을 수 있음 ( 도중 return)
        if (!isescape) cout << "Trapped!" << '\n';  // 탈출 못했으면 이거 출력하기.
    }

    return 0;
}