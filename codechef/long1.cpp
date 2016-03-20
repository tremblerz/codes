#include<iostream>
#include<stdio.h>
#include<cmath>
using namespace std;
int main()
{
	int t;
	scanf("%d",&t);
	while(t--){
		int c=0,k2;
		long long int a,b,k;
		float k1;
		scanf("%lld%lld",&a,&b);
		while(a!=b){
			c++;
			if(a>b)
				a/=2;
			else{
				k1=log2(a);
				k2=k1;
				if(k1 - (float)k2 !=0)
				{
					a/=2;
//					cout<<a<<"d"<<endl;
				}
				else
				{
					a*=2;
//					cout<<a<<"d"<<endl;
				}
			}
		}
		printf("%d\n",c);
	}
return 0;
}
