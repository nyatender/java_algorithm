package MyUtils.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

public class IntStream {
    //https://howtodoinjava.com/java8/intstream-examples/#:~:text=Java%20IntStream%20class%20is%20an,implements%20AutoCloseable%20and%20BaseStream%20interfaces.

    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(23, 3, 2, 16));
    Optional<Integer> v = list.stream().sorted(Collections.reverseOrder()).limit(2).skip(0).findFirst();
}
