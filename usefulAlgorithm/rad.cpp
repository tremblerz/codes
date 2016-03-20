#include<iostream>
using namespace std;
void countingSort(int a[],int n,int base){
	int count[10]={0},out[n];
	for(int i=0;i<n;i++)
			count[(a[i]/base)%10]++;
	for(int i=1;i<=9;i++)
		count[i]+=count[i-1];
	for(int i=n-1;i>=0;i--){
		out[count[(a[i]/base)%10]-1]=a[i];
		count[(a[i]/base)%10]--;
	}
	for(int i=0;i<n;i++)
		a[i]=out[i];
}
int main(){
	int n,a[100000],max;
	cin>>n>>max;
	a[0]=max;
	for(int i=1;i<n;i++){
		cin>>a[i];
		if(max<a[i])
			max=a[i];
	}
	for(int i=1;max/i>0;i*=10)
		countingSort(a,n,i);
	for(int i=0;i<n;i++)
		cout<<a[i]<<" ";
	cout<<endl;
	return 0;
}
