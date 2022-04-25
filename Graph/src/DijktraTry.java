import java.util.*;

public class DijktraTry {
    static int MX=100000,INF=Integer.MAX_VALUE;static boolean flag=true;
    static ArrayList<ArrayList<pair>>G=new ArrayList<>();
    static boolean[] vis=new boolean[MX+2];
    static int[] dis=new int[MX+2];
    static int[] p=new int[MX+2];
    static  ArrayList<Integer>yo=new ArrayList<>();
    static class pair implements Comparable<pair>{
        int val;
        int wt;
        pair(int x,int y){
            this.val=x;
            this.wt=y;
        }
        public int compareTo(pair that){
            return this.wt- that.wt;
        }
    }
    static void dijkstra(int src) {
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.offer(new pair(src, 0));
        while (!pq.isEmpty()) {
            pair cur = pq.poll();
            int vertex = cur.val;
            int cost = cur.wt;
            if (!vis[vertex]) {
                vis[vertex] = true;
                dis[vertex] = cost;
                for (int i = 0; i < G.get(vertex).size(); i++) {
                    int nxt = G.get(vertex).get(i).val;
                    int nxtCost = G.get(vertex).get(i).wt;
                    if (!vis[nxt]) {
                        pq.offer(new pair(nxt, cost + nxtCost));
                        p[vertex]=nxt;
                    }
                }
            }
        }
    }
    static void path(int s){
        if(s!=1){
            path(p[s]);
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),e= sc.nextInt();
        Arrays.fill(vis,false);
        Arrays.fill(dis,INF);
        Arrays.fill(p,-1);
        for(int i=1;i<=n+1;i++){
            G.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            int u= sc.nextInt(),v=sc.nextInt(),w=sc.nextInt();
            G.get(u).add(new pair(v,w));
            G.get(v).add(new pair(u,w));
        }
        dijkstra(1);
        path(n);
    }
}
