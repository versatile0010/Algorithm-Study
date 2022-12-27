#include <iostream>
#include <algorithm>
#include <vector>
#include <math.h>
#define fastio cin.tie(0)->sync_with_stdio(0)
#define ll long long
using namespace std;


int find(int x, vector<int>& parent) {
    if (parent[x] == x) return x;
    return parent[x] = find(parent[x], parent);
}

void merge(int x, int y, vector<int>& parent) {
    x = find(x, parent);
    y = find(y, parent);
    if (x == y) return;
    parent[y] = x;
}


int main()
{
    fastio;
    vector<string> ans;
    int n, m;
    cin >> n >> m;
    vector<int> parent(n + 1, 0);
    for (int i = 1; i <= n; i++)
        parent[i] = i;
    int t, x, y;
    for (int i = 0; i < m; i++) {
        cin >> t >> x >> y;
        if (t == 0/*union*/) {
            merge(x, y, parent);
        }
        else if(t==1){ /*find*/
            int parent_x = find(x, parent);
            int parent_y = find(y, parent);
            if (parent_x == parent_y/*has same parent*/) {
                ans.push_back("YES");
            }
            else {
                ans.push_back("NO");
            }
        }
    }
    for (int i = 0; i < ans.size(); i++) {
        cout << ans[i] << '\n';
    }
    return 0;
}
