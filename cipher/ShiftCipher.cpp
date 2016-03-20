#include<iostream>
#include<string.h>
using namespace std;
int main()
{
	char key[100],msg[100],cipher[100];
	int i,j;
	cout<<"Enter key then text\n";
	cin>>key>>msg;
	for(i=0,j=0;i<strlen(msg);i++)
	{
		cipher[i] = (msg[i] - 65 + key[j] - 65 )%26 + 65;
		j++;
		j=j%strlen(key);
	}
	cipher[i]='\0';
	cout<<cipher<<endl;
	return 0;
}
