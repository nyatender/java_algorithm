package backToback;

import java.util.Stack;

public class balance_parentheses {
    public static void main(String[] args) {

    }
    public boolean isValid(String s) {
        Stack<Character>st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                st.push(s.charAt(i));
            else if(!st.empty() &&
                    ((st.peek() == '(' && s.charAt(i) == ')') ||
                     (st.peek() == '{' && s.charAt(i) == '}') ||
                     (st.peek() == '[' && s.charAt(i) == ']'))) {
                st.pop();
            } else {
                return false;
            }
        }
        if(st.empty())
            return true;
        return false;
    }
}
