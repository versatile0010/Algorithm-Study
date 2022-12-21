#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <math.h>
#define fastio cin.tie(0)->sync_with_stdio(0)
#define ll long long
using namespace std;

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
