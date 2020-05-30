package Grokking_java_interview.Coding;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class subset {
    public static void main(String[] args) {
        //List<List<Integer>> result = subset.findPermutations(new int[] { 1, 3, 5 });
        String str = "ad52";
        List<String>result = new ArrayList<>();
        findLetterCaseStringPermutationsUtils(str, 0, result);
        System.out.print("Here are all the permutations: " + result);
    }
    public static List<List<Integer>> findPermutationsRec(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // TODO: Write your code here
        recursiveUtils(nums, 0, result);
        result.forEach(item -> System.out.println(item));
        return result;
    }
    public static void recursiveUtils(int[] nums, int index, List<List<Integer>> result)
    {
        if(index == nums.length) {
            //https://www.java67.com/2019/03/how-to-convert-int-array-to-arraylist-in-java-8-example.html
            result.add(IntStream.of(nums).boxed().collect(Collectors.toCollection(ArrayList::new)));
            return;
        }
        for(int i = index; i < nums.length; i++)
        {
            swap(nums, i, index);
            recursiveUtils(nums, index+1, result);
            swap(nums, i, index);
        }
    }
    public static void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static String swapStr(String str, int i, int j)
    {
        char[] arr = str.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return String.valueOf(arr);
    }
    public static String getModifyString(String str, int i)
    {

        final int diff = Math.abs('a' - 'A');
        char[] arr = str.toCharArray();
        if(Character.isLowerCase(arr[i]))
            arr[i] = Character.toUpperCase(arr[i]);
        return String.valueOf(arr);
    }
    public static void findLetterCaseStringPermutationsUtils(String str, int index, List<String> result)
    {
        if(index == str.length()) {
            //https://www.java67.com/2019/03/how-to-convert-int-array-to-arraylist-in-java-8-example.html
            result.add(str);
            return;
        }
        String S = str;
        boolean isAssign = false;
        for(int i = index; i < str.length(); i++)
        {
            if(!Character.isDigit(str.charAt(i))) {
                str = getModifyString(str, i);
                isAssign = true;
            }
            else
                i++;
            findLetterCaseStringPermutationsUtils(str, i+1, result);
            if(isAssign) {
                str = S;
                isAssign = false;
            }
        }
    }
    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        // TODO: Write your code here
        findLetterCaseStringPermutationsUtils(str, 0, permutations);
        return permutations;
    }
    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());
        for (int currentNumber : nums) {
            // we will take all existing permutations and add the current number to create new permutations
            int n = permutations.size();
            for (int i = 0; i < n; i++) {
                List<Integer> oldPermutation = permutations.poll();
                // create a new permutation by adding the current number at every position
                for (int j = 0; j <= oldPermutation.size(); j++) {
                    List<Integer> newPermutation = new ArrayList<Integer>(oldPermutation);
                    newPermutation.add(j, currentNumber);
                    if (newPermutation.size() == nums.length)
                        result.add(newPermutation);
                    else
                        permutations.add(newPermutation);
                }
            }
        }
        return result;
    }

}
