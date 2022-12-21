#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <math.h>
#define fastio cin.tie(0)->sync_with_stdio(0)
#define ll long long
using namespace std;

/*
0~9 번째 감소하는 수는 각각 0~9 이다.
10 번째 부터의 감소하는 수는 10, 20, 21, 30, 31, 32 ... 인데
맨 앞 자릿수 + (0~ 맨 앞자릿수 - 1) 의 형태를 가지는 것을 알 수 있다.

그러면 queue 에 0~9 까지의 수를 미리 넣어놓고(seed)
i = 0 ~ q.front() % 10 -1 에 대하여 q.front()*10 + i 를 queue 에 push 하는 방식으로
감소하는 수를 구할 수 있다.
*/


int main()
{
    fastio;
    int n; ll ele = 0; int cnt = -1; ll ans = -1;
    cin >> n;
    queue<ll> q;
    for (int i = 0; i <= 9; i++)
        q.push(i);
    while (!q.empty()) {
        ele = q.front();
        q.pop();
        cnt += 1;

        if (n == cnt) {
            while (!q.empty())q.pop();
            ans = ele;
            break;
        }
        else {
            for (int i = 0; i < ele % 10; i++) {
                q.push(ele * 10 + i);
            }
        }
    }
    cout << ans << '\n';
    return 0;
}
