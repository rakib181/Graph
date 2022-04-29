import java.util.*;

public class FenwickTree {
    static class fenwick{
        int[] fn;
        int n;
        void init(int _n) {
            this.n = _n + 1;
            this.fn = new int[n];
            Arrays.fill(fn, 0);
        }
        void add(int x,int y){
            x++;
            while (x<n) {
                fn[x] += y;
                x+=(x&(-x));
            }
        }
        int sum(int x){
            x++;int ans=0;
            while (x>0){
               ans+=fn[x];
               x-=(x&(-x));
            }
            return ans;
        }
        int sum(int l,int r){
            return sum(r)-sum(l-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] v=new int[]{2,-2,3,7,15,60,-7};
       fenwick tree=new fenwick();
       tree.init(v.length);
       for (int i=0;i<v.length;i++){
           tree.add(i,v[i]);
       }
        System.out.println(tree.sum(3,5));
       tree.add(4,-3);
        System.out.println(tree.sum(3,5));
    }
}


