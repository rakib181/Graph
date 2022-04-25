import java.util.*;
public class DFS {
    static int MX=105;
    static ArrayList<ArrayList<Integer>>G=new ArrayList<>();
    static boolean[]vis=new boolean[MX];
    static void dfs(int src){
        Stack<Integer> st=new Stack<>();
        st.push(src);
       while(!st.isEmpty()){
           int node=st.peek();
           st.pop();
           if(!vis[node]){
               vis[node]=true;
               System.out.print(node+" ");
           }
           for (int nxt : G.get(node)) {
               if (!vis[nxt]) {
                   st.push(nxt);
               }
           }
       }
    }
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       Arrays.fill(vis,false);
       int node=sc.nextInt();
       for(int i=0;i<=node;i++){
           G.add(new ArrayList<>());
       }
       for(int i=0;i<node;i++){
           int u=sc.nextInt(),v=sc.nextInt();
           G.get(u).add(v);
       }
       dfs(0);
    }
}
