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

    /*https://www.educative.io/edpresso/various-string-comparison-methods-in-java?aid=5082902844932096&utm_source=google&utm_medium=cpc&utm_campaign=edpresso-dynamic&gclid=Cj0KCQiAmL-ABhDFARIsAKywVae8aJ4wmOVjbwESs0Yb8E7MhmW8plc2y-m0fbk_f-1WRwisYjJ1hcsaAm5NEALw_wcB
*/
    static void stringBuildInFunctions() {

        //1) equals() and equalsIgnoreCase()
        "Hello".equals("Hello");            //true
        "Hello".equalsIgnoreCase("HELLO");  //true

        //2) regionMatches()
        "Hello World".regionMatches(6, "world", 0, 4);       //false
        "Hello World".regionMatches(true, 6, "world", 0, 4); //true

        //3) startsWith() and endsWith()
        "Hello".startsWith("He"); //true
        "Hello".endsWith("lo");  //true

        //4) equals() vs. ==
        String str1 = "Hello";
        String str2 = new String(str1);
        String str3 = "Hello";
        str1.equals(str2);   //true
        boolean re = (str1 == str2);       //false
                re = (str1 == str3);      //true

        //5) compareTo()
        "Hello".compareTo("Hello");   //0
        "hello".compareTo("Hello");  //32


    }
}
