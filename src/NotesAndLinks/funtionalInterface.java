package NotesAndLinks;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.Date;

// https://www.educative.io/courses/java-8-lambdas-stream-api-beyond/mEKVvqrRwqO
public class funtionalInterface {
    public static void main(String[] args) {

      //  predicates();
        functions();
        //consumers();
       // suppliers();
    }

    public static void predicates() {

        //takes one input and return the boolean value
        Predicate<String> checkLenght = s -> s.length() >= 3;
        Predicate<String> checkEvenLength = s -> s.length()%2 == 0;

        //joining predicates
        System.out.println("predicates : " + checkEvenLength.and(checkLenght).test("yatender"));

        System.out.println("predicates : " + checkEvenLength.or(checkLenght).test("yatender"));

        System.out.println("predicates : " + checkEvenLength.negate().test("yatender"));

        System.out.println("predicates : " + Predicate.isEqual("yatender").test("yatender"));

    }

    public static void functions() {

        Function<Integer, Integer> doubles = a -> a = a*2;
        Function<Integer, Integer> cube = a -> a = a*a*a;

        System.out.println("functions : " + doubles.apply(2));

        //Functional chaining
        // double and then call cube on it
        System.out.println("functions : " + doubles.andThen(cube).apply(2));

        //first cube and then double. compose reverse operation of andThen
        System.out.println("functions : " + doubles.compose(cube).apply(2));
    }

    public static void consumers() {

        //accepting input type only no return type
        Consumer<Integer> doubles = a -> System.out.println("consumers : " + a*2);
        Consumer<Integer> squares = a -> System.out.println("consumers : " + a*a);

        doubles.andThen(squares).accept(3);

        //compose doesn't exist in consumer
        //doubles.compose(squares).accept(3);
    }

    public static void suppliers() {

        //accepting return type only, no input type
        Supplier<Date> doubles = () -> new Date();

        System.out.println(" suppliers " + doubles.get());

        //compose doesn't exist in consumer
        //doubles.compose(squares).accept(3);

        //chaining is not possible in supplier functional interface
    }
}


