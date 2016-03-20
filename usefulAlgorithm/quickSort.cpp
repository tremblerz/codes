#include<iostream>
#include<cstdio>
#include<stack>
using namespace std;
int n;
void swap(int &k1,int &k2){
	int temp=k1;
	k1=k2;
	k2=temp;
}
void print(int a[])
{
	for(int i=0;i<n;i++)
		cout<<a[i]<<" ";
	cout<<endl;
}
int partition(int a[],int l,int h){
	int piv=a[l],i=l+1,j=h;
	while(1){
		while(a[i]<piv&&i<=j)
			i++;
		while(a[j]>piv&&j>=i)
			j--;
		if(i>=j)
			break;
		swap(a[i],a[j]);
		//	i++;j--;
		//	print(a);
		
	}
	swap(a[l],a[j]);
//	print(a);
	return j;
}
void quick(int a[],int l,int h){
	if(l<=h){
		int p = partition(a,l,h);
		quick(a,l,p-1);
		quick(a,p+1,h);
	}
}
void rquick(int a[],int l,int h){
	stack<int> s;
	s.push(l);
	s.push(h);
	while(!s.empty()){
		int h=s.top();
		s.pop();
		int l=s.top();
		s.pop();
		int p=partition(a,l,h);
		if(p-1>l){
			s.push(l);
			s.push(p-1);
		}
		else if(h>p+1){
			s.push(p+1);
			s.push(h);
		}
	}
}
int main(){
	int i;
	cin>>n;
	int a[n];
	for(int i=0;i<n;i++)
		scanf("%d",&a[i]);
	rquick(a,0,n-1);
	for(int i=0;i<n;i++)
		cout<<a[i]<<" ";
	cout<<endl;
return 0;
}
