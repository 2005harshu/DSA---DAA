import java.util.*;
public class Top{
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();

        }
        HashMap<Integer,Integer> map=new HashMap<>();
        List<Integer> ans =new ArrayList<>();
        for(int i=0;i<n;i++){
            int num=arr[i];
            map.put(num,map.getOrDefault(num,0)+1);
            List<Integer> li=new ArrayList<>(map.keySet());
            Collections.sort(li,new Comparator<Integer>(){
                public int compare(Integer a,Integer b){
                    int freqA=map.get(a);
                    int freqB=map.get(b);
                    if(freqA==freqB){
                        return a-b;
                    }
                    return freqB-freqA;
                }
            });
            for(int j=0;j<Math.min(k,li.size());j++){
                ans.add(li.get(j));
            }
        }
        for(int i:ans){
            System.out.println(i+" ");
        }
    }
}