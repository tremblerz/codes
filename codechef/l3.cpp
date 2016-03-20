#include<stdio.h>
using namespace std;
int main()
{
	int n,q,a[200000],a1,k,b1;
	char s[10];
	scanf("%d%d",&n,&q);
	for(int i=1;i<=200000;i++)
		a[i]=i;
	int X=0;
	for(int t=0;t<q;t++)
	{
		scanf("%s",s);
		if(s[0]=='G')
		{
			scanf("%d%d",&a1,&k);
			for(int i=1;i<=X+n+1;i++)
			{
				if(a[i]==a1)
					k--;
				if(k==0)
				{
					printf("%d\n",i);
					break;
				}
			}
		}
		else
		{
			scanf("%d%d",&a1,&b1);
			int i;
			for(i=1;i<=X+n+1;i++)
			{
				if(a[i]==a1)
					a[i]=X+n+1;
				else if(a[i]==b1)
					a[i]=X+n+1;
			}
			X++;
		}
//		for(int i=1;i<=14;i++)
//		{
//			printf("%d ",a[i]);
//		}
//		printf("\n");
	}
	return 0;
}
