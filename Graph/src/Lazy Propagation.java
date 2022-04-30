import java.util.*;

public class SegmentTree {
    static class segment{
        int n;
        int[] st,lazy;
        void init(int _n){
            this.n=_n;
            this.st=new int[4*_n];
            this.lazy=new int[4*_n];
            Arrays.fill(st,0);
            Arrays.fill(lazy,0);
        }
        void build(int start,int end,int node,int[] v){
            if(start==end){
                st[node]=v[start];
                return;
            }
            int mid=(start+end)/2;
            build(start,mid,2*node+1,v);
            build(mid+1,end,2*node+2,v);

            st[node]=st[2*node+1]+st[2*node+2];
        }
        int query(int start,int end,int l,int r,int node){
            if(start>r || end<l){
               return 0;
            }
            if(lazy[node]!=0){
                st[node]+=lazy[node]*(end-start+1);
                if(start!=end){
                    lazy[2*node+1]+=lazy[node];
                    lazy[2*node+2]+=lazy[node];
                }
                lazy[node]=0;
            }
            if(start>=l && end<=r){
                return st[node];
            }
            int mid=(start+end)/2;
            int q1=query(start,mid,l,r,2*node+1);
            int q2=query(mid+1,end,l,r,2*node+2);
            return q1+q2;
        }
        void update(int start,int end,int l,int r,int node,int val){
            if(start>r || end<l){
                return;
            }
            if(lazy[node]!=0){
                st[node]+=lazy[node]*(end-start+1);
                if(start!=end){
                    lazy[2*node+1]+=lazy[node];
                    lazy[2*node+2]+=lazy[node];
                }
                lazy[node]=0;
            }
            if(start>=l && end<=r){
                st[node]+=val*(end-start+1);
                if(start!=end){
                    lazy[2*node+1]+=val;
                    lazy[2*node+2]+=val;
                }
                return;
            }
            int mid=(start+end)/2;
              update(start,mid,l,r,2*node+1,val);
              update(mid+1,end,l,r,2*node+2,val);
            st[node]=st[2*node+1]+st[2*node+2];
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr=new int[]{1,2,3,4,5,6,7,8};
        segment tree=new segment();
          tree.init(arr.length);
          tree.build(0,arr.length-1,0,arr);
          int l=sc.nextInt(),r=sc.nextInt();
          int x=tree.query(0,arr.length-1,l,r,0);
        System.out.println(x);
        int l2=sc.nextInt(),r2=sc.nextInt(),val=sc.nextInt();
        tree.update(0,arr.length-1,l2,r2,0,val);
        int l1=sc.nextInt(),r1=sc.nextInt();
        int x1=tree.query(0,arr.length-1,l1,r1,0);
        System.out.println(x1);
    }
}
