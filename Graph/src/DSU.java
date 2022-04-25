import java.util.*;
public class DSU {
    static int MX=1000005;
    static int[] parent =new int[MX];
    static int[] size=new int[MX];
   static void makeSet(int v){
        for(int i=1;i<=v;i++){
            parent[i]=i;
        }
      // size[v]=1;
    }
    static int find(int v){
       if(parent[v]==v){
           return v;
       }
       return parent[v]=find(parent[v]);
    }
    static void Union(int u,int v){
       u=find(u);
       v=find(v);
       if(u!=v){
          // if(size[u]<size[v]){
             //  u^=v;
         //      v^=u;
         //      u^=v;
         //  }
           parent[v]=u;
          // size[u]+=size[v];
       }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            makeSet(n);
            int[] arr=new int[n+1];
            for(int i=1;i<=n;i++){
                arr[i]=sc.nextInt();
            }
            for(int j=1;j<=n;j++){
            for(int i=j+1;i<=n;i++) {
                if (arr[j] > arr[i]) {
                    Union(arr[j], arr[i]);
                }
            }
            }
            int Connected_cnt=0;
            for(int i=1;i<=n;i++) {
                if (find(arr[i])==arr[i]){
                    Connected_cnt++;
                }
            }
            System.out.println(Connected_cnt);
          /*  Set<Integer> componenets=new HashSet<>();
            for(int i=1;i<=n;i++){
                componenets.add(find(arr[i]));
            }
            System.out.println(componenets.size());*/
        }
    }
}
