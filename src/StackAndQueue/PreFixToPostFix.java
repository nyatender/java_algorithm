package StackAndQueue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class PreFixToPostFix {
    static Boolean isOperator(char ch)
    {
        if( ch == '*' || ch == '/' || ch == '+' || ch == '-')
            return true;

        return false;
    }

    //https://www.geeksforgeeks.org/prefix-postfix-conversion/
    static ArrayList<String> preFixToPostFix(ArrayList<String> exp)
    {
        Stack<String> St = new Stack<String>();
        ArrayList<String> result = new ArrayList<String>();
        Iterator it = exp.iterator();
        while(it.hasNext())
        {
            String expVal = (String)it.next();
            for(int i = expVal.length()-1; i >= 0; i--)
            {
                char ch = expVal.charAt(i);
                if(!isOperator(ch))
                {
                    St.push(String.valueOf(ch));
                }
                else
                {
                    String val1 = St.peek();
                    St.pop();
                    String val2 = St.peek();
                    St.pop();
                    String val3 = val1 + val2 + val2.concat(String.valueOf(ch));
                    St.push(val3);
                }
                System.out.println();
            }
            result.add(St.pop());
        }
        return result;
    }
    public static void main(String args[])
    {
        ArrayList<String> str1 = new ArrayList<String>() {
            {
                add("*+AB-CD");
                add("*-A/BC-/AKL");
            }};
        ArrayList<String> out = preFixToPostFix(str1);
        Iterator it = out.iterator();
        while(it.hasNext())
            System.out.println(it.next());
    }
}
