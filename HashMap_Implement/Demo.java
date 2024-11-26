package HashMap_Implement;
import java.lang.reflect.Array;
import java.util.*;

public class Demo<k,v>{
    int ele =0;
    //CREATING NODE
    class Node{
        k key;
        v value;
        Node next;

        public Node(k key , v value){
            this.key = key;
            this.value = value;
        }
    }

    ArrayList<Node> map=new ArrayList<>();

    public Demo(int size){
        for(int i=0;i<size;i++){
            map.add(null);
        }
    }

    public Demo(){
        // for(int i=0;i<4;i++){
        //     map.add(null);
        // }

        this(4);
    }



    public int findIndex(k key){
        int idx=key.hashCode() % map.size();
        return idx;
    }

    public void put(k key, v val){
        int idx=findIndex(key);
        Node head=map.get(idx);
        Node temp=head;
        while(temp!=null){
            if(temp.key.equals(key)){
                temp.value=val;
                return;
            }
            temp=temp.next;

        }
        Node nn =new Node(key,val);
        map.set(idx,nn);
        nn.next=head;
        ele++;

        int thf=2;
        int lf=ele/map.size();
        if(lf>thf){
            rehashing();
        }
    }

    private void rehashing(){
        ArrayList<Node> newmap=new ArrayList<>();
        for(int i=0;i<2*map.size();i++){
            newmap.add(null);
        }
        ArrayList<Node> oldmap=map;
        map=newmap;

        for(Node nn:oldmap){
            while(nn!=null){
                //int idx=findIndex(nn.key);
                put(nn.key,nn.value);
                nn=nn.next;
            }
        }
    }



    public boolean containsKey(k key){

        int idx=findIndex(key);
        
        Node temp=map.get(idx);
        while(temp!=null){
            if(temp.key.equals(key)){
                
                return true;
            }
            temp=temp.next;

        }
        return false;
    }

    public void remove(k key){
        int idx=findIndex(key);
        Node head=map.get(idx);
        Node prev=null;
        while(head!=null){
            if(head.key.equals(key)){
                prev.next=head.next;
                head.next=null;
            }
            prev=head;
            head=head.next;
        }
    }

    public void get(k key){

    }
}
