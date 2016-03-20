#include<iostream>
#include<cstdio>
using namespace std;
int main(){
	int t,i,j,k,c;
	char l1[1000000],l2[1000000];
	bool flag;
	scanf("%d",&t);
	while(t--){
		c=0;
		scanf("%s%s",l1,l2);
		for(i=0;l1[i]!='#'&&l1[i]!='\0';i++);
		for(j=0;l2[j]!='#'&&l2[j]!='\0';j++);
		if(i>j){
			flag=false;
			k=i;
		}
		else{
			flag=true;
			k=j;
		}
		if(k)
		for(i=k-1;l1[i]!='\0';i++){
			if(flag){
				if(l2[i+1]=='#'&&l1[i+1]=='.'){
					flag=false;
					c++;
				}
				else if(l2[i+1]=='#'&&l1[i+1]=='#')
					break;
			}
			else{
				if(l1[i+1]=='#'&&l2[i+1]=='.'){
					flag=true;
					c++;
				}
				else if(l1[i+1]=='#'&&l2[i+1]=='#')
					break;
			}
		}
		if(l1[i]=='\0')
			printf("Yes\n%d\n",c);
		else
			printf("No\n");
	}
return 0;
}
