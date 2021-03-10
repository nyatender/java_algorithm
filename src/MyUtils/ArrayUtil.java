package MyUtils;

import java.util.Arrays;
import java.util.*;

public class ArrayUtil {
    public static void main(String[] args) {

    }

    //https://www.techiedelight.com/declare-and-initialize-arrays-in-java/
    void arraysUtils() {
        int[] array = new int[]{45, 61, 71, 72, 73, 0, 1, 21, 33, 37};

        //default value pass
        int[] arr = new int[5];
        Arrays.fill(arr, 1);
        System.out.println(Arrays.toString(arr));    // [1, 1, 1, 1, 1]
    }
}
