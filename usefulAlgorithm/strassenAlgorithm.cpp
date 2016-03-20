#include<iostream>
using namespace std;
void mult(int c[],int a[],int b[],int n){
	if(n==1){
		c[0]=a[0]*b[0];
		return;
	}
	else{
		int p1[n],p2[n],p3[n],p4[n],p5[n],p6[n],p7[n];
		mult(p1,a,b,n);
	}
}
int main(){
	
	int n,a[100][100],b[100][100],c[100][100];
	cin>>n;
	for(int i=0;i<n;i++)
		for(int j=0;j<n;j++)
			cin>>a[i][j];
	mult(a,b);
	print(c);
return 0;
}
