package Heap;
import java.util.*;
//Using generics
public class Heap_basic<T extends Comparable<T>> {

    //creating Arraylist
    private ArrayList<T> list;

    //constructor for arraylist
    public Heap_basic(){
        list=new ArrayList<>();
    }

    // Function to swap
    private void swap(int first,int second){
        T temp=list.get(first);
        list.set(first,list.get(second));
        list.set(second,temp);
    }

    // Parent constructor
    private int parent(int index){
        return (index-1)/2;
    } 

    //left child node constructor
    private int left(int index){
        return (index*2)+1;
    }

    //right child node constructor
    private int right(int index){
        return (index*2)+2;
    }

    // Function to Insert elements

    private void insert(T ele){
        list.add(ele);
        upheap(list.size()-1);
    }

    //Upheap 
    private void upheap(int index){
        if(index==0){
            return;
        }
        int p=parent(index);
        if(list.get(index).compareTo(list.get(p))<0){
            swap(index,p);
            upheap(p);
        }
    }

    public T remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("Removing From an Empty list!");
        }
        T temp=list.get(0);
        T last=list.remove(list.size()-1);
        if(!list.isEmpty()){
            list.set(0,last);
            downheap(0);
        }
        return temp;
    }

    //Downheap
    private void downheap(int index){
        int min=index;
        int left=left(index);
        int right=right(index);

        if(left<list.size() && list.get(min).compareTo(list.get(left))>0){
            min=left;
        }
        if(right<list.size() && list.get(min).compareTo(list.get(right))>0){
            min=right;
        }
        if(min!=index){
            swap(min,index);
            downheap(min);
        }

    }

    //heap Sort
    private ArrayList<T> heapsort() throws Exception{
        ArrayList<T> data=new ArrayList<>();
        while(!list.isEmpty()){
            data.add(this.remove());
        }
        return data;
    }

    //Display
    private ArrayList<T> display() throws Exception{
        ArrayList<T> data=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            data.add(list.get(i));
        }
        return data;
    }

    //Main function
    public static void main(String[] args) throws Exception {
        Heap_basic<Integer> heap=new Heap_basic<>();
        heap.insert(34);
        heap.insert(45);
        heap.insert(22);
        heap.insert(69);
        heap.insert(10);
        heap.insert(80);
        
        ArrayList data=heap.display();
        System.out.println(data);

        System.out.println(heap.remove());

        ArrayList sort=heap.heapsort();
        System.out.println(sort);
    }

}
