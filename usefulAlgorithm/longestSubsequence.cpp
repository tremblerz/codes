#include<iostream>
#include<algorithm>
using namespace std;
void print(int n,int a[]){
	for(int i=0;i<n;i++){
		cout<<a[i]<<" ";
	}
	cout<<endl;
}
int longestSubsequence(int n,int a[]){
	int longestTill[n],maxx;
	for(int i=0;i<n;i++){
		maxx=0;
		for(int j=i-1;j>=0;j--)
			if(longestTill[j]>maxx&&a[i]>a[j])
				maxx=longestTill[j];
		longestTill[i]=maxx+1;
	}
	print(n,longestTill);
	return *max_element(longestTill,longestTill+n);
}
int main(){
	int n,a[100];
	cin>>n;
	for(int i=0;i<n;i++)
		cin>>a[i];
	cout<<longestSubsequence(n,a)<<endl;
return 0;
}
