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
    vector<int> ans;
    vector<vector<int>> party;

    int n, m;
    cin >> n >> m; // n : 사람 수, m : 파티 수
    vector<int> parent(n+1);
    for (int i = 1; i <= n; i++) {
        parent[i] = i;
    }

    int true_man_num;
    vector<int> true_man;
    cin >> true_man_num;
    for (int i = 0; i < true_man_num; i++) {
        int t;
        cin >> t;
        true_man.push_back(t);
    }

    for(int x = 0 ; x < m ; x++) {
        int num; int t;
        cin >> num;
        vector<int> id_list;
        for (int i = 0; i < num; i++) {
            cin >> t;
            id_list.push_back(t);
        }
        for (int i = 0; i < id_list.size() - 1; i++) {
            merge(id_list[i], id_list[i + 1], parent);
        }
        party.push_back(id_list);
    }

    int cnt = m;
    for (auto& party_id_list : party) {
        bool flag = false;
        for (auto& personal_id : party_id_list) {
            if (flag == true)
                break;
            for (auto& true_id : true_man) {
                if (find(personal_id, parent) == find(true_id, parent)) {
                    flag = true;
                    break;
                }
            }
        }
        if (flag == true)
            cnt--;
    }

    ans.push_back(cnt);
    for (int i = 0; i < ans.size(); i++) {
        cout << ans[i] << '\n';
    }
    return 0;
}
