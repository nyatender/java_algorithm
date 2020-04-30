package MyUtils;
import javafx.util.Pair;
import java.util.*;
import java.util.regex.Pattern;

//https://www.geeksforgeeks.org/pair-class-in-java/
//https://www.geeksforgeeks.org/iterating-arraylists-java/
//https://howtodoinjava.com/java/collections/arraylist/iterate-through-objects/
//https://howtodoinjava.com/java/collections/arraylist/initialize-arraylist/
//https://www.geeksforgeeks.org/hashmap-containsvalue-method-in-java/

public class Utils {
    public static void main(String args[]) {
        StringOperation();
        // StackInJava();
        // MapTraversal();
        // ArrayListTraversal ();
        // PairInJava();
    }

    public static void PairInJava() {
        //==================================================================

        Pair p1 = new Pair(3, 4);
        Pair p2 = new Pair(3, 4);
        Pair p3 = new Pair(4, 4);

        System.out.println(p1.equals(p2) + " " + p2.equals(p3));
        //==================================================================

        //==================================================================
        ArrayList<Pair<String, Integer>> ArrOfPairs = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        // Pair to store the maximum marks of a
        // student with its name
        Pair<String, Integer> ans = new Pair<String, Integer>("", 0);

        // Using for each loop to iterate array of
        // Pair Objects
        for (Pair<String, Integer> temp : ArrOfPairs) {
            // Get the score of Student
            int val = temp.getValue();

            // Check if it is greater than the previous
            // maximum marks
            if (val > max) {
                max = val;  // update maximum
                ans = temp; // update the Pair
            }
        }
        //==================================================================
    }

    public static void MapTraversal() {
        Map<String, String> mMap = new HashMap<String, String>();

        // enter name/url pair
        mMap.put("GFG", "geeksforgeeks.org");
        mMap.put("Practice", "practice.geeksforgeeks.org");
        mMap.put("Code", "code.geeksforgeeks.org");
        mMap.put("Quiz", "quiz.geeksforgeeks.org");

        //================================================================
        Boolean hasKey = mMap.containsKey("Code");
        System.out.println(hasKey);

        Boolean hasVal = mMap.containsValue("geeksforgeeks.org");
        System.out.println(hasVal);
        //================================================================

        //================================================================
        // using for-each loop for iteration over Map.entrySet()
        for (Map.Entry<String, String> entry : mMap.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
        //================================================================

        //================================================================
        // Getting an iterator
        Iterator hmIterator = mMap.entrySet().iterator();
        while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry) hmIterator.next();
            System.out.println(mapElement.getKey() + " : " + mapElement.getValue());
        }
        //================================================================
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

    //https://howtodoinjava.com/java/collections/arraylist/iterate-through-objects/
    public static void ArrayListTraversal() {
        //==================================================================
        ArrayList<String> arr = new ArrayList<String>() {
            {
                add("02null20");
                add("21212");
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

    //https://www.geeksforgeeks.org/stack-class-in-java/
    public static void StackInJava() {
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.print(i + "");
        }
        System.out.println("");
        System.out.println("Pop :");
        for (int i = 0; i < 5; i++) {
            Integer y = (Integer) stack.pop();
            System.out.print(y);
        }
        System.out.println("");
        stack.push(1);

        Integer element = (Integer) stack.peek();
        System.out.println("Element on stack top : " + element);

        Integer pos = (Integer) stack.search(element);

        if (pos == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element is found at position " + pos);
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
        String result = "";
        for (int i = 0; i < temp.length; i++) {
           // System.out.println(temp[i]);
        }

        String str1 = "geekss@for@geekss";
        String[] arrOfStr = str1.split("@", 3);

        for (String a : arrOfStr)
            System.out.println(a);
    }
}


