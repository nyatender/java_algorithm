package test;
import java.io.*;
import java.util.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.Predicate;

public class stringchallenge    {

    static int a;
    static int b;
    stringchallenge() {
        System.out.println("constructor called");
    }
    static {
        a = 10;
        b = 20;
        System.out.println("static bock called");
    }
    public static void main(String[] args) {
//        List<Integer> al = new ArrayList<Integer>();
//        al.add(10);
//        al.add(20);
//        al.add(30);
//        al.add(40);
        List<String> al = new ArrayList<String>();
        al.add("10");
        al.add("20");
        al.add("30");
        al.add("40");

        String[] arr = new String[al.size()];
        arr = al.toArray(arr);

        // Printing array of objects
        for (Object obj : arr)
            System.out.print(obj + " ");
    }
    public static String sc(String text) {

        String answer = "";
        // Enter your code here
        text = text.trim();
        // Store your final result in the variable answer
        answer = text.substring(0,6);
        /* You do not need to worry too much about the return statement for the
        moment and just set the value of “answer” correctly*/
        answer.toUpperCase();
        return answer;
    }
    static public class base {
        base() {

        }
        protected String str = " abc ";

    }
    static class derived extends base {
        public void getValue() {
            String a = super.str;
            String b = this.str;
        }
    }
    static class derived1 extends derived {

    }

    static <T1,T2,T3> void temp(T1 a, T2 b, T3 c) {
        System.out.println(a + " " + b + " " + c);
    }
    static < T extends Comparable <T> > T maximum(T a, T b) {
        if(a.compareTo(b) > 0)
            return a;
        return b;
    }

    static class Test<T>
    {
        T obj;     // An object of type T is declared
        Test() // parameterized constructor
        {
            this.obj = null;
        }
        Test(T obj) // parameterized constructor
        {
            this.obj = obj;
        }
        public T getObject() // get method
        {
            return this.obj;
        }
    }
    static interface IBase {
        static void hiddenMethod() {
            System.out.println("in IBase");
        }
       // void hiddenMethod();
    }
    static interface der1 extends IBase {
//        default void hiddenMethod() {
//            System.out.println("in der1");
//        }
    }
    static interface der2 extends IBase {
//        default void hiddenMethod() {
//            System.out.println("in der2");
//        }
            static void hiddenMethod() {
                System.out.println("in IBase");
            }
    }

    static class der implements der1, der2 {
//        public void hiddenMethod() {
//            System.out.println("in der2");
//        }

    }
    static interface myInterface<T> {
        public <T> T getval(T val);
    }

     <T> List<T> RemoveElementPredicate(List<T> l, Predicate<T> p) {
         // Create an iterator from the l
         Iterator<T> itr = l.iterator();

         // Find and remove all null
         while (itr.hasNext()) {

             // Fetching the next element
             T t = itr.next();

             // Checking for Predicate condition
             if (!p.test(t)) {

                 // If the condition matches,
                 // remove that element
                 itr.remove();
             }
         }
       return l;
    }

    void countWordSentenceAndParagraph() throws IOException {
        File file = new File("D:\\javatestFile.TXT");
        FileInputStream fInput = new FileInputStream(file);
        InputStreamReader inputSR = new InputStreamReader(fInput);
        BufferedReader reader = new BufferedReader(inputSR);

        String inputLine;
        int charCount = 0;
        int wordCount = 0;
        int paraGraphCount = 0;
        int whiteSpaceCount = 0;
        int sentenceCount = 0;
        while((inputLine = reader.readLine()) != null) {
            if(inputLine.equals("")) {
                paraGraphCount++;
                continue;
            }
            charCount = inputLine.length();
            String[] line = inputLine.split("\\s+");
            wordCount += line.length;
            whiteSpaceCount = wordCount - 1;

            String[] sentenceList = inputLine.split("[!+.?:]");
            sentenceCount += sentenceList.length;
        }

    }
}

