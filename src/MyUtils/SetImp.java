package MyUtils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetImp {

    public static void main(String[] args) {
        addToSet();
    }

    static public void addToSet()
    {
        // Create a new HashSet of String objects
        HashSet<String> setOfStrs1 = new HashSet<>();

        // Adding elements in HashSet
        setOfStrs1.add("hello");
        setOfStrs1.add("abc");
        setOfStrs1.add("time");
        setOfStrs1.add("Hi");

        System.out.println("setOfStrs1 = " + setOfStrs1);

        // Create a new HashSet of String objects
        HashSet<String> setOfStrs2 = new HashSet<>();

        // Adding elements in HashSet
        setOfStrs2.add("this");
        setOfStrs2.add("that");
        setOfStrs2.add("there");

        System.out.println("setOfStrs2 = " + setOfStrs2);

        // Merge Set 2 in Set 1
        boolean bResult = setOfStrs1.addAll(setOfStrs2);

        if(bResult)
        {
            System.out.println("Merging of Set 1 & Set 2 Successfull");
        }

        System.out.println("setOfStrs1 = " + setOfStrs1);
    }
    public static void SetIteration() {
        Set<String> setOfStocks = new HashSet<String>() {
            {
                add("Microsoft");
                add("Amazon");
                add("Adobe");
            }
        };

        //================================================================
        Iterator<String> itr = setOfStocks.iterator();
        // traversing over HashSet System.out.println("Traversing over Set using Iterator");
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        //================================================================

        //================================================================
        setOfStocks.forEach(System.out::println);
        //================================================================

        //java 8 only
        //================================================================
        for (String stock : setOfStocks) {
            System.out.println(stock);
        }
        //================================================================
    }
}
