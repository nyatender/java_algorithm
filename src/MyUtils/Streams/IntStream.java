package MyUtils.Streams;

import java.util.*;
import java.util.stream.Collectors;

public class IntStream {
    //https://howtodoinjava.com/java8/intstream-examples/#:~:text=Java%20IntStream%20class%20is%20an,implements%20AutoCloseable%20and%20BaseStream%20interfaces.

    public static void main(String[] args) {
        fun2();
    }
    static void fun1() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(23, 3, 2, 16));
        Optional<Integer> v = list.stream().sorted(Collections.reverseOrder()).limit(2).skip(0).findFirst();
    }
    static  void fun2() {
        //o/t = 99 + 1 + 4
        String str1 = "99 ab1caaalti4";

        String[] arr2 = str1.split(" ");
        System.out.println(arr2);
        int v = 0;
        for(String s : arr2) {
            List<Integer> v2 = s.chars().filter(x -> Character.isDigit(x))
                    .mapToObj(x -> Integer.parseInt(String.valueOf(x)))
                    .collect(Collectors.toList());
            v2.forEach(System.out::print);
            System.out.println();
        }
    }
    static void fun3() {
        //o/t = 99 + 1 + 4
        String str = "99 ab1caaalti4";

        String[] arr2 = str.split(" ");
        System.out.println(arr2);
        int v = 0;
        for(String s : arr2) {
            s.chars().filter(x -> Character.isDigit(x))
                    .map(x -> x - '0')
                    .forEach(System.out::println);
                   // .collect(Collectors.toMap());
          //  v2.forEach(System.out::print);
            System.out.println();
        }
    }
}
