package MyUtils;

import java.util.*;

public class ListImp {

    public static void main(String[] args) {
        //Heap lowers = new Heap(Heap::MAX_HEAP_FUNC, new ArrayList<Integer>());
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(5,3,2,8,4,1));
        //ArrayList<ArrayList<Integer>> arr2 = new ArrayList<ArrayList<Integer>>(Arrays.asList(5,3,2,8,4,1));

        arr1.sort((a1, b1) -> a1.compareTo(b1));
        arr1.forEach(item -> System.out.print(item + " "));
        System.out.println("");
    }
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

        //Initialize ArrayList
        ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(0, Integer.MAX_VALUE, Integer.MIN_VALUE));
    }
}
