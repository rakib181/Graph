#include<bits/stdc++.h>
using namespace std;

const int MX=105;
int Parent[MX];
int Rank[MX];

void makeset(int n){
   for(int i=1;i<=n;i++){
      Parent[i]=i;
      Rank[i]=1;
   }
}

int find(int v){
   if(Parent[v]==v){
      return v;
   }
   return Parent[v]=find(Parent[v]);
}

void _union(int u,int v){
   int _x=find(u),_y=find(v);
   if(_x==_y){
      return;
   }
   if(Rank[_x]>Rank[_y]){
      Parent[_y]=_x;
   }else if(Rank[_y]>Rank[_x]){
      Parent[_x]=_y;
   }else{
      Parent[_x]=_y;
      Rank[_x]++;
   }
}

int32_t main(){
   ios_base::sync_with_stdio(0);
    cin.tie(0);
    #ifndef ONLINE_JUDGE
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);
    #endif
    auto st=clock();
    int n,e;
    cin>>n>>e;
    makeset(n);
    vector<pair<int,pair<int,int>>> addEdges;
    for(int i=1;i<=e;i++){
       int u,v,wt;
       cin>>u>>v>>wt;
       addEdges.push_back({wt,{u,v}});
    }
    sort(addEdges.begin(),addEdges.end());int min_span=0;
    for(auto &it:addEdges){
        if(find(it.second.first)!=find(it.second.second)){
         _union(it.second.first,it.second.second);
         min_span+=it.first;
         cout<<it.second.first<<" "<<it.second.second<<endl;
        }
    }
    cout<<min_span<<endl;
   
   cerr<< 1.0 * (clock()-st)/CLOCKS_PER_SEC<<'\n';
   return 0;
}
