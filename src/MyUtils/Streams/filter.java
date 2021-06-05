package MyUtils.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class filter {
    public static void main(String[] args) {

       // (new filter()).filterCustomObjects();
        // (new filter()).ArraysStream();
        (new filter()).StringStream();

    }

    void filterNumbers() {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(12);
        list.add(23);
        list.add(45);
        list.add(6);

        list.stream().filter(num -> num < 10).forEach(System.out::println);

    }

    void filterCustomObjects() {
        //Created a list of Person object.
        List<Person> list = new ArrayList<>();
        list.add(new Person("Dave", 23));
        list.add(new Person("Joe", 18));
        list.add(new Person("Ryan", 54));
        list.add(new Person("Iyan", 5));
        list.add(new Person("Ray", 63));

        list.stream().filter(p -> p.age < 20).forEach(System.out::println);
    }

    void filterChaining() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Dave", 23));
        list.add(new Person("Joe", 18));
        list.add(new Person("Ryan", 54));
        list.add(new Person("Iyan", 5));
        list.add(new Person("Ray", 63));

        list.stream()
                .filter(person -> person.getName() != null ) // Filtering the object where name is not null
                .filter(person -> person.getAge() > 18 ) // Filtering the objects where age is greater than 18
                .filter(person -> person.getAge() < 60) // Filtering the objects where age is less than 60
                .forEach(System.out::println);

    }

    void ArraysStream() {
        String[] arr = {"one", "two", "three", "four"};
        Stream<String> out = Stream.of(arr);
        List<String> result = out.filter(i -> i.length() > 3)
                .filter(i -> !i.startsWith("t"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    void StringStream() {
        String arr = "99 o1n2e3";
        Integer result = Stream.of(arr.split(" "))
                .map(filter::isDigit)
                .mapToInt(x -> Integer.parseInt(x))
                .sum();
        System.out.println(result);
    }

    public static String isDigit(String input) {

        // null or length < 0, return false.
        if (input == null || input.length() < 0)
            return new String("0");

        if(isInteger(input, 10))
            return input;

        int total = 0;
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                total += Character.getNumericValue(c);
            }
        }
        return String.valueOf(total);
    }

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1)
                    return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0)
                return false;
        }
        return true;
    }
}


