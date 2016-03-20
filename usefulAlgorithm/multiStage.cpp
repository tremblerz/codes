#include<iostream>
using namespace std;
int main(){
	int noOfStage,noOfEdges,adjMatrix[100][100][2]={0},root,end,node;
	cout<<"Enter the number of Edges\n";
	cin>>noOfEdges;
	for(int i=1;i<=noOfEdges;i++){
		int v1,v2,temp;
		cin>>v1>>v2>>temp;
		adjMatrix[v1][v2][0]=adjMatrix[v1][v2][0]=1;
		adjMatrix[v1][v2][1]=adjMatrix[v1][v2]=temp;
	}
	cout<<"Enter Starting and Destination\n";
	cin>>root>>end;
	node=root;
	while(node!=end){
		for(int i=1;i<=99;i++){
			if(adjMatrix[i][node]==1){
				adjMatrix[i][node][1]=min()
			}
		}
	}
return 0;
}
