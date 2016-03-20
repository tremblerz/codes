#include<iostream>
using namespace std;
int val[1000][1000];
int ind(int k,int row,int length){
	for(int i=0;i<length;i++)
		if(val[row][i]==k)
			return i;
}
int main(){
	int rodLength,newLength;
	cout<<"Rod Length\n";
	cin>>rodLength;
	int cost[rodLength];
	cout<<"Enter cost\n";
	for(int i=0;i<rodLength;i++)
		cin>>cost[i];
	cout<<"Enter selling length\n";
	cin>>newLength;
	for(int i=0;i<=rodLength;i++)
		for(int j=0;j<=newLength;j++)
			if(i==0||j==0)
				val[i][j]=0;
			else{
				if(j>=i)
					val[i][j]=max(val[i-1][j],cost[i-1]+val[i][j-i]);
				else
					val[i][j]=val[i-1][j];
			}
	for(int i=0;i<=rodLength;i++){
		for(int j=0;j<=newLength;j++)
			cout<<val[i][j]<<" ";
		cout<<endl;
	}
	int i=rodLength,j=newLength;
	cout<<"Respective rods used are\n";
	while(j!=0||i!=0){
		if(val[i-1][j]==val[i][j])
			i--;
		else{
			cout<<i<<" ";
			j=j-i;
//			cin>>rodLength;
		}
	}
return 0;
}
