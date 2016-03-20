#include<iostream>
#include<cstdio>
using namespace std;
int main(){
	unsigned long long int n,k;
	int t;
	scanf("%d",&t);
	for(;t;--t){
		scanf("%lld",&n);
		k=n;
		while(n){
			if(!(n%2))
				break;
			else
				n=n/2;
		}
//		cout<<n;
		if(k==1)
			printf("2\n");
		else if(n>0)
			printf("-1\n");
		else
			printf("%lld\n",k/2);
	}
return 0;
}
