#include <bits/stdc++.h>

using namespace std;

bool isNum(char c) {
  return (c >= '0' && c <= '9');
}

int level(char c) {
  if(c == '+' || c == '-') return 1;
  if(c == '*' || c == '/') return 2;
  return 0;
}

int calc(string s) {
  stack<char> ops;
  stack<int> nums;
  int n = (int)s.size();
  auto f = [&]() {
    int y = nums.top(); nums.pop();
    int x = nums.top(); nums.pop();
    char op = ops.top(); ops.pop();
    if(op == '+') {
      nums.push(x + y);
    }
    if(op == '-') {
      nums.push(x - y);
    }
    if(op == '*') {
      nums.push(x * y);
    }
    if(op == '/') {
      nums.push(x / y);
    }
  };
  for(int i = 0; i < n; i++) {
    int num = 0;
    if(isNum(s[i])) {
      while(i < n && isNum(s[i])) {
        num = num * 10 + (s[i] - '0');
        i++;
      }
      nums.push(num);
      i--;
    } else
    if(s[i] == '(') {
      ops.push(s[i]);
    } else
    if(s[i] == ')') {
      while(!ops.empty() && ops.top() != '(') {
        f();
      }
      ops.pop();
    } else {
      while(!ops.empty() && level(ops.top()) >= level(s[i])) {
        f();
      }
      ops.push(s[i]);
    }
  }
  while(!ops.empty()) {
    f();
  }
  return nums.top();
}

void solve() {
  string s;
  cin >> s;
  cout << calc(s);
}

int main() {
  int _T;
  cin >> _T;
  while(_T--) {
    solve();
    cout << '\n';
  }
} // tu chuyen sang java nha
