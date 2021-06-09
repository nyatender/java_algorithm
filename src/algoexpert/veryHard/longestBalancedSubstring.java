package algoexpert.veryHard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/*
Longest Balanced Substring
Write a function that takes in a string made up of parentheses ( ( and ) ). The
function should return an integer representing the length of the longest balanced
substring with regards to parentheses.
A string is said to be balanced if it has as many opening parentheses as it has closing
parentheses and if no parenthesis is unmatched. Note that an opening parenthesis
can't match a closing parenthesis that comes before it, and similarly, a closing
parenthesis can't match an opening parenthesis that comes after it.
Sample Input
string = "(()))("
Sample Output
4 // The longest balanced substring is "(())".
 */
public class longestBalancedSubstring {
    public static void main(String[] args) {
        //String input = "(()))(";
        String input = "())()(()())";
        System.out.println(longestBalancedSubstring(input));
    }

    public static int longestBalancedSubstring(String string) {
        Stack<Integer> st = new Stack<>();

        st.push(-1);
        char[] arr = string.toCharArray();
        int i = 0;
        int result = 0;
        while(i < arr.length) {
            if(arr[i] == '(')
                st.push(i);
            else {
                st.pop();
                if(st.isEmpty())
                    st.push(i);
                else {
                    result = Math.max(result, i - st.peek());
                }
            }
            i++;
        }
        return result;
    }
}
