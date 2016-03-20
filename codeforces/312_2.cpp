#include<stdio.h>
#include<algorithm>
using namespace std;
typedef long long int lld;
int main()
{
	lld n;
	scanf("%d",&n);
	lld a[n],freq[1000000],b[100],last,i;
	for(i = 0;i < 1000000;i++)
		freq[i] = 0;
	for(i = 0;i < n;i++)
	{
		scanf("%lld",&a[i]);
		freq[a[i]-1]++;
		b[i]=freq[a[i]-1]-1;
	}
	last=max_element(b,b+n);
	printf("%lld\n",last);
	return 0;
}
