package algoexpert.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class pemutations {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1,2,3));
        getPermutations(input).forEach(System.out::println);
    }
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Write your code here.
        List<List<Integer> > result =
                new ArrayList<List<Integer>>();
        if(array.size() == 0)
            return result;
        getPermutationsUtils(array,result, 0);
        return result;
    }
    static void getPermutationsUtils(List<Integer> array, List<List<Integer>> result, int start) {
        if(start == array.size()) {
            result.add(new ArrayList<>(array));
            return;
        }

        for(int i = start; i < array.size(); i++) {
            Collections.swap(array, i, start);
            getPermutationsUtils(array, result, start+1);
            Collections.swap(array, i, start);
        }
    }
}