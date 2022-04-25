import java.util.*;

public class Kruskal {
    static int MX=105;
    static int[] parent=new int[MX];
    static int[] rank=new int[MX];
    static ArrayList<Triplet> edgeList=new ArrayList<>();
    static void makeSet(int n){
        for (int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=1;
        }
    }
    static int find(int v){
        if(parent[v]==v){
            return v;
        }
        return parent[v]=find(parent[v]);
    }
    static void union(int u, int v){
        int xRoot=find(u),yRoot=find(v);
        if(xRoot==yRoot){
          return;
        }
        if(rank[xRoot]>rank[yRoot]){
            parent[yRoot]=xRoot;
        }
       else if(rank[yRoot]>rank[xRoot]){
            parent[xRoot]=yRoot;
        }
       else{
           parent[yRoot]=xRoot;
           rank[xRoot]++;
        }
    }
    static class Triplet implements Comparable<Triplet>{
        int u,v,wt;
        Triplet(int u,int v,int wt){
            this.u=u;
            this.v=v;
            this.wt=wt;
        }
        public int compareTo(Triplet that){
            return this.wt- that.wt;
        }
    }
    static void addEdge(int u,int v,int w){
        edgeList.add(new Triplet(u,v,w));
    }
    static int krus(){
        Collections.sort(edgeList);
        int ans=0;
        for (Triplet e:edgeList){
            int w= e.wt;
            int x=e.u;
            int y=e.v;
            if(find(x)!=find(y)){
                union(x,y);
                ans+=w;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),e=sc.nextInt();
        makeSet(n);
        for(int i=0;i<e;i++){
            int u=sc.nextInt(),v=sc.nextInt(),wt=sc.nextInt();
            addEdge(u,v,wt);
        }
        System.out.println(krus());
    }
}
