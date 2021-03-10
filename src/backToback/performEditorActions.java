package backToback;

import java.util.Stack;

public class performEditorActions {
    public static void main(String[] args) {

    }


    static String performEditorAction(String[][] actions) {
       // Stack<Character> undo = new Stack<>();
        Stack<Character> redo = new Stack<>();
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < actions.length; i++) {
            if(actions[i][0].compareTo("INSERT") == 0) {
                str.append(actions[i][1]);
            }
            else if(actions[i][0].compareTo("DELETE") == 0) {
                if(str.length() != 0) {
                    redo.push(str.charAt(str.length() - 1));
                    str.deleteCharAt(str.length() - 1);
                }
            }
            else if(actions[i][0].compareTo("UNDO") == 0) {
                if(str.length() != 0) {
                    redo.push(str.charAt(str.length() - 1));
                    str.deleteCharAt(str.length() - 1);
                }
            }
            else if(actions[i][0].compareTo("REDO") == 0) {
                if(!redo.empty()) {
                    char ch = redo.peek();
                    str.append(ch);
                    redo.pop();
                }
            }
        }
        return str.toString();
    }
}
