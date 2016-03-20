#include<cstdio>
#include<iostream>
using namespace std;
void print(int a[],int n){
	for(int i=0;i<n;i++)
		cout<<a[i]<<" ";
	cout<<endl;
}
int merge(int a[],int low,int high){
	int inversions=0;
	int mid=(low+high)/2;
	int temp1Size=mid-low+1,temp2Size=high-mid;
	int temp1[temp1Size],temp2[temp2Size];
	for(int i=0;i<temp1Size;i++)
		temp1[i]=a[low+i];
	for(int i=0;i<temp2Size;i++)
		temp2[i]=a[mid+1+i];
	int t1=0,t2=0;
	for(int i=low;i<low+(high-low+1);i++){
		if(t1>=temp1Size){
			a[i]=temp2[t2];
			t2++;
		}
		else if(t2>=temp2Size){
			inversions+=mid-t1;
			a[i]=temp1[t1];
			t1++;
		}

		else{
			if(temp1[t1]<temp2[t2])
				a[i]=temp1[t1++];
			else{
				a[i]=temp2[t2++];
				inversions+=mid-t1;
			}
		}
	}
	return inversions;
}
int mergeSort(int a[],int low,int high){
	int inversions=0;
	if(low<high){
		int mid = (low+high)/2;
		inversions=mergeSort(a,low,mid);
		inversions=mergeSort(a,mid+1,high);
		inversions+=merge(a,low,high);
	}
	return inversions;
}
int main(){
	int n;
	cin>>n;
	int a[n];
	for(int i=0;i<n;i++)
		cin>>a[i];
	printf("%d\n",mergeSort(a,0,(n-1)));
return 0;
}
