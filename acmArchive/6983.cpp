#include<cstdio>
#include<iostream>
using namespace std;
int main()
{
//	srand (time(NULL));	
	int i,test_cases,n,flag,temp,a[1001];
	scanf("%d",&test_cases);
	while(test_cases--)
	{
		flag=0;
		for(i=0;i<=1000;i++)
			a[i]=0;
		scanf("%d",&n);
		for(i=0;i<n;i++)
		{
			scanf("%d",&temp);
			if(a[temp]==1)
				flag=1;
			a[temp]=1;
		}
		if(flag)
			printf("NO\n");
		else	
			printf("YES\n");
	}
return 0;
}
