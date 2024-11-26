import java.util.*;
public class Hostel_visit {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int q=sc.nextInt();
        int k=sc.nextInt();
        PriorityQueue<Long> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<q;i++){
            int type =sc.nextInt();
            if(type==1){
                int x=sc.nextInt();
                int y=sc.nextInt();
                long distance=(long)x*x+(long)y*y;
                if(pq.size()<k){
                    pq.add(distance);
                }
                else if(distance<pq.peek()){
                    pq.poll();
                    pq.add(distance);
                }
            }
            else if(type==2){
                System.out.println(pq.peek());
            }
        }
    }
}
