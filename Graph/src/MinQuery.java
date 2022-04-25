import java.util.*;
public class MinQuery {
    static class segment{
        int[] st;
        int n;
        void init(int _n){
            this.st=new int[4*_n];
            Arrays.fill(st,0);
            this.n=_n;
        }
        void build(int low,int high,int node,int[] v){
            if(low==high){
                st[node]=v[low];
                return;
            }
            int mid=(low+high)/2;
            build(low,mid,2*node+1,v);
            build(mid+1,high,2*node+2,v);

            st[node]=Math.min(st[node*2+1],st[node*2+2]);
        }
        void build(int[] v){
            build(0,v.length-1,0,v);
        }
        int query(int low,int high,int node,int l,int r){

            if(low>r || high<l){
                return Integer.MAX_VALUE;
            }
            if(low>=l && high<=r){
                return st[node];
            }
            int mid=(low+high)/2;
            int q1=query(low,mid,2*node+1,l,r);
            int q2=query(mid+1,high,2*node+2,l,r);
            return Math.min(q1,q2);
        }
        int query(int l,int r){
            return query(0,n-1,0,l,r);
        }
    }
    public static void main(String[] args) {
        int[] v=new int[]{10,2,35,42,51,68,7,18};
        segment tree=new segment();
        tree.init(v.length);
        tree.build(v);
        System.out.println(tree.query(3,6));
    }
}
