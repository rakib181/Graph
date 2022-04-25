import java.util.*;

public class BFS {
    static int MX =105,INF=Integer.MAX_VALUE;
    static ArrayList<ArrayList<Integer>>G=new ArrayList<>();
    static boolean[] vis=new boolean[MX];
    static int[] dis=new int[MX];
    static void bfs(int src){
        Queue<Integer> q=new ArrayDeque<>();
        vis[src]=true;
        dis[src]=0;
        q.add(src);
        while(!q.isEmpty()){
            int node=q.peek();
            System.out.print(node+" ");
            q.poll();
            for(int i=0;i<G.get(node).size();i++){
                int nxt=G.get(node).get(i);
                if(!vis[nxt]){
                    vis[nxt]=true;
                    dis[nxt]=dis[node]+1;
                    q.add(nxt);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner((System.in));
        int node=sc.nextInt(),edge=sc.nextInt();
        Arrays.fill(vis,false);
        Arrays.fill(dis,INF);
        for(int i=0;i<=node;i++){
            G.add(new ArrayList<>());
        }
        for(int i=0;i<edge;i++){
            int u=sc.nextInt(),v=sc.nextInt();
            G.get(u).add(v);
        }
        bfs(2);
        System.out.println();
        for(int i=0;i<node;i++){
            System.out.print(dis[i]+" ");
        }
    }
}
