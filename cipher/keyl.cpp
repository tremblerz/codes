#include<iostream>
#include<stdio.h>
#include<string.h>
using namespace std;
int getVal(char c)
   {
       int rtVal = 0;

       if(c >= '0' && c <= '9')
       {
           rtVal = c - '0';
       }
       else
       {
           rtVal = c - 'A' + 10;
       }

       return rtVal;
   }
int ncr(int n,int k)
{
    unsigned long long int ans=1;
    k=k>n-k?n-k:k;
    int j=1;
    for(;j<=k;j++,n--)
    {
        if(n%j==0)
        {
            ans*=n/j;
        }else
        if(ans%j==0)
        {
            ans=ans/j*n;
        }else
        {
            ans=(ans*n)/j;
        }
    }
//        cout<<f<<endl;
    return ans;
}
int main()
{
	int k=0,q;
	FILE *fp;
	int freq[1000][256],cipher[10000];
	fp=fopen("ctext.txt","r");
	char c1,c2,buff[1000];

   	while(1)
   	{
		c1=fgetc(fp);
		c2=fgetc(fp);
		int val = getVal(c1) * 16 + getVal(c2);
		if(c1=='\n')
			break;
		cipher[k++]=val;
	}
//	cout<<"\n\n";

/*	for(int i=0;i<k;i++)
	{
		cout<<cipher[i]<<" ";
	}
	cout<<endl;*/
//	int kc2=ncr(k,2);
//	for(int keyl=1;keyl<=13;keyl++)
//	{
	
/*		for(int i=0;i<1000;i++)
			for(int j=0;j<256;j++)
				freq[i][j]=0;
		for(int i=0;i<keyl;i++)
		{
			for(int j=i;j<k;j+=keyl)
			{
				freq[i][cipher[j]]++;
			}
		}
		float a=0;
		for(int f=0;f<keyl;f++)
		{
			int sum=0;
			for(int j=0;j<256;j++)
			{
				sum += ncr(freq[f][j],2);
			}
			float x = (float)sum/(float)kc2;//<<" ";
			a+=x;
//			cout<<x<<" ";
		}
//		cout<<"\nkeylength is "<<keyl<<" and parameter is "<<(float)a/(float)keyl;
//		cout<<endl;
//	}
//	for(int key 
*/
//		int keyl=7;
//		for(int m=0;m<keyl;m++)
//		for(int i=0;i<255;i++)
//		{
			int c=0;
			int i=0;
			char key[]={186,63,145,178,83,205,62};
			for(int j=0;j<k;j++,i++,c++)
			{
				i=i%7;
				cout<<char(cipher[j]^key[i]);
//				cout<<(int)buff[c]<<"="<<buff[c]<<" ";
//				if(buff[c]==0)
//					cout<<" "<<j;
			}
//			cout<<endl<<k<<endl;//<<(c==k);
//			cout<<"\n\n";
//			cout<<(int)buff[15];
//			buff[k]='\0';
//			cout<<endl<<buff<<endl;
			cout<<endl;
	return 0;
}
