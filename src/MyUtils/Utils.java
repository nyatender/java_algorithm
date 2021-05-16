package MyUtils;

import java.util.*;
import java.util.concurrent.locks.StampedLock;
import java.util.regex.Pattern;
import java.util.stream.Stream;

//https://www.geeksforgeeks.org/pair-class-in-java/
//https://www.geeksforgeeks.org/iterating-arraylists-java/
//https://howtodoinjava.com/java/collections/arraylist/iterate-through-objects/
//https://howtodoinjava.com/java/collections/arraylist/initialize-arraylist/
//https://www.geeksforgeeks.org/hashmap-containsvalue-method-in-java/
//https://www.tutorialspoint.com/how-can-we-initialize-a-boolean-array-in-java
public class Utils {
    static StampedLock lock = new StampedLock();
    static public void main(String[] args)
    {
        int size = 10;
       ArrayList<Integer> list = new ArrayList<>(Arrays.asList(100,12,15,45));
       Optional<Integer> res = list.stream()
                                   .sorted(Collections.reverseOrder())
                                    .limit(2).skip(1).findFirst();
        Stream.of(1,2,3,4,5,6,7)
                .parallel()
                .forEach(num -> System.out.println(num + " " + Thread.currentThread().getName()));
      // list.parallel.forEach(System.out::println);
//       if(res.isPresent())
//           System.out.println(res.get());

       Map<Integer, Integer> mMap = new HashMap<>();
       mMap.put(1,10);
       mMap.put(2,20);
       mMap.put(3,30);
       mMap.put(4,40);

       for(Map.Entry<Integer, Integer> entry : mMap.entrySet()) {

       }
       Integer res1 = 0;
       mMap.forEach( (k, v) -> {
           int val = 0;
           if(k > 2)
             val = res1;
       });

        String str = "babc";
//        for(char ch : str.toCharArray())
//            System.out.println(ch);
        for(int i = 0; i <= str.length(); i++) {
            System.out.println(str.substring(i,str.length()));
        }

    }
    public static void isDigit()
    {
        String str = "abc123";
        for(int i = 0; i < str.length(); i++)
            if(Character.isDigit(str.charAt(i)))
                System.out.println(str.charAt(i));
    }
}

class myclass {
    myclass() {
        Utils obj = new Utils();
        obj.isDigit();
    }
}

