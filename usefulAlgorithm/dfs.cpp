#include<bits/stdc++.h>
using namespace std;
void dfs(list<int> adj[],int root,int parent[]){
	stack<int> s;
	s.push(root);
	while(!s.empty()){
		int n = s.top();
		s.pop();
		for(list<int>::iterator i=adj[n].begin();i!=adj[n].end();i++){
			if(parent[*i]==*i){
				parent[*i] = n;
				s.push(*i);
//				n = *i;
//				i = adj[n].begin();
			}
		}
	}
}
void dfs1(list<int> adj[],int root,int parent[]){
	for(list<int>::iterator i=adj[root].begin();i!=adj[root].end();i++){
		if(parent[*i]==*i){
//			parent[*i]=root;
			dfs(adj,*i,parent);
			parent[*i]=root;
		}
	}
}
int main(){
	int n,m,v1,v2,root;
	cin>>n>>m;
	int p[n+1];
	list<int> adj[n+1];
	for(int i=1;i<=n;i++)
		p[i]=i;
	for(int i=0;i<m;i++){
		cin>>v1>>v2;
		adj[v1].push_back(v2);
	}
	cin>>root;
	dfs1(adj,root,p);
	for(int i=1;i<=n;i++)
		cout<<p[i]<<" ";
	cout<<endl;
return 0;
}
