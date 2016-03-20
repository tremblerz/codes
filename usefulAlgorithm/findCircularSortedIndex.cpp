#include<iostream>
using namespace std;
int find(int a[],int n){
	n--;
	int start=1;
	int mid;
	while(start<n){
		mid=(start+n)/2;
		if(a[mid]>a[mid+1]&&a[mid]>a[mid-1])
			return mid;
		else if(a[mid]>a[mid+1]&&a[mid]<a[mid-1])
			start=mid+1;
		else
			n=mid-1;
	}
}
int main(){
	int a[50],n,temp;
	cin>>n;
	for(int i=0;i<n;i++){
		cin>>temp;
		a[i]=temp;
	}
	cout<<find(a,n);
	return 0;
}
