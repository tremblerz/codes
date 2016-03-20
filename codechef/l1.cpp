#include<stdio.h>
#include<algorithm>
#include<string.h>
//#include<stdlib.h>
using namespace std;
int main()
{
	int i,max,min1,t,l1,d,l2;
	char s1[2000],s2[2000];
	scanf("%d",&t);
	while(t--)
	{
		scanf("%s%s",s1,s2);
		l1 = strlen(s1);
		l2 = strlen(s2);
		max=min1=0;
		d=abs(l1-l2);
		int k=min(l1,l2);
		for(i=0;i<k;i++)
		{
			if((s1[i]=='?')||(s2[i]=='?'))
			{	max++;	}
			else if(s1[i]!=s2[i])
			{	max++;	min1++;}
		}
		printf("%d %d\n",min1+d,max+d);
	}
	return 0;
}
