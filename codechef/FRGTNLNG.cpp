#include<iostream>
#include<cstdio>
#include<cstring>
using namespace std;
int main(){
	int t,c,count,k,n;
	char nstr[100][6],str[6];
	bool a[100];
	scanf("%d",&t);
	for(;t;--t){
		count=0;
		scanf("%d%d",&n,&k);
		int i=0,j=0;
		while(i<n){
			scanf("%s",nstr[i]);
			a[i]=false;
			i++;
		}
		while(j<k){
			scanf("%d",&c);
			while(c--){
				scanf("%s",str);
				for(int i=0;i<n;i++){
					if(!a[i])
						if(strcmp(str,nstr[i])==0){
							a[i]=true;
							break;
						}
				}
			}
			j++;
		}
		for(i=0;i<n;i++)
			if(a[i])
				printf("YES ");
			else
				printf("NO ");
		printf("\n");
	}
return 0;
}
