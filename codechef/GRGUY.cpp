#include<iostream>
#include<stdio.h>
#include<cstring>
using namespace std;
int retSwitches(char str2[],int len2,char str1[],int len1,int iter){
	int c=0;
	char *it=str1;
	while(iter!=(len1-1)&&iter!=(len2-1)){
		if(it[iter+1]=='.'){
			iter++;
//			cout<<it[iter];
		}
		else{
			if(c%2==1)
				it=str1;
			else
				it=str2;
			if(it[iter+1]=='.'){
				c++;
				iter++;
//				cout<<it[iter];
			}
			else{
				return -1;
//			cout<<endl;
			}
		}
	}
	return c;
}
int main(){
	int t;
	scanf("%d",&t);
	while(t--){
		char l1[100000],l2[100000];
		int i1,i2,k,len1,len2;
		scanf("%s%s",l1,l2);
		len1=strlen(l1);
		len2=strlen(l2);
		i1=i2=0;
/*		while(i1!=len1&&l1[i1]!='#')
			i1++;
		while(i2!=len2&&l2[i2]!='#')
			i2++;
		if(i1>i2)
			k=retSwitches(l2,len2,l1,len1,i1-1);
		else
			k=retSwitches(l1,len1,l2,len2,i2-1);
//		cout<<endl;*/
		for(i=0;i<l1;i++){
			if(l1[i]!='.'||l2[i]!='.')
		}
		if(k==-1)
			printf("No\n");
		else
			printf("Yes\n%d\n",k);
	}
}
