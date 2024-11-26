package Stack;
import java.util.*;
public class first {
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        st.push(2);
        st.push(5);
        st.push(6);
        st.push(8);
        System.out.println(st);

        //Using two stack

        // Stack<Integer> st2=new Stack<>();
        // while(!st.isEmpty()){
        //     st2.push(st.pop());
        // }
        // System.out.println(st2);
        rev(st);
    }

    public static void rev(Stack<Integer> st){
        //Stack<Integer> st2=new Stack<>();
        if(st.isEmpty()){
            return;
        }
        int temp=st.pop();
        rev(st);
        st.insertElementAt(temp,0);
        System.out.println(st);

    }
    
}
