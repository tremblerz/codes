#include<iostream>
#include<stdio.h>
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
int main()
{
	int i,j,k,val,cipher[7][31][2],key[31][10];
	char c1,c2;
	FILE *fp = NULL;
	fp = fopen("cipher.txt","r");
	k=0;
	for(int i=0;i<7;i++)
		for(int j=0;j<31;j++)
		{
			cipher[i][j][1] = 0;
			for(int x=0;x<10;x++)
				key[j][x]=0;
		}
	while(1)
   	{
		c1=fgetc(fp);
		if(c1=='\n')
			break;
		c2=fgetc(fp);
		int val = getVal(c1) * 16 + getVal(c2);
		cipher[0][k++][0]=val;
	}
	k=0;
	while(1)
   	{
		c1=fgetc(fp);
		if(c1=='\n')
			break;
		c2=fgetc(fp);
		int val = getVal(c1) * 16 + getVal(c2);
		cipher[1][k++][0]=val;
	}
	k=0;
	while(1)
   	{
		c1=fgetc(fp);
		if(c1=='\n')
			break;
		c2=fgetc(fp);
		int val = getVal(c1) * 16 + getVal(c2);
		cipher[2][k++][0]=val;
	}
	k=0;
	while(1)
   	{
		c1=fgetc(fp);
		if(c1=='\n')
			break;
		c2=fgetc(fp);
		int val = getVal(c1) * 16 + getVal(c2);
		cipher[3][k++][0]=val;
	}
	k=0;
	while(1)
   	{
		c1=fgetc(fp);
		if(c1=='\n')
			break;
		c2=fgetc(fp);
		int val = getVal(c1) * 16 + getVal(c2);
		cipher[4][k++][0]=val;
	}
	k=0;
	while(1)
   	{
		c1=fgetc(fp);
		if(c1=='\n')
			break;
		c2=fgetc(fp);
		int val = getVal(c1) * 16 + getVal(c2);
		cipher[5][k++][0]=val;
	}
	k=0;
	while(1)
   	{
		c1=fgetc(fp);
		if(c1=='\n')
			break;
		c2=fgetc(fp);
		int val = getVal(c1) * 16 + getVal(c2);
		cipher[6][k++][0]=val;
	}
	fclose(fp);
	cout<<k<<endl;
	for(int i=0;i<7;i++)
	{
		for(int j=0;j<7;j++)
		{
			if(i!=j)
			{
				for(int x=0;x<k;x++)
				{
				//	cout<<cipher[i][x]<<"^"<<cipher[j][x]<<"="<<(cipher[i][x]^cipher[j][x])<<" ";
					if((cipher[i][x][0]^cipher[j][x][0]) >= 64)
					{
						//cout<<cipher[i][x]<<" "<<cipher[j][x]<<endl;
				//		cout<<i<<" "<<j<<" --> "<<x<<endl;
						cipher[j][x][1]++;
					}
				}
			}
			//cout<<endl;
		}
	}
	cout<<cipher[0][17][0];
	key[0][0] = 242;
	key[29][0] = 238;
	key[30][0] = 48;
	key[20][0] = 42;
	key[10][0] = 206;
	key[6][0] = 35;
	key[8][0] = 57;
	key[17][0] = 224;
	for(int i=0;i<7;i++)
	{
		for(int x=0;x<k;x++)
		{
			if((cipher[i][x][1])>3)
			{
				//cout<<x<<"th char in key is "<<(cipher[i][x][0]^32)<<endl;
				int c=0;
				while(key[x][c]!=0)
					c++;
				key[x][c]=(cipher[i][x][0]^32);
			}
//			cout<<cipher[i][x][1];
		}
	//	cout<<endl;
	}
	for(int j=0;j<7;j++)
	{
		for(int i=0;i<31;i++)
			cout<<(char)(cipher[j][i][0]^key[i][0]);
		cout<<endl;
	}
	return 0;
}
