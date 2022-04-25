import java.util.*;

public class ZOBFS {
    static int MX=105,INF=Integer.MAX_VALUE;
    static ArrayList<ArrayList<pair>>G=new ArrayList<>();
    static int[] dist=new int[MX];


    static class pair implements Comparable<pair>{
            int v;
            int wt;
            pair(int x,int y){
                this.v=x;
                this.wt=y;
            }
        @Override
        public int compareTo(pair o) {
            return this.wt-o.wt;
        }
    }
    static void intit(int n){
        for(int i=0;i<=n;i++){
            G.add(new ArrayList<>());
        }
        Arrays.fill(dist,INF);
    }
    static void addEdge(int u,int v,int w){
        G.get(u).add(new pair(v,w));
        G.get(v).add(new pair(u,w));
    }


    static void bfs(int src){
        Deque<Integer>q=new LinkedList<>();
        q.offerLast(src);
        dist[src]=0;
        while(!q.isEmpty()){
            int node=q.removeFirst();
            for (pair it:G.get(node)){
                int u=it.v,wt=it.wt;
                if(dist[node]+wt<dist[u]){
                    dist[u]=dist[node]+wt;
                    if(wt==0){
                        q.offerFirst(u);
                    }else{
                        q.offerLast(u);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt(),e=sc.nextInt();
        intit(n);
        for(int i=0;i<e;i++){
            int u=sc.nextInt(),v=sc.nextInt(),w= sc.nextInt();
            addEdge(u,v,w);
        }
        bfs(0);

        for(int i=0;i<n;i++){
            System.out.print(dist[i]+" ");
        }
    }
}
