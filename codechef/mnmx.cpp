#include<iostream>
#include<cstdio>
using namespace std;
int main(){
	long long int t,n,a[100000],min;
	scanf("%lld",&t);
	while(t--){
		scanf("%lld",&n);
		scanf("%lld",&min);
		for(int i=1;i<n;i++){
			scanf("%lld",&a[i]);
			if(min>a[i])
				min=a[i];
		}
		printf("%lld\n",(n-1)*min);
	}
return 0;
}
