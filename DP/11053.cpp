#include <iostream>
#include <algorithm>
#include <vector>
#include <math.h>
#define fastio cin.tie(0)->sync_with_stdio(0)
#define ll long long
using namespace std;

int dp[1001] = { 0 };
int arr[1001] = { 0 };

int main()
{
    fastio;

    int n;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> arr[i];
    }
    for (int i = 1; i <= n; i++) {
        dp[i] = 1;
    }

    int ans = 0;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j < i; j++) {
            if (arr[j] < arr[i]) {
                dp[i] = max(dp[i], dp[j] + 1);
            }
        }
        ans = max(dp[i], ans);
    }
    cout << ans << '\n';

    return 0;
}
