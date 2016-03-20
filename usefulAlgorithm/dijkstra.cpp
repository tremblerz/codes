#include<bits/stdc++.h>
using namespace std;
struct node{
	int vertex,weight;
};
class Graph{
	public:
	int source,vertices,edges;
	list<node> *adj;
	Graph(int s,int n,int m){
		source = s;
		vertices = n+1;;
		edges = m;
		adj = new list<node>[vertices];
	}
	void addEdge(int,int,int);
};
void Graph::addEdge(int v1,int v2,int w){
	node n;
	n.vertex = v2;
	n.weight = w;
	adj[v1].push_back(n);
}
class Dijkstra{
	public:
	int *key,*dist;
	set<int> x,xcomp;
	Dijkstra(Graph g){
//		cout<<"flag\n";
		key  = new int[g.vertices];
		dist = new int[g.vertices];
		x.insert(g.source);
		for(int i=1;i<g.vertices;i++){
			if(i!=g.source){
				dist[i]=INT_MAX;
				xcomp.insert(i);
			}
		}
		dist[g.source]=0;
		run(g);
	}
	void run(Graph);
};
void Dijkstra::run(Graph g){
	int v,min,n,test;
	while(!xcomp.empty()){
		min = INT_MAX;
		for(set<int>::iterator k=x.begin();k!=x.end();k++){
			v = *k;
			cout<<"competing vertex - "<<v<<endl;
			for(list<node>::iterator i=g.adj[v].begin();i!=g.adj[v].end();i++){
				cout<<(*i).vertex<<endl;
				if(x.find((*i).vertex)==x.end())
					if(min>dist[v] + (*i).weight){
						min = dist[v] + (*i).weight;
						n = (*i).vertex;
					}
			}
		}
		cout<<min<<endl;
		cin>>test;
		x.insert(n);
		xcomp.erase(n);
		dist[n] = min;
//		for(set<int>::iterator k=xcomp.begin();k!=xcomp.end();k++)
//			cout<<"Vertex left "<<*k<<endl;
//		cin>>test;
	}
}
int main(){
	int n,m,s,v1,v2,w,d;
	cout<<"Enter Number of Vertices\n";
	cin>>n;
	cout<<"Enter number of Edges\n";
	cin>>m;
	cout<<"Enter the source vertex\n";
	cin>>s;
	Graph g(s,n,m);
	cout<<"Enter the Edge with weight\n";
	for(int i=0;i<m;i++){
		cin>>v1>>v2>>w;
		g.addEdge(v1,v2,w);
	}
	cout<<"Enter the Destination\n";
	cin>>d;
	Dijkstra x(g);
	cout<<x.dist[d]<<endl;
return 0;
}
