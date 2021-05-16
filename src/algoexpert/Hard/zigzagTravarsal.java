package algoexpert.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class zigzagTravarsal {
    public static void main(String[] args) {
       ArrayList<List<Integer>> array = new ArrayList<>();
        array.add(Arrays.asList(1, 3, 4, 10));
        array.add(Arrays.asList(2, 5, 9, 11));
        array.add(Arrays.asList(6, 8, 12, 15));
        array.add(Arrays.asList(7, 13, 14, 16));

        zigzagTraverse(array);
       //Output : 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
    }

    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        // Write your code here.

        return new ArrayList<>();
    }
}
