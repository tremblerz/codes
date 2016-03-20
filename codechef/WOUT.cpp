#include<iostream>
#include<cstdio>
using namespace std;
int main(){
	int t,n,h,x1,x2;
	int a[1000000];
	scanf("%d",&t);
	while(t--){
		int k,max=0;
//		int a[1000000];
		scanf("%d%d",&n,&h);
		for(int i=0;i<=1000000;i++)
			a[i]=0;
		for(int i=1;i<=n;i++){
			scanf("%d%d",&x1,&x2);
			x1++;x2++;
			for(int k=x1;k<=x2;k++)
				a[k]++;
		}
/*		for(int i=1;i<=n;i++)
			cout<<a[i]<<" ";
		cout<<endl;*/
//		cout<<n<<" "<<h<<endl;
		for(int i=1;i<=h;i++)
			max+=a[i];
		k=max;
//		cout<<max<<endl;
		for(int i=2;i<=n-h+1;i++){
			k=k-a[i-1]+a[i+h-1];
//			cout<<a[i-1]<<" "<<a[i+h-1]<<endl;
			if(k>max)
				max=k;
		}
//		cout<<max<<endl;
		k=(h*n)-max;
		printf("%d\n",k);
//		getchar();
	}
return 0;
}
