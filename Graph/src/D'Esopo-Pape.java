import java.util.*;

public class DEsopoPape {
    static int MX=105,INF=Integer.MAX_VALUE;
    static ArrayList<ArrayList<pair>>G=new ArrayList<>();
    static int[] dist=new int[MX];
    static int[] is_in_queue=new int[MX];
    static int[] p=new int[MX];

    static class pair{
        int v,wt;
        pair(int _v,int _wt){
        this.v=_v;
        this.wt=_wt;
        }
    }
    static void init(int n){
        for (int i=0;i<=n;i++){
            G.add(new ArrayList<>());
        }
        Arrays.fill(dist,INF);
        Arrays.fill(is_in_queue,2);
        Arrays.fill(p,-1);
    }
    static void addEdge(int u,int v,int w){
        G.get(u).add(new pair(v,w));
    }
    static void esopo(int src){
        dist[src]=0;
        Deque<Integer>q=new ArrayDeque<>();
        q.offerLast(src);
        while (!q.isEmpty()){
            int u=q.peekFirst();
            q.pollFirst();
            is_in_queue[u]=0;

            for (pair e:G.get(u)){
                if(dist[e.v]>dist[u]+e.wt){
                    dist[e.v]=dist[u]+e.wt;
                    p[e.v]=u;
                    if(is_in_queue[e.v]==2){
                        is_in_queue[e.v]=1;
                        q.offerLast(e.v);
                    }else if(is_in_queue[e.v]==0){
                        is_in_queue[e.v]=1;
                        q.offerFirst(e.v);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
         int n=sc.nextInt(),e=sc.nextInt();
         init(n);
         for(int i=0;i<e;i++){
             int u=sc.nextInt(),v=sc.nextInt(),w=sc.nextInt();
             addEdge(u,v,w);
         }
         esopo(0);
         for (int i=0;i<n;i++){
             System.out.print(dist[i]+" ");
         }
    }
}
