#include<bits/stdc++.h>
using namespace std;
int bfs(list<int> adj[],int root,int parent[]){
	queue<int> q;
	q.push(root);
	while(!q.empty()){
		int n = q.front();
		q.pop();
		for(list<int>::iterator i=adj[n].begin();i!=adj[n].end();i++){
			if(parent[*i]==*i){
				parent[*i]=n;
				q.push(*i);
			}
		}
	}
}
int main(){
	int n,v1,v2,root,m;
	cin>>n>>m;
	list<int> adj[n+1];
	int p[n+1];
	for(int i=1;i<=n;i++)
		p[i]=i;
	for(int i=0;i<m;i++){
		cin>>v1>>v2;
		adj[v1].push_back(v2);
	}
	cin>>root;
	bfs(adj,root,p);
	for(int i=1;i<=n;i++)
		cout<<p[i]<<" ";
	cout<<endl;
return 0;
}
