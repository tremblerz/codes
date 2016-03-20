#include<iostream>
using namespace std;
int main(){
	int a[100],n,ar[1000]={0},max,b[100];
	cin>>n;
	cin>>a[0];
	max=a[0];
	ar[max]++;
	for(int i=1;i<n;i++){
		cin>>a[i];
		if(max<a[i])
			max=a[i];
		ar[a[i]]++;
	}
	for(int i=1;i<=max;i++){
		ar[i]+=ar[i-1];
	}
	for(int i=0;i<n;i++){
		b[ar[a[i]]-1]=a[i];
		ar[a[i]]--;
	}
	for(int i=0;i<n;i++)
		cout<<b[i]<<" ";
	cout<<endl;
return 0;
}
