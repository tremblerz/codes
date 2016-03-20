#include<iostream>
#include<cstdio>
#include<algorithm>
using namespace std;
struct pair1{
	int x,y;
};
bool compare(pair1 i,pair1 j){
	if(i.x==j.x)
		return i.y<j.y;
	else
		return i.x<j.x;
}
int main(){
	int t,n,k,pos1,pos2,i;
	pair1 ob[3000];
	char a[3000][2];
	scanf("%d",&t);
	while(t--){
		int c=0;
		scanf("%d%d",&n,&k);
		for(i=0;i<n;i++)
			a[i][1]=0;
		while(k--){
			scanf("%d%d",&pos1,&pos2);
			ob[c].x=pos1;
			ob[c++].y=pos2;
		}
		sort(ob,ob+c,compare);
		for(int j=0;j<c;j++){
			int start=ob[j].x;
			int end=ob[j].y;
			while(start<end){
				if(a[start][1]&&a[end][1])
					break;
				if(!a[start][1])
					a[start][0]='(';
				if(!a[end][1])
					a[end][0]=')';
				a[start][1]=1;
				a[end][1]=1;
				start++;
				end--;
			}
		}
		for(int i=0;i<n;i++){
			if(a[i][1]==0)
				printf(")");
			else
				printf("%c",a[i][0]);
		}
		printf("\n");
//		for(int i=0;i<c;i++)
//			cout<<ob[i].x<<" "<<ob[i].y<<endl;
	}
return 0;
}
