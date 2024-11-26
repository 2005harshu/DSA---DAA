package HashMap_Implement;

import java.util.HashMap;
import java.util.HashSet;

public class graph {
	 static HashMap<Integer,HashMap<Integer,Integer>> m=new HashMap<>();
	public graph(int v){ //v = number of vertex
		for(int i=1;i<=v;i++) {
			m.put(i, new HashMap<Integer,Integer>());
		}
	}
	public void addEdge(int v1,int v2,int weight) {
		m.get(v1).put(v2, weight);
		//m.get(v2).put(v1, weight);
	}
	public void removeEdge(int v1,int v2) {
		m.get(v1).remove(v2);
		m.get(v2).remove(v1);
	}
	public boolean hasVertex(int v) {
		return m.containsKey(v);
	}
	public boolean hasEdge(int v1,int v2) {
		return m.get(v1).containsKey(v2) && m.get(v2).containsKey(v1);
	}
	public void removeVertex(int v) {
		for(int i: m.get(v).keySet()) {
			m.get(i).remove(v);
		}
		m.remove((v));
	}
	// public boolean hasPath(int v1,int v2) { // To check path exist or ot between v1 and v2
	// 	if(v1==v2) {
	// 		return true;
	// 	}
	// 	for(int i:m.get(v1).keySet()) {
	// 		boolean a=hasPath(i,v2);
	// 		if(a) {
	// 			return true;
	// 		}
	// 	}
	// 	return false;
	// }
    //print the path
    public static void display() {
		for(int k:m.keySet()) {
			for(int a:m.get(k).keySet()) {
				System.out.println(k+"<--"+m.get(k).get(a)+"-->"+a);
			}
		}
	}
    public void allPath(int v1,int v2,List<String> l) {
		if(v1==v2) {
			System.out.println(l);
			return;
		}
		for(int i:m.get(v1).keySet()) {
			l.add(v1+"->"+i);
			allPath(i,v2,l);
			l.remove(l.size()-1);
		}
	}
    //show that it contains paths or not

    public static boolean find_Path(int v1,int v2){
        HashSet<Integer> visited=new HashSet<>();
        return find_Path(v1, v2,visited);
    }
    public static boolean find_Path(int v1,int v2,HashSet<Integer> visited){
        if(v1==v2) return true;
        visited.add(v1);
        for(int a:m.get(v1).keySet()){
            if(!visited.contains(a)){
                boolean b=find_Path(a, v2, visited);
                if(b) return true;
            }
        }
        visited.remove(v1);
        return false;
    }
	public static void main(String[] args) {
        graph g=new graph(7);
		g.addEdge(1,2,10);
		g.addEdge(2,3,10);
		g.addEdge(3,4,10);
		g.addEdge(4,5,10);
		g.addEdge(5,6,10);
		g.addEdge(6,7,10);
		g.addEdge(5,7,10);
		g.addEdge(1,4,10);
        System.out.println(find_Path(1, 7));
         display();
		// List<String> l=new ArrayList<>();
		// g.allPath(1,7,l);
		
	}
}

