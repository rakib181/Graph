import java.util.*;

public class KosarajusSSC {
    static int MX=105;
    static ArrayList<ArrayList<Integer>>G=new ArrayList<>();
    static ArrayList<ArrayList<Integer>>transpose=new ArrayList<>();
    static Stack<Integer> st=new Stack<>();
    static boolean[] vis=new boolean[MX];

    static void init(int n){
        for (int i=0;i<n;i++){
            G.add(new ArrayList<>());
            vis[i]=false;
        }
    }
    static void addEdge(int u,int v){
        G.get(u).add(v);
    }
    static void dfs(int src){
        vis[src]=true;
        for (int it:G.get(src)){
            if(!vis[it]){
                dfs(it);
            }
        }
        st.push(src);
    }
    static void revDfs(int src){
        vis[src]=true;
        System.out.print(src+" ");
        for (int it:transpose.get(src)){
            if(!vis[it]){
                revDfs(it);
            }
        }
    }

    static void kosaRaju(int n){
        for (int i=0;i<n;i++){
            if (!vis[i]){
                dfs(i);
            }
        }
        for (int i=0;i<n;i++){
            transpose.add(new ArrayList<>());
        }
        for (int i=0;i<n;i++){
            vis[i]=false;
            for (int it:G.get(i)){
                transpose.get(it).add(i);
            }
        }
        while (!st.isEmpty()){
            int node=st.pop();
            if(!vis[node]){
                revDfs(node);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),e=sc.nextInt();
        init(n);
        for (int i=0;i<e;i++){
            int u=sc.nextInt(),v=sc.nextInt();
            addEdge(u,v);
        }
         kosaRaju(n);
    }
}
