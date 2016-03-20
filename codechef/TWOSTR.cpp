#include<iostream>
#include<cstdio>
using namespace std;
int main(){
	int i,j,t;
	char s1[11],s2[11];
	scanf("%d",&t);
	while(t--){
		scanf("%s%s",s1,s2);
		for(i=0;s1[i]!='\0';i++){
			if(s1[i]!='?'&&s2[i]!='?'&&(s1[i]!=s2[i]))
				break;
		}
		if(s1[i]!='\0')
			printf("No\n");
		else
			printf("Yes\n");
	}
return 0;
}
