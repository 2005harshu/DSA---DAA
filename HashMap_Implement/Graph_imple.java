package HashMap_Implement;
import java.util.*;
import java.util.HashMap;
import java.util.HashSet;

public class Graph_imple {
    HashMap<Integer,HashMap<Integer,Integer>> graph=new HashMap<>();
    public Graph_imple(int v){
        for(int i=1;i<=v;i++){
            graph.put(i,new HashMap<Integer,Integer>());
        }
    }
    
    public  void addEdge(int v1,int v2,int w){
        graph.get(v1).put(v2,w);
        graph.get(v2).put(v1,w);
    }
    public void removeEdge(int v1,int v2){
        graph.get(v1).remove(v2);
        graph.get(v2).remove(v1);
    }
    public boolean hasVertex(int v){
        return  graph.containsKey(v);

    }
    public boolean hasEdge(int v1, int v2){
        return  graph.get(v1).containsKey(v2) &&  graph.get(v2).containsKey(v1);
    }

    public void removevertex(int v){
        for(int k:graph.get(v).keySet()){
            graph.get(k).remove(v);
        }
        graph.remove(v);
    }

    public void display(){
        for(int k:graph.keySet()){
            for(int a:graph.get(k).keySet()){
                System.out.println(k+"<--"+graph.get(k).get(a)+"-->"+a);
            }
        }
    }

    public void findPath(int v1,int v2){
        HashSet<Integer> visited = new HashSet<Integer>();
        pfindPath(v1,v2,visited);

         
    }
    public boolean pfindPath(int v1,int v2,HashSet<Integer> visited){
        if(v1==v2){
            return true;
        }
        visited.add(v1);
        for(int k:graph.get(v1).keySet()){
            if(!visited.contains(k)){
                boolean b=pfindPath(k, v2,visited);
                if(b){
                    return true;
                }
            }
        }
        visited.remove(v1);
        return false;
        
    }
    public void allPath(int v1,int v2){
        HashSet<Integer> visited = new HashSet<Integer>();
        allfindPath(v1,v2,visited,v1+"");

         
    }

    public void allfindPath(int v1,int v2,HashSet<Integer> visited,String ans){
        if(v1==v2){
            System.out.println(ans);
            return;
        }
        visited.add(v1);
        for(int k:graph.get(v1).keySet()){
            if(!visited.contains(k)){
                allfindPath(k, v2,visited,ans+k);
            }
        }
         visited.remove(v1);
    }
    public static void main(String[] args) {
        Graph_imple g = new Graph_imple(6);
        g.addEdge(1,2,10);
        g.addEdge(1,3,15);
        g.addEdge(2,4,20);
        g.addEdge(2,5,25);
        g.addEdge(3, 6, 30);
        g.addEdge(3, 5, 35);
        g.display();
		g.allPath(03, 5);
		g.findPath(3,5);
		//g.bfs(3);
        //g.dfs(3);
        //g.BFT(3);
    }

	public void bfs(int v){ 
		Queue<Integer> q= new LinkedList<Integer>();
		HashSet<Integer> visited=new HashSet<>();
		q.add(v);
		while(!q.isEmpty()){
			int r=q.poll();
			if(visited.contains(r)){
				continue;
			}
			visited.add(r);
			System.out.println(r);
			for(int  k:graph.get(r).keySet()){
				q.add(k);
			}

		}
	}

    public void dfs(int v){
        HashSet<Integer> visited=new HashSet<>();
        Stack<Integer> stack=new Stack<>();
        stack.push(v);
        while(!stack.isEmpty()){
            int r=stack.pop();
            if(visited.contains(r)){
                continue;
                }
            visited.add(r);
            System.out.println(r);
            for(int k:graph.get(r).keySet()){
                stack.push(k);
            }
        }

    }

    public void BFT(int v){
        HashSet<Integer>  visited=new HashSet<>();
        for(int a:graph.keySet()){
            if(!visited.contains(a)){
                Queue<Integer> q= new LinkedList<Integer>();
		
		        q.add(v);
		        while(!q.isEmpty()){
			        int r=q.poll();
			        if(visited.contains(r)){
				        continue;
                    }
			        visited.add(r);
			        System.out.println(r);
			        for(int  k:graph.get(r).keySet()){
				        q.add(k);
                    }
                }
            
            }
        }
    }
    public void nocomp(int v1,int v2){
        HashSet<Integer> visited=new HashSet<>();
        int count=0;
        for(int a:graph.keySet()){
            if(!visited.contains(a)){
                Queue<Integer> q= new LinkedList<Integer>();
		
		        q.add(v);
		        while(!q.isEmpty()){
			        int r=q.poll();
			        if(visited.contains(r)){
				        continue;
                    }
			        visited.add(r);
			        System.out.println(r);
			        for(int  k:graph.get(r).keySet()){
				        q.add(k);
                    }
                }
            
            }
        }
    }
}
