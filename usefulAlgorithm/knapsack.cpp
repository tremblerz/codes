#include<iostream>
#include<algorithm>
using namespace std;
int main(){
	int n,wt[10000],val[10000],comp[1000][1000],c;
	cin>>n>>c;
	for(int i=1;i<=n;i++)
		cin>>wt[i];
	for(int i=1;i<=n;i++)
		cin>>val[i];
	for(int i=1;i<=n;i++)
		for(int j=1;j<=c;j++)
		comp[i][0]=comp[0][j]=0;
	for(int i=1;i<=n;i++)
		for(int j=1;j<=c;j++){
			if(j<wt[i])
				comp[i][j]=comp[i-1][j];
			else
				comp[i][j]=max(val[i]+comp[i-1][j-wt[i]],comp[i-1][j]);
		}
	cout<<endl;
	for(int i=1;i<=n;i++){
		for(int j=1;j<=c;j++)
			cout<<comp[i][j]<<" ";
		cout<<endl;
	}
	return 0;
}
