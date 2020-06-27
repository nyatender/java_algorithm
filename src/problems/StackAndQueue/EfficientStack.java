package problems.StackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class EfficientStack {
    public static void main(String[] args) {
        STACK st = new STACK();
        st.push(12);
        System.out.println(st.getMin());
        st.push(17);
        System.out.println(st.getMin());
        st.push(8);
        System.out.println(st.getMin());
        st.push(15);
        System.out.println(st.getMin());
        st.push(7);
        System.out.println(st.getMin());
        st.pop();
        System.out.println(st.getMin());
    }
}

class STACK <T>{
    int min;
    private Stack<Integer>ST = new Stack<>();
    public void push(int val) {
        if(ST.isEmpty())
            min = val;
        else if(val < min) {
            int new_min = val;
            val = 2*val - min;
            min = new_min;
        }
        ST.push(val);
    }
    public void pop() {
        if(ST.peek() < min) {
            min = 2 * min - ST.peek();
        }
        ST.pop();
    }
    public int getMin() {
        ST.forEach(item -> System.out.print(item + " "));
        System.out.println(" min = " + min);
        return min;
    }
}
