#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
#include <math.h>
#define fastio cin.tie(0)->sync_with_stdio(0)
#define ll long long
using namespace std;

vector<string> table;

bool check_square(string num) { // 제곱수인지 확인
    int number = stoi(num);
    int t = (int)(sqrt((double)number + 0.5));
    return t * t == number;
}

bool check_square(int num) { // 제곱수인지 확인
    int t = (int)(sqrt((double)num + 0.5));
    return t * t == num;
}

int main()
{
    fastio;
    int n = 0; int m = 0;
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        string str;
        cin >> str;
        table.push_back(str);
    } // fill the table

    int ans = -1;
    for (int y = 0; y < n; y++) {
        for (int x = 0; x < m; x++) {
            for (int yy = -n; yy <= n; yy++) {
                for (int xx = -m; xx <= m; xx++) {
                    if (yy == 0 && xx == 0) {
                        continue;
                    }
                    string present_num = "";
                    int y_idx = y;
                    int x_idx = x;
                    while (y_idx>=0 && y_idx<n && x_idx >=0 && x_idx <m) {
                        present_num+=table[y_idx][x_idx];
                        if (check_square(present_num)) {
                            ans = max(ans, stoi(present_num));
                        }
                        y_idx += yy;
                        x_idx += xx;
                    }
                }
            }
        }
    }
    if (n == 1 && m == 1) {
        if (check_square(table[0][0] - '0'))
            cout << table[0][0] - '0' << '\n';
        else
            cout << -1 << '\n';
    }
    else 
        cout << ans << '\n';

    return 0;
}
