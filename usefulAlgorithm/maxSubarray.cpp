#include<iostream>
using namespace std;
int longestDivideAndConquer(int a[],int low,int high){
	int ans,sum=-100,newleft=-100,newright=-100;
	cout<<"Func called with low = "<<low<<" high = "<<high<<endl;
	if(low==high)
		return a[low];
	int mid=(low+high)/2;
	int left=longestDivideAndConquer(a,low,mid);
	int right=longestDivideAndConquer(a,mid+1,high);
	for(int i=mid;i>=low;i--)
	{
		sum+=a[i];
		if(newleft<sum)
			newleft=sum;
	}
	sum=0;
	for(int j=mid+1;j<=high;j++)
	{
		sum+=a[j];
		if(newright<sum)
			newright=sum;
	}
	cout<<"left = "<<left<<" right = "<<right<<" newleft = "<<newleft<<" newright = "<<newright<<endl;
	ans=max(left,right);
	return max(ans,(newleft+newright));
}
int longestDp(int a[],int low,int high){
	int max=0,sum=0;
	for(int i=low;i<high;i++){
		sum+=a[i];
		if(sum<0)
			sum=0;
		if(sum>max)
			max=sum;
	}
	return max;
}
int main(){
	int n,a[100];
	cin>>n;
	for(int i=0;i<n;i++)
		cin>>a[i];
	cout<<longestDivideAndConquer(a,0,n-1)<<endl<<longestDp(a,0,n)<<endl;
return 0;
}
