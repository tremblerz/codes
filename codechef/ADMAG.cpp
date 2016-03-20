#include<iostream>
#include<cstdio>
#include<cmath>
using namespace std;
unsigned long long int fib[130];
long long int fibonacci(int n){
	if (fib[n]!=-1)
		return fib[n];
	else
		return fibonacci(n-1)+fibonacci(n-2);
}
int main(){
	unsigned long long int n,k,x;
	for(int i=2;i<130;i++)
		fib[i]=-1;
	fib[0]=fib[1]=1;
	for(int i=2;i<130;i++)
		fib[i]=fibonacci(i);//cout<<fib[i]<<endl;}
	int t;
	scanf("%d",&t);
	while(t--){
		int i;
		scanf("%lld",&n);
		for(i=1;i<130;i++){
			if(fib[i]>n)
				break;
		}
		printf("%d\n",i-1);
	}
return 0;
}
