import java.util.*;
public class ST {
    static class segment{
        int[] st;
        int n;
        void init(int _n){
            this.st=new int[4*_n];
            Arrays.fill(st,0);
            this.n=_n;
        }
        void build(int start,int ending,int node,int[] v){
           if(start==ending){
              st[node]=v[start];
              return;
           }
            int mid=(start+ending)/2;
            build(start,mid,2*node+1,v);
            build(mid+1,ending,2*node+2,v);

           st[node]=st[node*2+1]+st[node*2+2];
        }
        void build(int[] v){
            build(0, v.length-1,0,v);
        }
        int query(int start,int ending,int l,int r,int node){
            if(start>r || ending<l){
                return 0;
            }
            if(start>=l && ending<=r){
                return st[node];
            }
            int mid=(start+ending)/2;
            int q1=query(start,mid,l,r,2*node+1);
            int q2=query(mid+1,ending,l,r,2*node+2);
            return q1+q2;
        }
        int query(int l,int r){
           return query(0,n-1,l,r,0);
        }
        void update(int start,int ending,int node,int idx,int val){
            if(start==ending){
                st[node]=val;
                return;
            }
            int mid=(start+ending)/2;
            if(idx<=mid){
                update(start,mid,2*node+1,idx,val);
            }else{
                update(mid+1,ending,2*node+2,idx,val);
            }
            st[node]=st[node*2+1]+st[node*2+2];
        }
        void update(int x,int y){
            update(0,n-1,0,x,y);
        }
    }
    public static void main(String[] args) {
      int[] v=new int[]{1,2,3,4,5,6,7,8};
        segment tree=new segment();
        tree.init(v.length);
       // System.out.println(v.length);
       tree.build(v);
        System.out.println(tree.st[0]);
        tree.update(3,10);
        System.out.println(tree.query(2,6));
    }
}
