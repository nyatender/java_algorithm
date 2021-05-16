package MyUtils.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//https://www.educative.io/courses/java-8-lambdas-stream-api-beyond/RL8y1y772wY
public class map {
    public static void main(String[] args) {

    }

    void _map() {
        List<String> list = new ArrayList<>();
        list.add("Dave");
        list.add("Joe");
        list.add("Ryan");
        list.add("Iyan");
        list.add("Ray");
        // map() is used to convert each name to upper case.
        // Note: The map() method does not modify the original list.
        list.stream()
                .map(name -> name.toUpperCase()) //map() takes an input of Function<T, R> type.
                .forEach(System.out::println);   // forEach() takes an input of Consumer type.
    }

    void _mapToInt() {
        List<String> list = new ArrayList<>();
        list.add("Dave");
        list.add("Joe");
        list.add("Ryan");
        list.add("Iyan");
        list.add("Ray");

        list.stream()
                .mapToInt(name -> name.length())   //return stream of primitive types IntStream
                .forEach(System.out::println);
    }

    void _flatMap() {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("a","b","c"));
        list.add(Arrays.asList("d","e","f"));
        list.add(Arrays.asList("g","h","i"));
        list.add(Arrays.asList("j","k","l"));

        Stream<List<String>> stream1 = list.stream();

        // filter() method do not work on stream of collections
        Stream<List<String>> stream2 = stream1.filter(x -> "a".equals(x.toString()));

        //This will not print anything
        stream2.forEach(System.out::println);
    }
}
