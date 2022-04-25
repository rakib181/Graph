import java.util.*;

public class Dijkstra {
    static int MX=105,INF=Integer.MAX_VALUE;
    static ArrayList<ArrayList<pair>>G=new ArrayList<>();
    static boolean[] vis=new boolean[MX];
    static int[] dist=new int[MX];

    static class pair implements Comparable<pair>{
        int v;
        int wt;
        pair(int v,int wt){
            this.v=v;
            this.wt=wt;
        }
        public int compareTo(pair that){
            return this.wt-that.wt;
        }
    }
    static void dijkstra(int src){
        PriorityQueue<pair>pq=new PriorityQueue<>();
        pq.offer(new pair(src,0));
        while(!pq.isEmpty()){
            pair cur=pq.poll();
            int vertex=cur.v;int cost=cur.wt;
            if(!vis[vertex]){
                vis[vertex]=true;
                dist[vertex]=cost;
                for (int i=0;i<G.get(vertex).size();i++){
                    int nxt=G.get(vertex).get(i).v;
                    int nxtCost=G.get(vertex).get(i).wt;
                    if(!vis[nxt]){
                        pq.offer(new pair(nxt,cost+nxtCost));
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int node=sc.nextInt(),edge=sc.nextInt();
        Arrays.fill(vis,false);
        Arrays.fill(dist,INF);
        for(int i=0;i<=node;i++){
          G.add(new ArrayList<>());
        }
        for(int i=0;i<edge;i++){
            int u=sc.nextInt(),v=sc.nextInt(),w=sc.nextInt();
            G.get(u).add(new pair(v,w));
        }
        dijkstra(0);
        for(int i=0;i<=node;i++) {
            System.out.print(i+"->"+""+i+" Distance: ");
            if(dist[i]==INF) {
                System.out.println("INF"+" ");
            }else {
                System.out.println(dist[i]+" ");
            }
        }
    }
}
