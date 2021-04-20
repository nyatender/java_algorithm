package MyUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class MapImp {
    public static void main(String args[]) {
        MapTraversal();
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

        //===============================================================   =
        // using for-each loop for iteration over Map.entrySet()
        for (Map.Entry<String, String> entry : mMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());

        }
        //================================================================

        //================================================================
        // Getting an iterator
        Iterator hmIterator = mMap.entrySet().iterator();
        while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry) hmIterator.next();
            System.out.println(mapElement.getKey() + " : " + mapElement.getValue());
        }
        //================================================================

        //using lamda
        //================================================================
        mMap.forEach((k, v) -> System.out.println((k + ":" + v)));

        String value = mMap.get("GFG");

    }
}
