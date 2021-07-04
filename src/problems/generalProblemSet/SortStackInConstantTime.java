package problems.generalProblemSet;

import java.util.Stack;

public class SortStackInConstantTime {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(6);
        st.push(19);
        st.push(5);
        st.push(1);
        System.out.println("Before sort");
        st.forEach(i -> System.out.print(i + " "));
        sortSatck(st);
        System.out.println("\nAfter sort");
        st.forEach(i -> System.out.print(i + " "));
    }
    static void sortSatck(Stack<Integer> st) {
        Stack<Integer> tempStack = new Stack<>();
        while(!st.empty()) {
            int element = st.pop();
            while(!tempStack.empty() && tempStack.peek() < element) {
                st.push(tempStack.pop());
            }
            tempStack.push(element);
        }
        while(!tempStack.empty()) {
            st.push(tempStack.pop());
        }
    }
}
