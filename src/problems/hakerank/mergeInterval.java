package problems.hakerank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//www.geeksforgeeks.org/check-whether-an-array-can-be-made-strictly-increasing-by-modifying-atmost-one-element/
//www.geeksforgeeks.org/queries-count-point-lie-inside-circle/

public class mergeInterval {
    public static void main(String[] args) {
        ArrayList<List<java.lang.Integer>> input = new ArrayList<List<java.lang.Integer>>();
        input.add(Arrays.asList(1, 3, 10));
        input.add(Arrays.asList(2, 5, 15));
        input.add(Arrays.asList(5, 7, 6));

        System.out.println(mergeIntervals(input));
    }

    public static Integer mergeIntervals(List<List<Integer>> input) {
        List<Integer> mergedInvls = new ArrayList<>();
        for (int i = 1; i < input.size(); i++) {
            for (int j = 0; j < i; j++)
                mergedInvls.add(mergeCalendars(input.get(j), input.get(i)));
        }
        Collections.sort(mergedInvls, Collections.reverseOrder());
        return mergedInvls.get(0);
    }

    public static Integer mergeCalendars(List<Integer> first, List<Integer> second) {
        int sum = 0;
        if (first.get(1) < second.get(0)) {
            sum = first.get(2) + second.get(2);
        }
        return sum;
    }
}

