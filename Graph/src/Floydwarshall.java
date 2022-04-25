import java.util.*;

public class Floydwarshall {
    static int MX=105,INF=Integer.MAX_VALUE;
    static long[][] dist=new long[MX][MX];
    static long[][] next=new long[MX][MX];
    static long[] path=new long[MX];

    static void floydWarshall(int n){
        for (int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                   if(dist[i][j]>dist[i][k]+dist[k][j]){
                       // dist[i][j]=dist[i][j] | (dist[i][k] & dist[k][j]);
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                   }
                   next[i][j]=next[i][k] ;
                }
            }
        }

    }
    static void findPath(long s,long d){
        while(s!=d){
            s=next[(int)s][(int)d];
            path[(int)s]=s;
        }
        for(int i=(int)s;i<=d;i++){
            System.out.print(path[i]+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int node=sc.nextInt(),edge=sc.nextInt();
        for(int i=1;i<=edge;i++){
            for(int j=1;j<=edge;j++){
                if(i==j){
                    dist[i][j]=0;
                }else {
                    dist[i][j] = INF;
                }
            }
        }
        for(int i=1;i<=edge;i++) {
            int u = sc.nextInt(), v = sc.nextInt(), wt = sc.nextInt();
            dist[u][v]=wt;
        }
        floydWarshall(edge);
        for(int i=1;i<=edge;i++){
            for(int j=1;j<=edge;j++){
                if(dist[i][j]==INF){
                    System.out.print("INF"+" ");
                }else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
        findPath(1,3);
    }
}
