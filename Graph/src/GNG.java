import java.util.*;

public class GNG {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long[][] dist=new long[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                dist[i][j]=sc.nextLong();
            }
        }
        ArrayList<Integer> del_ord=new ArrayList<>();
        for(int i=0;i<n;i++){
            del_ord.add(sc.nextInt());
        }
        Collections.reverse(del_ord);
        ArrayList<Long> ans=new ArrayList<>();
        //Floyd Warshall Algorithm (All Pair The Shortest Path)
        for(int k=0;k<n;k++){
           int k_v=del_ord.get(k);
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    long new_dist=dist[i][k_v]+dist[k_v][j];
                    dist[i][j]=Math.min(dist[i][j],new_dist);
                }
            }
            long sum=0;
            for(int i=0;i<=k;i++){
                for(int j=0;j<=k;j++){
                    sum+=dist[del_ord.get(i)][del_ord.get(j)];
                }
            }
            ans.add(sum);
        }

        for(int i= ans.size()-1;i>=0;i--){
            System.out.print(ans.get(i)+" ");
        }
        System.out.println();
    }
}
