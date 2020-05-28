package MyUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListImp {


    //https://howtodoinjava.com/java/collections/arraylist/iterate-through-objects/
    public static void ArrayListTraversal() {
        //==================================================================
        ArrayList<String> arr = new ArrayList<String>() {
            {
                add("02null20");
                add("21212");
            }
        };
        int[] listOfInt = new int[] { 10,20,30};
        ArrayList<Integer> arrInt = new ArrayList<Integer>() {
            {
                add(listOfInt[0]);
                add(listOfInt[1]);
            }
        };
        for (int j = 0; j < arr.size(); j++) {
            char charArray[] = arr.get(j).toCharArray();
            // for (int i = 0; i < charArray.length; i++)
            // System.out.println(arr.get(i));
        }
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i).length());
            for (int j = 0; j < arr.get(i).length(); j++) {
//                if (arr.get(i).charAt(j) == '0')
                System.out.print(arr.get(i).charAt(j));
//                else
//                    System.out.println(arr.get(i));
            }
            System.out.println("");
        }
        //==================================================================

        //==================================================================
        ArrayList<String> namesList = new ArrayList<String>(Arrays.asList( "alex", "brian", "charles") );
        namesList.forEach(name -> System.out.println(name));
        //==================================================================

        //==================================================================
        // initializing ArrayList
        List<Integer> numbers = Arrays.asList(1, 2, 3,
                4, 5, 6, 7, 8);

        // Looping ArrayList using Iterator
        Iterator it = numbers.iterator();
        while (it.hasNext())
            System.out.print(it.next() + " ");
        //==================================================================
    }
}
