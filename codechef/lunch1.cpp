#include<stdio.h>
int main()
{
	int t;
	long long int n,k,max;
	scanf("%d",&t);
	while(t--){
		max=0;
		scanf("%lld%lld",&n,&k);
//		k++;
		while(k>1){
			if(n%k>max)
				max=n%k;
			k--;
		}
	printf("%lld\n",max);
	}
	return 0;
}
