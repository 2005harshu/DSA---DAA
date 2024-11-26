import java.util.*;
public class Frequency {
    public static void main(String[] args) {
        int[] arr={5,5,5,2,2,2,6};
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);

        }
        int ans=-1;
        int min=Integer.MAX_VALUE;
        for(int a:map.keySet()){
            int j=map.get(a);
            if(j<min){
                min=j;
                ans=a;
            }
        }
        System.out.println(ans);
    }
}
