#include<queue>
#include<stdio.h>
#include<math.h>
using namespace std;
struct b
{
	long long int quantity,days;
};
struct comp
{
	bool operator()(const b& x,const b& y)
//	bool operator()(const int& x,const int& y)
	{
		return x.quantity>y.quantity;
	}
};
int main()
{
	int t;
	scanf("%d",&t);
	while(t--)
	{
		long long int noOfpackets=0,noOfdays,k,n,req,total=0,bread,breadLeft,temp;
		priority_queue<b,vector<b>,comp> hp;
		scanf("%lld%lld",&n,&k);
		for(noOfdays=1;noOfdays<=n;noOfdays++)
		{
			scanf("%lld",&req);
			temp = req;
			while(hp.empty()==false&&req>0)
			{
				bread=hp.top().quantity - noOfdays + hp.top().days;
				hp.pop();
//				printf("popping %lld out\n",bread);
				req = req - bread;
				bread = bread - temp;
				if(bread>1)
				{	//printf("pushing %lld into heap\n",bread);
					b brd;
					brd.quantity=bread;
					brd.days=noOfdays;
					hp.push(brd);
				}
			}
			if(req>0)
			{
				noOfpackets = ceil((double)req/(double)k);
				total += noOfpackets;
				breadLeft = noOfpackets*k - req;
				if(breadLeft>1)
				{
					b brd;
					brd.quantity=breadLeft;
					brd.days=noOfdays;
					hp.push(brd);
//					printf("pushing %lld into heap\n",breadLeft);
				}
			}
		}
		printf("%lld\n",total);

//	hp.push(3);hp.push(2);hp.push(10);
//	while(hp.empty()==false){printf("%lld",hp.top());hp.pop();}
	}
	return 0;
}
