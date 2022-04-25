import java.util.*;
public class KahnsAlgoTopologicalSortBfs {
    static int MX=105;
    static ArrayList<LinkedList<Integer>>G=new ArrayList<>();
    static ArrayList<Integer> ans=new ArrayList<>();
    static int[] inDeg=new int[MX];

    static void bfs(int src,int V){
        Queue<Integer> q=new ArrayDeque<>();
        for(int i=0;i<V;i++){
            if(inDeg[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int cur=q.poll();
            ans.add(cur);
            for(int i=0;i<G.get(cur).size();i++){
                int nxt=G.get(cur).get(i);
                if(--inDeg[nxt]==0){
                    q.offer(nxt);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int node= sc.nextInt(),edge=sc.nextInt();
        for(int i=0;i<node;i++){
            G.add(new LinkedList<>());
        }
        for(int i=0;i<edge;i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            G.get(u).add(v);
        }
        for(int i=0;i<node;i++){
            for(int j=0;j<G.get(i).size();j++){
               inDeg[j]++;
            }
        }
       bfs(0,node);
    }
}
