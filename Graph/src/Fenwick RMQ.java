import java.util.*;

public class FenwickRMQ {
	static class fenwick{
		int n,INF=Integer.MAX_VALUE;
		int[] fn;
		void init(int _n){
			this.n=_n+1;
			this.fn=new int[n];
			Arrays.fill(fn,INF);
		}
		
		void add(int x,int y) {
			for(++x;x<n;x+=(x&(-x))) {
				fn[x]=Math.min(fn[x], y);
			}
		}
		int getMin(int x) {
			int ans=INF;
			for(++x;x>0;x-=(x&(-x))) {
				ans=Math.min(fn[x], ans);
			}
			return ans;
		}
		int getMiny(int r) {
			return getMin(r);
		}
		
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		fenwick tree=new fenwick();
		tree.init(n);
		for(int i=0;i<n;i++) {
			tree.add(i,arr[i]);
		}
		System.out.println(tree.getMiny(4));
	}
}
