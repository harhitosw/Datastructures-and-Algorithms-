#include<bits/stdc++.h>
# define  INF INT_MAX
using namespace std;
vector<vector<int>> make_new_node(vector<vector<int>>vp,int r,int c){
    for(int i=0;i<vp.size();i++){
        if(i==r){
            for(int j=0;j<vp[0].size();j++){
                vp[i][j]=INF;
            }
        }
        else{
            continue;
        }
    }
    for(int i=0;i<vp[0].size();i++){
        if(i==c){
            for(int j=0;j<vp[0].size();j++){
                vp[j][i]=INF;
            }
        }
        else{
            continue;
        }
    }
        vp[c][r]=INF;
       return vp;

}
pair<vector<vector<int>>,int> reduce_matrix(vector<vector<int>>&v){
    // first we reduce from the row 
    int cost=0;
    vector<vector<int>>vp=v;
    for(int i=0;i<vp.size();i++){
        int mini=*min_element(vp[i].begin(),vp[i].end());
        for(int j=0;j<vp[0].size();j++){
          if(vp[i][j]==INT_MAX){
             continue;
          }
          else{
            vp[i][j]-=mini;
          }
        }
        cost+=mini;
    }
    // secondly we traverse a column
    for(int i=0;i<vp[0].size();i++){
       // auto it=find(vp[i].begin(),vp[i].end(),0);
        int min_col=INT_MAX;
        for(int k=0;k<vp.size();k++){
            min_col=min(min_col,vp[k][i]);
        }
        cout<<"MIn for col"<<min_col<<endl;
        if(min_col!=0){
            for(int j=0;j<vp.size();j++){
                if(vp[j][i]==INT_MAX){
                    continue;
                }
                else{
                    vp[j][i]-=min_col;
                }
            }
            cost+=min_col;
        }
        else {
            continue;
        }
       
    }
    pair<vector<vector<int>>,int> ans=make_pair(vp,cost);
     return ans;
}
int main()
{
    vector<vector<int>>v={
        {INF,20,30,10,11},
        {15,INF,16,4,2},
        {3,5,INF,2,4},
        {19,6,18,INF,3},
        {16,4,7,16,INF}
    };

   vector<vector<int>> tmp=make_new_node(v,2,3);
     for(int i=0;i<tmp.size();i++){
        for(int j=0;j<tmp[0].size();j++){
            cout<<tmp[i][j]<<" ";
        }
        cout<<endl;
     }
    return 0;
}
