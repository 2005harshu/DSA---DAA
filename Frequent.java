import java.util.*;
class tree{
    int num;
    int freq;
    public tree(int num,int freq){
        this.num=num;
        this.freq=freq;
    }
}
public class Frequent {
    static Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int k=sc.nextInt();
    HashMap<Integer,Integer> map=new HashMap<>();
    for(int i=0;i<n;i++){
        int ele=sc.nextInt();
        map.put(ele,map.getOrDefault(ele,0)+1);
    }
    PriorityQueue<tree> pq=new PriorityQueue<>((a,b)-> b.freq-a.freq);
    for(int num:map.KeySet()){
        pq.add(new tree(num,map.get(num)));
    }
    for(int i=0;i<k;i++){
        s
    }
}
