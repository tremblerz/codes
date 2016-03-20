#include<iostream>
#include<cstdio>
#include<stack>
using namespace std;
int main(){
	int t,n,temp,count;
	stack<int> s[100000];
	scanf("%d",&t);
	while(t--){
		scanf("%d",&n);
		count=-1;
		for(int i=0;i<n;i++){
			scanf("%d",&temp);
			if(count==-1){
				s[++count].push(temp);
			}
			else{
				int j=count;
				while(j>=0&&s[j].top()>temp)
					j--;
				s[j+1].push(temp);
				if(j==count)
					count++;
			}
//			for(int i=0;i<=count;i++)
//				printf("%d ",s[i].top());
//			printf("\n");
		}
		printf("%d ",count+1);
		for(int i=0;i<=count;i++)
			printf("%d ",s[i].top());
		printf("\n");
	}
return 0;
}
