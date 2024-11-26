import java.util.*;
public class String_sort {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int n=sc.nextInt();
        String[] st=new String[n];
        for(int i=0;i<n;i++){
            st[i]=sc.nextLine();
        }
        Arrays.sort(st,new Comparator<String>(){
            public int compare(String s1,String s2){
                if(s1.startsWith(s2) || s2.startsWith(s1)){
                    return s2.length()-s1.length();
                }
                return s1.compareTo(s2);
            }
        });
        for(String str:st){
            System.out.println(str);
        }

    }
}
