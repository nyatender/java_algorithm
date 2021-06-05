package algoexpert.Medium;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// All test case passed

/*
Powerset
Write a function that takes in an array of unique integers and returns its powerset.
The powerset P(X) of a set X is the set of all subsets of X . For example, the powerset of
[1,2] is [[], [1], [2], [1,2]] .
Note that the sets in the powerset do not need to be in any particular order.
input : array = [1, 2, 3]
output : [[], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]]
 */
public class powerSet {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1,2,3));

        powerset(input).forEach(i -> System.out.println(i));
    }
    public static List<List<Integer>> powerset(List<Integer> array) {
        List<List<Integer>> result =  new ArrayList<>();
         powersetUtils(result, array, array.size()-1);

         // Arrange according to required sequence
         Collections.sort(result, (i, j) -> i.size() - j.size());
         return result;
    }
    public static void powersetUtils(List<List<Integer>> result, List<Integer> array, int start) {
        if(start < 0) {
            result.add(new ArrayList<>());
            return;
        }
        powersetUtils(result, array, start-1);
        int len = result.size();
        for(int i = 0; i < len; i++) {
            List<Integer> item = new ArrayList<>(result.get(i));
            item.add(array.get(start));
            result.add(item);
        }
    }


}
