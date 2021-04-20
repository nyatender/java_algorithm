package algoexpert.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class getPermutations {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3};
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
       // System.out.println(getPermutations(list));

        String str = "ABC";
        System.out.println(str.length());
        System.out.println(getStrPermutations(str));
    }
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Write your code here.
        List<List<Integer> > result =
                new ArrayList<List<Integer>>();
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

    public static List<String> getStrPermutations(String array) {
        // Write your code here.
        List<String> result = new ArrayList<String>();
        getStrPermutationsUtils(array, result, 0);
        return result;
    }
    static void getStrPermutationsUtils(String array, List<String> result, int start) {
        if(start == array.length()) {
            result.add(new String(array));
            return;
        }

        for(int i = start; i < array.length(); i++) {
            array = swap(array, i, start);
            getStrPermutationsUtils(array, result, start+1);
            array = swap(array, i, start);
        }
    }

    static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;

        return String.valueOf(charArray);
    }
}

