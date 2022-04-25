import java.util.*;

public class BipertiteTry {
    static int MX=105;
    static ArrayList<ArrayList<Integer>>G=new ArrayList<>();
    static int[] color=new int[MX];

    static boolean bfs(int src){
        Queue<Integer>q=new ArrayDeque<>();
        color[src]=1;
        q.offer(src);
        while(!q.isEmpty()){
            int node=q.poll();
            for(Integer it:G.get(node)){
                if(color[it]==-1){
                    color[it]=1-color[node];
                    q.offer(it);
                }else if(color[it]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isBipertite(int n){
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(!bfs(i)){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int node= sc.nextInt(),edge=sc.nextInt();
        Arrays.fill(color,-1);
        for(int i=0;i<=node;i++){
            G.add(new ArrayList<>());
        }
        for(int i=0;i<edge;i++){
            int u=sc.nextInt(),v=sc.nextInt();
            G.get(u).add(v);
            G.get(v).add(u);
        }
        if(isBipertite(node)){
            System.out.println("Bipertite !");
        }else{
            System.out.println("Not Bipertite !");
        }
    }
}
