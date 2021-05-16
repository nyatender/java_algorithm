package MyUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringOprations {
    public static void main(String args[]) {
        StringOperation();
        String str = "abcd";
        int len = str.length();
        char ch = str.charAt(0);
        getSubStringsFromString();
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

        //Convert char to string
        List<String> list = new ArrayList<>();
        char ch = 'c';
        list.add(String.valueOf(ch));
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

    public static void getSubStringsFromString() {
        ArrayList<String> input = new ArrayList<>() {
            {
                add("abcdef");
                add("abcde");
                add("1abde");
                add("abd");
                add("abc");
                add("ade");
                add("ae");
            }
        };

        String a;
        String b;
        for(String str : input) {
            for(int i = 0; i < str.length(); i++) {
                a = str.substring(0, i);
                b = str.substring(i+1);
                //str = str.substring(0, i) + str.substring(i + 1, str.length());
                System.out.println(a+b);
            }
        }
    }

    public void StringBuilderOperations() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1;
        Character ch;

        //Character.isSpaceChar()
        int[] arr = new int[10];
        Arrays.sort(arr);
        String val = "123";
        Integer.valueOf(val);
        int x = 10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(val);
        Integer.toString(x).length();
    }
}
