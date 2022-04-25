import java.util.*;
public class DetectCycle {
    static int MX=105;
    static ArrayList<LinkedList<Integer>>Graph=new ArrayList<>();
    static boolean[] vis=new boolean[MX];
    static boolean dfs(int src,int parent){
       vis[src]=true;
        for(int i=0;i<Graph.get(src).size();i++){
            int nxt=Graph.get(src).get(i);
            if(!vis[nxt]){
                if(dfs(nxt,src)){
                    return true;
                }
            }else if(parent!=nxt){
                return true;
            }
        }
        return false;
    }
    static boolean isCycle(int V){
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(i,-1)){
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
        for(int i=0;i<node;i++){
            Graph.add(new LinkedList<>());
        }
        for(int i=0;i<edge;i++){
            int u=sc.nextInt(),v=sc.nextInt();
            Graph.get(u).add(v);
            Graph.get(v).add(u);
        }
        if(isCycle(node)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
