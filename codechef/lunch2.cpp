#include<string.h>
#include<stdio.h>
#include<algorithm>
using namespace std;
char buf[6];
char * res(int a,int b,char chance){
	char k[]={'t','v'};
	int index = 0;
	if(chance=='t')
	{
		strcpy(buf,"Vanka");
		index=1;
	}
	else
		strcpy(buf,"Tuzik");
	if(a==1&&b==1)
		return buf;
	else if(a==1)
		return res(b/2,b-(b/2),k[index]);
	else if(b==1)
		return res(a/2,a-(a/2),k[index]);
	else
		return res(max(a,b)/2,max(a,b)-(max(a,b)/2),k[index]);
		
}
int main(){
	int t,a,b;
	scanf("%d",&t);
	while(t--)
	{
		scanf("%d%d",&a,&b);
		printf("%s\n",res(a,b,'t'));
	}
	return 0;
}
