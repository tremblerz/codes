#include<iostream>
using namespace std;
int main(){
	string s1,s2;
	cout<<"Enter the two strings\n";
	cin>>s1>>s2;
	int noOfConversion[s1.length()+1][s2.length()+1];
	for(int i=0;i<=s1.length();i++)
		for(int j=0;j<=s2.length();j++){
			if(i==0)
				noOfConversion[i][j]=j;
			else if(j==0)
				noOfConversion[i][j]=i;
			else{
				if(s1[i-1]==s2[j-1])
					noOfConversion[i][j]=noOfConversion[i-1][j-1];
				else
					noOfConversion[i][j]=1+min(noOfConversion[i-1][j],min(noOfConversion[i-1][j-1],noOfConversion[i][j-1]));
			}
		}
	for(int i=0;i<=s1.length();i++){
		for(int j=0;j<=s2.length();j++)
			cout<<noOfConversion[i][j]<<" ";
		cout<<endl;
	}
	cout<<"Trace Back\n";
	int i=s1.length(),j=s2.length();
	while(noOfConversion[i][j]!=0){
		if(s1[i-1]==s2[j-1]){
			i--;j--;
			cout<<"No Operation Needed------>>>\n";
		}
		else{
			int k=min(noOfConversion[i-1][j],min(noOfConversion[i-1][j-1],noOfConversion[i][j-1]));
			if(k==noOfConversion[i-1][j]){
				cout<<"Delete "<<s1[i-1]<<endl;
				i--;
			}
			else if(k==noOfConversion[i][j-1]){
				cout<<"Add "<<s2[j-1]<<endl;
				j--;
			}
			else{
				cout<<"Replace "<<s1[i-1]<<" by "<<s2[j-1]<<endl;
				i--;j--;
			}
		}
	}
	return 0;
}
