import java.util.*;
public class TopologicalSort {
    static int MX=105;
    static ArrayList<LinkedList<Integer>>G=new ArrayList<>();
    static  boolean[]vis=new boolean[MX];
    static Stack<Integer> st=new Stack<>();
    static void dfs(int src){
        vis[src]=true;
        for(int i=0;i<G.get(src).size();i++){
            int nxt=G.get(src).get(i);
            if(!vis[nxt]) {
                dfs(nxt);
            }
        }
        st.push(src);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int node=sc.nextInt(),edge=sc.nextInt();
        Arrays.fill(vis,false);
        for(int i=0;i<node+1;i++){
            G.add(new LinkedList<>());
        }
        for(int i=0;i<edge;i++){
            int u=sc.nextInt(), v=sc.nextInt();
            G.get(u).add(v);
        }
       for(int i=0;i<node;i++){
           if(!vis[i]) {
               dfs(i);
           }
        }

       int[] res=new int[st.size()+1];
       int i=0;
       while(!st.isEmpty()){
           res[i++]=st.pop();
       }
       for(int j=0;j<node;j++){
           System.out.print(res[j]+" ");
       }
    }
}
