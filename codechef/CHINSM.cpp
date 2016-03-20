#include<iostream>
#include<time.h>
#include<cstdio>
#include<stdlib.h>
using namespace std;
int main(){
//	srand(time(NULL));
	int n,k,c=0,j,kk=0,a[100000][2],b[100000],i;
//	bool flag=true;
	scanf("%d%d",&n,&k);
//	while(1){
	c=0;kk=0;
//	n=rand()%1000 +10000;
//	n=100000;k=20;
//	k=rand()%500 +2;
	
	for(i=0;i<n;i++){
		scanf("%d",&a[i][0]);
		b[i]=1;
		a[i][1]=0;
//		if(a[i]<a[i-1]&&i>0)
//			flag=false;
//		a[i][0]=(rand())%100000+1;
//		a[i][0]=i+1;
	}
///*
//	if(flag){
//		c=(n*(n+1))/2;
//	}
//	else{
		for(i=1;i<n;i++){
			for(j=i-1;j>=0;j--){
				if(a[j][1])
					break;
				if(a[j][0]%a[i][0]==k&&(!a[j][1])){
					a[j][1]=1;
					break;
				}
			}
//			cout<<i-j<<endl;
			c+=i-j;
		}
//	}
//*/
/*
	for(beg=0;beg<n-1;beg++){
		for(length=2;length<=n-beg;length++){
			for(j=beg;j<beg+length-1;j++){
				for(i=j+1;i<=beg+length-1;i++){
					if(a[j][0]%a[i][0]==k){
						break;
					}
				}
				if(i!=beg+length)
					break;
			}
			if(j==beg+length-1)
				kk++;
			else
				break;
		}
	}
*/
//	for(i=0;i<n;i++)
///		c+=b[i];
	printf("%d\n",c+1);
return 0;
}
