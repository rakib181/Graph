#include<bits/stdc++.h>
using namespace std;

struct BinarayHeap
{
  int capacity,heap_size;
  int *H;
  void init(int n){
   heap_size=0;
   capacity=n;
   H=new int[n];
  }
  void insert(int x){
   if(heap_size==capacity){
    cout << "Insertion is not possible ! \n";
    return;
   }
   heap_size++;
   int i=heap_size-1;
   H[i]=x;
   while(i>0 && H[(i-1)/2]>H[i]){
    swap(H[(i-1)/2],H[i]);
    i=(i-1)/2;
   }
  }
  void removeMin(){
    swap(H[0],H[heap_size-1]);
    heap_size--;
    int i=0;
    while(2*i+1 <heap_size){
      int j=2*i+1;
      if(2*i+2<heap_size and H[2*i+2]<H[j]){
        j=2*i+2;
      }
      if(H[j]>H[i]){
        break;
      }
      swap(H[i],H[j]);
      i=j;
    }
  }
  void getMin(){
    cout << H[0] << '\n';
  }
  void HeapSort(){
    while(heap_size>0){
      cout << H[0] <<" ";
      removeMin();
    }
    cout << '\n';
  }
};

int32_t main(){
   ios_base::sync_with_stdio(0);
    cin.tie(0); 
    cout.tie(0);
    #ifndef ONLINE_JUDGE 
    freopen("input.txt","r",stdin); 
    freopen("output.txt","w",stdout); 
    #endif
    auto start=clock();
    BinarayHeap BH;
    BH.init(11);
    BH.insert(10);
    BH.insert(20);
    BH.insert(8);
    BH.insert(2);
    BH.insert(100);
    BH.removeMin();
    BH.getMin();
    for(int i=0;i<BH.heap_size;i++){
      cout << BH.H[i] << " ";
    }
    cout << '\n';
    BH.HeapSort();
    cerr<<1.0 * (clock()-start)/CLOCKS_PER_SEC<<endl;
    return 0;
}
