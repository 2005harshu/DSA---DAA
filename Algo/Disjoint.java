package Algo;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Disjoint {
    public class Node{
        int val;
        Node parent;
        int rank;

    }

    HashMap<Integer,Node> map=new HashMap<>();

    //CREATE
    public void create(int v){
        Node nn=new Node();
        nn.val=v;
        nn.rank=0;
        nn.parent=nn;
        map.put(v,nn);

    }

    //FIND PARENT

    public int findparent(int v){
        Node nn=map.get(v);
        return findparent(nn).val;
    }
    public Node findparent(Node nn){
        if(nn.parent==nn){
            return nn;
        }
        Node n=findparent(nn.parent);
        nn.parent=n;   // Path Compression
        return n;
    }

    //Union

    public void union(int v1,int v2){
        Node n1=map.get(v1);
        Node n2=map.get(v2);
        Node re1=findparent(n1);
        Node re2=findparent(n2);

        if(re1.rank==re2.rank){
            re1.parent=re2;
            re2.rank=re2.rank+1;

        }
        else if(re1.rank>re2.rank){
            re2.parent=re1;
        }
        else{
            re1.parent=re2;
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

    public ArrayList<pair> edgelist(){
        ArrayList<pair> ll=new ArrayList<>();
        for(int k:map.keySet()){
            for(int j:map.get(k).keySet()){
                int cost=map.get(k).get(j);
                pair pp=new pair(k,j,cost);
                ll.add(pp);
            }
        }
        
    }



    //Main
    public static void main(String[] args) {
        Disjoint d=new Disjoint();
        for(int k:map.keySet()){
            d.create(k);
        }

        ArrayList<e>
    }
}
