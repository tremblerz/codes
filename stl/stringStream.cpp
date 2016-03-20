#include <sstream>
#include <vector>
#include <iostream>
using namespace std;

vector<int> parseInts(string str) {
   vector<int> a;
    long i=0;
    stringstream s(str);
	int a1;char ch;
    while(s>>a1){
	s>>ch;
        a.push_back(a1);
        i++;
    }
    return a;
}

int main() {
    string str;
    cin >> str;
    vector<int> integers = parseInts(str);
    for(int i = 0; i < integers.size(); i++) {
        cout << integers[i] << "\n";
    }
    
    return 0;
}
