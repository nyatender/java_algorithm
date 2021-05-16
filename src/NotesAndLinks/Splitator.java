package NotesAndLinks;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Spliterator;

public class Splitator {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList("One", "two", "three", "four", "six"));

        Spliterator<String> s1 = words.spliterator();
        Spliterator<String> s2 = s1.trySplit();
        Spliterator<String> s3 = s2.trySplit();

        s1.forEachRemaining(System.out::println);
        System.out.println(" traverse in other half of the spliterator ");
        s2.forEachRemaining(System.out::println);
        System.out.println(" Some more splits ");
        s3.forEachRemaining(System.out::println);
    }
}
