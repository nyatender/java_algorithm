package MyUtils;

import java.util.regex.Pattern;

public class StringOprations {
    public static void main(String args[]) {
        StringOperation();
    }

    //https://www.geeksforgeeks.org/split-string-java-examples/
    static void StringOperation() {
        String str = "Welcome to geeksforgeeks";
        // Specifying the pattern to be searched
        Pattern pattern = Pattern.compile("\\s");

        // splitting String str with a pattern
        // (i.e )splitting the string whenever their
        //  is whitespace and store in temp array.
        String[] temp = pattern.split(str);
        //pattern.intern
        String result = "";
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i].contains("x") == true);
        }

        String str1 = "geekss@for@geekss";
        String[] arrOfStr = str1.split("@", 3);

        for (String a : arrOfStr)
            System.out.println(a);
    }
}
