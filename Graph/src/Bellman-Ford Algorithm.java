import java.util.*;

public class BellmanFord {
    static int MX=105,INF=Integer.MAX_VALUE;
    static ArrayList<edge>G=new ArrayList<>();
    static int[] dist=new int[MX];

    static class edge{
        int u,v,w;
        edge(int u,int x,int y){
            this.u=u;
            this.v=x;
            this.w=y;
        }
    }
    static void init(int n){
        Arrays.fill(dist,INF);
    }
    static void addEdge(int u,int v,int wt){
       G.add(new edge(u,v,wt));
    }
    static void bellmannFord(int src,int n){
        dist[src]=0;
        for (int i=0;i<n;i++){
            for (edge e:G){
                if(dist[e.u]+e.w<dist[e.v]){
                    dist[e.v]=dist[e.u]+e.w;
                }
            }
        }
        boolean flag=true;
        for (edge e:G){
            if(dist[e.u]+e.w<dist[e.v]){
                flag=false;
                break;
            }
        }
        if(!flag){
            System.out.println("Negative Cycle");
        }else{
            for (int i=0;i<n;i++){
                System.out.println(i+"->"+dist[i]+" ");
            }
            System.out.println();
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
        int src=sc.nextInt();
        bellmannFord(src,n);
    }
}
