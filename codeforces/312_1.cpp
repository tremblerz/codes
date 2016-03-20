#include<stdio.h>
#include<queue>
#include<stdlib.h>
using namespace std;
struct s
{
	int cord,no;
};
struct comp
{
	bool operator()(const s& a,const s& b)
	{	return abs(a.cord)>abs(b.cord);}
};
int main()
{
	int n;
	scanf("%d",&n);
	s st;
	priority_queue<s,vector<s>,comp> neg,pos;
	while(n--)
	{
		int cord,no;
		scanf("%d%d",&cord,&no);
		st.cord = cord;
		st.no = no;
		if(st.cord<0)
			neg.push(st);
		else
			pos.push(st);
	}
	long long int total=0;
	while(1)//neg.empty()==false&&pos.empty()==false)
	{	
		if(neg.empty()==true)
		{
			if(!pos.empty())
				total+=pos.top().no;
			break;
		}
		else if(pos.empty()==true)
		{
			if(!neg.empty())
				total+=neg.top().no;
			break;
		}
		total+=neg.top().no+pos.top().no;
		neg.pop();
		pos.pop();
	}
	printf("%lld\n",total);
	return 0;
}
