import java.util.*;
public class K_Largest {
    static Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();

        }
        Arrays.sort(arr);
        int kth=arr[n-k];
        System.out.println(kth);
        
    }
}
