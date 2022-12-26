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
    ll n = 0; int dice[6] = { 0 }; int pair_min0 = 0; int pair_min1 = 0; int pair_min2 = 0; ll ans = 0;
    vector<ll> arr;
    ll s1 = 0; ll s2 = 0; ll s3 = 0;
    ll n1 = 0; ll n2 = 0; ll n3 = 0;

    cin >> n; int max_ele = -1;
    for (int i = 0; i < 6; i++) {
        cin >> dice[i];
        max_ele = max(max_ele, dice[i]);
    }
    pair_min0 = min(dice[0], dice[5]);
    pair_min1 = min(dice[2], dice[3]);
    pair_min2 = min(dice[1], dice[4]);
    
    arr.push_back(pair_min0);
    arr.push_back(pair_min1);
    arr.push_back(pair_min2);

    sort(arr.begin(), arr.end());
    
    s1 = arr[0];
    s2 = arr[0] + arr[1];
    s3 = arr[0] + arr[1] + arr[2];

    n1 = (n - 2) * (n - 2) + 4 * (n - 1) * (n - 2);
    n2 = 4 * (n - 2) + 4 * (n - 1);
    n3 = 4;

    ans = s1 * n1 + s2 * n2 + s3 * n3;

    if (n == 1) {
        ans = dice[0] + dice[1] + dice[2] + dice[3] + dice[4] + dice[5] - max_ele;
    }

    cout << ans << '\n';
    return 0;
}
