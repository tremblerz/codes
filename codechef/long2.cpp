#include<iostream>
#include<stdio.h>
using namespace std;
int ld(long long int k)
{
	long long int g = 10;
	while(k%g==0)
	{
		g*=10;
	}
	int x = (k/(g/10))%10;
	return x;
}
int main()
{
	int n;
	scanf("%d",&n);
	while(n--)
	{
		long long int k;
		scanf("%lld",&k);
		if(k%10 == 5||k%10 == 0)
		{
			while(ld(k)==5)
				k*=4;
			printf("%lld\n",k);
		}
		else
			printf("%lld\n",k);	
	}
	return 0;
}
