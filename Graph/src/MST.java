import java.util.*;

public class MST {
    static int MX=105;
    static ArrayList<ArrayList<pair>>G=new ArrayList<>();
    static int[] dis=new int[MX];
    static boolean[] vis=new boolean[MX];
    static ArrayList<pair>yo=new ArrayList<>();
  /*  static  public class pair{
        public int v;
        public int wt;
        pair(int x,int y){
            this.v=x;
            this.wt=y;
        }
    }*/
    static class pair implements Comparable<pair>{
        int v;
        int wt;
        pair(int v,int wt){
            this.v=v;
            this.wt=wt;
        }
        public int compareTo(pair that){
            return this.wt- that.wt;
        }
  }
    static int minimumSpanningTree(){
        PriorityQueue<pair>pq= new PriorityQueue<>();
        pq.offer(new pair(0,0));
        int ans=0;
        while(!pq.isEmpty()){
            pair cur=pq.poll();
            int v=cur.v;
            if(vis[v]){
                continue;
            }
            ans+=cur.wt;
            yo.add(cur);
            vis[v]=true;
            for(int i=0;i<G.get(v).size();i++){
                int vertex=G.get(v).get(i).v;
                int cost=G.get(v).get(i).wt;
                if(!vis[vertex]){
                    pq.offer(new pair(vertex,cost));
                }
            }

        }
        return ans;
    }
   /* static class cmp implements Comparator<pair>{
        public int compare(pair a,pair b){
            if(b.wt<a.wt){
                return 1;
            }
            return -1;
        }
    }*/
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int node=sc.nextInt(),edge=sc.nextInt();
        Arrays.fill(vis,false);
        for(int i=0;i<=node;i++){
            G.add(new ArrayList<>());
        }
        for(int i=0;i<edge;i++){
            int u=sc.nextInt(),v=sc.nextInt(),w=sc.nextInt();
            G.get(u).add(new pair(v,w));
        }
        int ans=minimumSpanningTree();
        System.out.println(ans);
    }
}
