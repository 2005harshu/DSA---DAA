package HashMap_Implement;

public class Genrics<T> {
    private String a;
    public static void main(String[] args) {
        Genrics<String> gd=new Genrics<String>();
        gd.a="abc";
        System.out.println(gd.a);

        Integer [] arr ={1,2,3};
        String [] arr1 ={"abc","def"};

        gd.display(arr);
        gd.display(arr1);
    }
    public static <T> void display(T[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
   
}
