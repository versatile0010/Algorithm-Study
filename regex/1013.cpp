#include <iostream>
#include <algorithm>
#include <vector>
#include <regex>
#define fastio cin.tie(0)->sync_with_stdio(0)
#define ll long long
using namespace std;


int main()
{
    fastio;
    int case_num = 0;
    string gt = "(100+1+|01)+";
    regex reg(gt);

    cin >> case_num;
    while (case_num--) {
        string str;
        cin >> str;
        if (regex_match(str, reg))
            cout << "YES\n";
        else
            cout << "NO\n";
    }
    return 0;
}
