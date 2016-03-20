#include<iostream>
using namespace std;
int main(){
	int amount,noOfCoins;
	cout<<"Enter Amount to be obtained\n";
	cin>>amount;
	cout<<"Number of Coins available\n";
	cin>>noOfCoins;
	int val[noOfCoins+1];
	cout<<"Enter denomination of each coin\n";
	for(int i=1;i<=noOfCoins;i++)
		cin>>val[i];
	int noOfCoinsRequired[noOfCoins+1][amount+1];
	for(int i=0;i<=noOfCoins;i++)
		for(int j=0;j<=amount;j++)
			if(i==0||j==0)
				noOfCoinsRequired[i][j]=0;
			else{
				if(j<val[i])
					noOfCoinsRequired[i][j]=noOfCoinsRequired[i-1][j];
				else{
					if(i!=1)
						noOfCoinsRequired[i][j]=min(1+noOfCoinsRequired[i][j-val[i]],noOfCoinsRequired[i-1][j]);
					else{
						noOfCoinsRequired[i][j]=1+noOfCoinsRequired[i][j-val[i]];
					}
				}
			}
	for(int i=0;i<=noOfCoins;i++){
		for(int j=0;j<=amount;j++)
			cout<<noOfCoinsRequired[i][j]<<" ";
		cout<<endl;
	}
	int j=amount;
	int i=noOfCoins;
	cout<<"Trace Back = \n";
	while(j!=0){
		if(noOfCoinsRequired[i][j]==noOfCoinsRequired[i-1][j])
			i--;
		else{
			cout<<val[i]<<" ";
			j=j-val[i];
		}
	}
	cout<<endl;
	return 0;
}
