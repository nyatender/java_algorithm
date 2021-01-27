package MyUtils;
import javafx.util.Pair;
import java.util.*;
import java.util.regex.Pattern;

//https://www.geeksforgeeks.org/pair-class-in-java/
//https://www.geeksforgeeks.org/iterating-arraylists-java/
//https://howtodoinjava.com/java/collections/arraylist/iterate-through-objects/
//https://howtodoinjava.com/java/collections/arraylist/initialize-arraylist/
//https://www.geeksforgeeks.org/hashmap-containsvalue-method-in-java/
//https://www.tutorialspoint.com/how-can-we-initialize-a-boolean-array-in-java
public class Utils {
    static public void main(String[] args)
    {
        int size = 10;
       // int[][] wrong = new int[][]; // not OK, you must specify 1st dimension
       //int[][] right = new int[size][]; // OK
        //Utils obj = new Utils();
       // obj.isDigit();
        isDigit();
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

