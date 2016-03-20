#include<iostream>
#include<cstdio>
using namespace std;
int main(){
	int n,k,c=0,length,beg,j,kk,a[100000][2],b[100000],i;
	scanf("%d%d",&n,&k);
	for(i=0;i<n;i++){
		scanf("%d",&a[i][0]);
		b[i]=1;
		a[i][1]=0;
//		a[i][0]=i+1;
	}
/*
	for(i=1;i<n;i++)
	{
		b[i]+=b[i-1];
		for(j=i-1;j>=0;j--)
			if(a[j][0]%a[i][0]==k&&(!a[j][1])){
				b[i]-=b[j];
				a[j][1]=1;
				break;
			}
	//		else
	//			b[i]++;
	}
*/
/*
	for(beg=0;beg<n-1;beg++){
		for(length=2;length<=n-beg;length++){
			for(j=beg;j<beg+length-1;j++){
				//cout<<a[j];
				for(i=j+1;i<=beg+length-1;i++)
{					cout<<a[j][0]<<"%"<<a[i][0]<<" ";
					if(a[j][0]%a[i][0]==k)
						break;}
				cout<<endl;
				if(i!=beg+length)
					break;//c++;
				
			}
			if(j==beg+length-1)
				c++;
//			cout<<endl;
//			c++;
//			cout<<endl;
		}
	}
*/
//	for(int i=0;i<n;i++){
//		cout<<b[i];
//		c+=b[i];
//	}
	printf("%d\n",c);
return 0;
}
