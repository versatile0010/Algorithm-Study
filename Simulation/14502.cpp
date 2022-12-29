#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <math.h>
#define fastio cin.tie(0)->sync_with_stdio(0)
#define ll long long
using namespace std;

int graph[10][10];
int safe_map[10][10];
int bfs_map[10][10];
int row;
int col;
int ans;

int dx[4] = { 0,0,-1,1 };
int dy[4] = { -1,1,0,0 };

void print() {
    cout << '\n';
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            cout << safe_map[i][j] << ' ';
        } cout << '\n';
    } cout << '\n';
}

void copy() {
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            safe_map[i][j] = graph[i][j];
        }
    }
}

int bfs() {
    queue<pair<int,int>> q;
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            if (safe_map[i][j] == 2)
                q.push({ j,i }); // x,y
            bfs_map[i][j] = safe_map[i][j];
        }
    }
    //print();
    while (!q.empty()) {
        auto cur = q.front();
        q.pop();
        for (int dir = 0; dir < 4; dir++) {
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];

            if (nx < 0 || nx >= col || ny < 0 || ny >= row) continue;
            /*(1 : 벽, 2 : 바이러스)*/
            if (bfs_map[ny][nx] == 1) continue; // 벽이라면 방문하지 않는다.
            // 벽이 아니라면 방문한다.
            if (bfs_map[ny][nx] > 0) continue;
            bfs_map[ny][nx] = 2;
            q.push({ nx,ny });
        }
    }

    int cnt = 0;
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            if (bfs_map[i][j] == 0)
                cnt++;
        }
    }
    ans = max(ans, cnt);
    return cnt;
}

void setup(int cnt) {
    if (cnt == 3) {
        bfs();
        return;
    }
    else {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (safe_map[i][j] == 0) {
                    safe_map[i][j] = 1;
                    setup(cnt + 1);
                    safe_map[i][j] = 0;
                }
            }
        }
    }
}

int main()
{
    fastio;
    cin >> row >> col;
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            cin >> graph[i][j];
        }
    }

    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            if (graph[i][j] == 0) {
                copy();
                safe_map[i][j] = 1;
                setup(1);
                safe_map[i][j] = 0;
            }
        }
    }
    cout << ans << '\n';
    return 0;
}
