#include<cstdlib>
#include<cstdio>
using namespace std;
struct cord{
int x,y;
};
int main(){
	int t,temp,sum,n;
	scanf("%d",&t);
	while(t--){
		sum=0;
		scanf("%d",&n);
		cord ob[n*n+2];
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
			{
				scanf("%d",&temp);
				ob[temp].x=i;ob[temp].y=j;
			}
//		for(int i=1;i<=(n*n);i++)
//			printf("%d %d\n",ob[i].x,ob[i].y);
		for(int i=2;i<=(n*n);i++)
			sum+=abs((ob[i].x-ob[i-1].x))+abs((ob[i].y-ob[i-1].y));
		printf("%d\n",sum);
	}
return 0;
}
