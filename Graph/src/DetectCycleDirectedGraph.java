import java.util.*;
public class DetectCycleDirectedGraph {
    static int MX=105;
    static ArrayList<LinkedList<Integer>>G=new ArrayList<>();
    static boolean[] vis=new boolean[MX];
    static  boolean[] contains=new boolean[MX];
    static boolean dfs(int src){
        vis[src]=true;
        contains[src]=true;
        for(int i=0;i<G.get(src).size();i++){
            int nxt=G.get(src).get(i);
            if(!vis[nxt]){
                if(dfs(nxt)){
                    return true;
                }
            }else if(contains[nxt]){
                return true;
            }
        }
        contains[src]=false;
        return false;
    }
    static boolean isCycle(int V){
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(i)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int node=sc.nextInt(),edge=sc.nextInt();
        Arrays.fill(vis,false);
        Arrays.fill(contains,false);
        for(int i=0;i<node+1;i++){
            G.add(new LinkedList<>());
        }
        for(int i=0;i<edge;i++){
           int u=sc.nextInt(),v= sc.nextInt();
           G.get(u).add(v);
        }
        System.out.println(isCycle(node)?"YES":"NO");
    }
}
