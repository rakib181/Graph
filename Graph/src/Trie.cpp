#include<bits/stdc++.h>
using namespace std;

struct node
{
  node *nxt[26];
  bool is_end;
  node(){
    for(int i=0;i<26;i++){
      nxt[i]=NULL;
      is_end=false;
    }
  }
};
node *root;
void insert_trie(string s){
  node *cur = root;
  for(int i=0;i<s.size();i++){
      int imap=s[i]-'a';
      if(cur->nxt[imap]==NULL){
        cur->nxt[imap]=new node();
      }
      cur=cur->nxt[imap];
  }
  cur->is_end=true;
}

bool search(string s){
  node *cur = root;
  for(int i=0;i<s.size();i++){
      int imap=s[i]-'a';
      if(cur->nxt[imap]==NULL) return false; 

      cur=cur->nxt[imap];
  }
  return cur->is_end;
}

int32_t main(){
   ios_base::sync_with_stdio(0);
    cin.tie(0); 
    cout.tie(0);
    #ifndef ONLINE_JUDGE 
    freopen("input.txt","r",stdin); 
    freopen("output.txt","w",stdout); 
    #endif
    auto start=clock();
    root=new node();
    int n;
    cin >> n;
    for(int i=0;i<n;i++){
      string s;
      cin >> s;
      insert_trie(s);
    }
    if(search("rakib"))cout << "Found !"<<'\n';
    else cout << "Not Found !";
    if(search("ria"))cout << "Found !"<<'\n';
      else cout << "Not Found !";
    if(search("amma"))cout << "Found !"<<'\n';
      else cout << "Not Found !";
    
    cerr<<1.0 * (clock()-start)/CLOCKS_PER_SEC<<endl;
    return 0;
}
