package MyUtils;

import java.util.EmptyStackException;
import java.util.Stack;

//https://www.geeksforgeeks.org/stack-class-in-java/
//https://www.tutorialspoint.com/java/java_stack_class.htm
public class StackImp {

    static void showpush(Stack st, int a) {
        st.push(a);
        System.out.println("push(" + a + ")");
        System.out.println("stack: " + st);
    }

    static void showpop(Stack st) {
        System.out.print("pop -> ");
        Integer a = (Integer) st.pop();
        System.out.println(a);
        System.out.println("stack: " + st);
    }

    public static void main(String args[]) {
        Stack st = new Stack();
        System.out.println("stack: " + st);
        showpush(st, 42);
        showpush(st, 66);
        showpush(st, 99);
        showpop(st);
        showpop(st);
        showpop(st);
        try {
            showpop(st);
        } catch (EmptyStackException e) {
            System.out.println("empty stack");
        }
    }

    //https://www.geeksforgeeks.org/stack-class-in-java/
    public static void StackInJava() {
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.print(i + "");
        }
        System.out.println("");
        System.out.println("Pop :");
        for (int i = 0; i < 5; i++) {
            Integer y = (Integer) stack.pop();
            System.out.print(y);
        }
        System.out.println("");
        stack.push(1);

        Integer element = (Integer) stack.peek();
        System.out.println("Element on stack top : " + element);

        Integer pos = (Integer) stack.search(element);

        if (pos == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element is found at position " + pos);
    }

}
