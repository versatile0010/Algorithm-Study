/*
BOJ : https://www.acmicpc.net/problem/9935
backtracking 문자열 폭발
Versatile0010
*/

#include <bits/stdc++.h>
using namespace std;

string input;
string mine;
bool flag = false;

int main()
{
	ios::sync_with_stdio(0); cin.tie(0);
	cin >> input >> mine; // 문자열과 폭발 문자열 입력
	vector<char> str; // 입력 문자열을 저장할 vector
	const int input_size = (int)input.size(); // 문자열의 길이 백업
	const int mine_size = (int)mine.size(); // 폭발 문자열의 길이 백업
	for (int i = 0; i < input_size; i++) // 문자열 순환
	{
		str.push_back(input[i]); // 한글자씩 push
		if (str.size() >= mine_size) // str 에 저장된 문자가 폭발문자열보다 크면 탐색
		{
			flag = true; // 일단 flag 는 true 로 저장 ( 폭발문자열 포함하지 않다면 false로 바뀜 )
			for (int j = 0; j < mine_size; j++) // 폭발문자열의 길이만큼 반복
			{
				if (str[str.size() - mine_size + j] != mine[j]) // str 에 폭발문자열이 없다?
				{
					flag = false; // false
					break; // 탈출
				}
			}
			if (flag == true) // 위 반복문 이후에도 flag 가 true 이면 폭발문자열이 포함된 것
			{
				for (int k = 0; k < mine_size; k++) // 폭발문자열의 길이만큼
				{
					str.pop_back(); // 문자열 팝
				}//문자열 폭발
				flag = false; // 폭발했으니까 flag 는 다시 false 로 저장
			}
		}
	}//반복

	if (str.empty() == true) // str 이 비어있다면 폭발로 모조리 날아간 것
	{
		cout << "FRULA"; // 예외처리
	}
	else
	{
		for (int i = 0; i < str.size(); i++) // str 이 비어있지 않다면.
		{
			cout << str[i]; // 그대로 출력 
		}
	}

	return 0;
}