package Algo;
import java.util.*;

public class Spanning_tree {
        HashMap<Integer,HashMap<Integer,Integer>> graph=new HashMap<>();
        public Spanning_tree(int vrtx){
            for(int i=1;i<=vrtx;i++){
                graph.put(i,new HashMap<Integer,Integer>());
            }
        }
        
        public  void addEdge(int v1,int v2,int w){
            graph.get(v1).put(v2,w);
            graph.get(v2).put(v1,w);
        }
        public void display(){
            for(int k:graph.keySet()){
                for(int a:graph.get(k).keySet()){
                    System.out.println(k+"<--"+graph.get(k).get(a)+"-->"+a);
                }
            }
        }


        class pair{
            int vrtx;
            int parent;
            int cost;

            pair(int vtrx,int parent,int cost){
                this.vrtx=vtrx;
                this.parent=parent;
                this.cost=cost;
            }
        }



        public void MST(){
            int ans=0;
            PriorityQueue<pair> pq=new PriorityQueue<>(new Comparator<pair>() {
                public int compare(pair o1,pair o2){
                    return o1.cost-o2.cost;
                }
            });
                pair pp=new pair(1,1,0);
                HashSet<Integer> visited=new HashSet<>();
                pq.add(pp);
                while(!pq.isEmpty()){
                    pair r=pq.remove();
                    if(visited.contains(r.vrtx)){
                        continue;
                    }
                    visited.add(r.vrtx);
                    System.out.println(r.vrtx);
                    ans+=r.cost;
                    for(int  k:graph.get(r.vrtx).keySet()){
                        pair np=new pair(k, r.vrtx, graph.get(r.vrtx).get(k));
                        pq.add(np);
                    }
        
                }
                System.out.println(ans);
                
        }

        
        public static void main(String[] args) {
            Spanning_tree gr=new Spanning_tree(4);
            gr.addEdge(1,2,10);
            gr.addEdge(2,3,15);
            gr.addEdge(1,4,5);
            gr.addEdge(3,4,35);
            gr.display();
            gr.MST();
        }
    // DISJOINT SETS.
}
