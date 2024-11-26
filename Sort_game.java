import java.util.*;
public class Sort_game{
    static Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {
        int k=sc.nextInt();
        int n=sc.nextInt();
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            String st=sc.nextLine();
            int sal=sc.nextInt();
            map.put(st,sal);
        }
        PriorityQueue<Map.Entry<String,Integer>> pq=new PriorityQueue<>(new Comparator<Map.Entry<String,Integer>>(){
            public int compare(Map.Entry<String,Integer> e1,Map.Entry<String,Integer> e2){
                if(!e1.getValue().equals(e2.getValue())){
                    return e2.getValue().compareTo(e1.getValue());
                }
                return e1.getKey().compareTo(e2.getKey());
            }
        });
        for(Map.Entry<String,Integer> i:map.entrySet()){
            if(i.getValue()>=k){
                pq.add(i); 
            }
        }
        while(!pq.isEmpty()){
            Map.Entry<String,Integer> ans=pq.poll();
            System.out.println(ans.getKey()+" " +ans.getValue());
        }
    }
}