#include<iostream>
using namespace std;
#define mod 1000000007
long long int fastExpo(long long int a,long long int b)
{
	long long int c = 1;
	while(b>0)
	{
		if(b%2==1){
			cout<<"b="<<b<<"\tc="<<c;
			c=c*(a%mod);
			b=b-1;
		}
		a=((a%mod)*(a%mod))%mod;
		b=b/2;
		cout<<"\ta="<<a<<"\tb="<<b<<endl;
	}
	return c;
}
int main()
{
	long long int a,b;
	cout<<"Enter a and b\n";
	cin>>a>>b;
	cout<<"("<<a<<"^"<<b<<")%"<<mod<<"="<<fastExpo(a,b)<<endl;
	return 0;
}
