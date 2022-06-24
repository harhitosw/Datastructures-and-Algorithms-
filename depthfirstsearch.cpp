#include<bits/stdc++.h>
#define vi vector<int>
#define pb push_back
#define endl "\n"
using namespace std;
// a class for graph having some standard functions 
class graph{
void DFSUtil(int v);
public:
// maintaining the hash map for visited Nodes and map in nesting with adjacency list 
map<int,bool>visited;
map<int,list<int>>adjacency_list;
void addEdge(int u,int v);
void DFS();
};
// add the edge between vertex u and v
void graph::addEdge(int u,int v){
    adjacency_list[u].pb(v);
}
// DFS function being called recursively for all the Nodes in the List as well as for their adjcanet Nodes 
void graph::DFSUtil(int v){
    visited[v]=true;
    cout<<v<<" ";
    for(auto i=adjacency_list[v].begin();i!=adjacency_list[v].end();++i){
        if(!visited[*i]){
            DFSUtil(*i);
        }
    }
}
// function for calling the DFSUtil in the main function 
void graph::DFS(){
    for(auto i:adjacency_list){
        if(visited[i.first]==false){
            DFSUtil(i.first);
        }
    }
}
int main(){
    graph g;
     g.addEdge(0, 1);
    g.addEdge(0, 9);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(9, 3);
    // for taking input from user 
    /* run a loop 
    while(ch==="y") {
    int u,v; 
    cin>>u>>v;
    g.addEdge(u,v);
    cout<<"Do you wanna continue ?";
    cin>>ch;
     }
    */
    cout<<"DFS of the Graph is as follows"<<endl;
    g.DFS();
    return 0;
}