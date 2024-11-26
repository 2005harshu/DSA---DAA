// package HashMap_Implement;
// import java.util.*;
// import java.util.ArrayList;
// import java.util.HashMap;

// public class Bell_mann_Ford {
//     class pair{
//         int vrtx_1;
//         int vrtx_2;
//         // int path;
//         int cost;

//         pair(int vtrx_1,int vrtx_2,int cost){
//             this.vrtx_1=vtrx_1;
//             this.vrtx_2=vrtx_2;
//             this.cost=cost;
//         }
//         public String toString(){
//             return vrtx_1+"<-->"+vrtx_2+"  :"+cost;
//         }
//     }
   
//     HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<>();
//     int vrtx=0;
//         public Bell_mann_Ford(int vrtx){
//             for(int i=0;i<=vrtx;i++){
//                 map.put(i,new HashMap<Integer,Integer>());
//             }
//         }
        
//         public  void addEdge(int v1,int v2,int w){
//             map.get(v1).put(v2,w);
//             //map.get(v2).put(v1,w);
//         }
//         public void display(){
//             for(int k:map.keySet()){
//                 for(int a:map.get(k).keySet()){
//                     System.out.println(k+"<--"+map.get(k).get(a)+"-->"+a);
//                 }
//             }
//         }

//         public ArrayList<pair> edgelist(){
//             ArrayList<pair> ll=new ArrayList<>();
//             for(int k:map.keySet()){
//                 for(int j:map.get(k).keySet()){
//                     int cost=map.get(k).get(j);
//                     pair pp=new pair(k,j,cost);
//                     ll.add(pp);
//                 }
//             }
//             return ll;
//         }

//         public void Belmanford(){
//             int[] cost =new int[vrtx];
//             Arrays.fill(cost,Integer.MAX_VALUE);
//             cost[0]=0;
//             ArrayList<pair> list=edgelist();
//             for(int i=0;i<=vrtx;i++){
//             for(pair k:list){
//                 int v1=k.vrtx_1;
//                 int v2=k.vrtx_2;
//                 int wt=k.cost;

//                 int oldcost=cost[v2];
//                 int newcost=cost[v1]+wt;

//                 if(i==vrtx && newcost<oldcost){
//                     System.out.println("-ve edge");
//                     return;
//                 }

//                 if(newcost<oldcost){
//                     cost[v2]=newcost;
//                 }
//             }
//             }
//             System.out.println(Arrays.toString(cost));


//         }
//         public static void main(String[] args) {
//             Bell_mann_Ford gr=new Bell_mann_Ford(5);
//             gr.addEdge(0,1,-10);
//             gr.addEdge(0,2,10);
//             gr.addEdge(1,4,25);
//             gr.addEdge(1,3,10);
//             gr.addEdge(2,3,20);
//             gr.addEdge(3,4,-5);
//             gr.edgelist();
//             //gr.display();
//             gr.Belmanford();
           
//         }
// }


package Algo;

import java.util.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Balmanford {
     HashMap<Integer,HashMap<Integer,Integer>> graph=new HashMap<>();
     int vtx=0;
    public Balmanford(int v){
     vtx=v;
        for(int i=0;i<=v;i++){
            graph.put(i,new HashMap<Integer,Integer>());
        }
    }
    public  void addEdge(int v1,int v2,int w){
        graph.get(v1).put(v2,w);
        // graph.get(v2).put(v1,w);
    }
   
    public   void display() {
        for(int k:graph.keySet()) {
            for(int a:graph.get(k).keySet()) {
                System.out.println(k+"<--"+graph.get(k).get(a)+"-->"+a);
            }
        }
    
    }
    public class pair{
        int v1;
        int v2;
        int cost;
        pair(int v1,int v2 ,int cost){
            this.v1=v1;
            this.v2=v2;
            this.cost=cost;
        }
        public String toString(){
                return v1+" "+v2+" "+cost;
    }
    }
   
     
    public void balmanford(){
         int [] cost=new int[vtx];
         Arrays.fill(cost,Integer.MAX_VALUE);
         cost[0]=0;
         ArrayList<pair> list=addList();
         for(int i=0;i<vtx-1;i++){
            for( pair k:list){
                //System.out.println(k);
                int v1=k.v1;
                int v2=k.v2;
                int wt=k.cost;
                int oldcost=cost[v2];
                int newcost=cost[v1]+wt;
                if(i==vtx && newcost<oldcost){
                        System.out.println("-ve edge");
                        return;
                }
                if(newcost<oldcost){
                    cost[v2]=newcost;
                 }


            }
        }
         System.out.println(Arrays.toString(cost));

    }
    public ArrayList<pair> addList(){
        ArrayList<pair> list=new ArrayList<>();
        for(int k:graph.keySet()){
            for(int j:graph.get(k).keySet()){
                    int cost=graph.get(k).get(j);
                    pair pp=new pair(k, j, cost);
                    list.add(pp);
            }
        }
        return list;
       // System.out.print(list);
    }
    public static void main(String[] args) {
        Balmanford a=new Balmanford(6);
        a.addEdge(0, 1, -10);
        a.addEdge(0, 2, 10);
        a.addEdge(1, 4, 25);
        a.addEdge(1, 3, 10);
        a.addEdge(2, 3, 20);
        a.addEdge(3, 4, -5);
        a.addEdge(3, 0,0 -5);
       // a.display();
       // a.addList();
        a.balmanford();
        //System.out.println();
    }
}
