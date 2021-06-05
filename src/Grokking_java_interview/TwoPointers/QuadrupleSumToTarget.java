package Grokking_java_interview.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of unsorted numbers and a target number, find all unique quadruplets in it, whose sum is equal to the target number.

Example 1:
Input: [4, 1, 2, -1, 1, -3], target=1
Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
Explanation: Both the quadruplets add up to the target.

Input: [2, 0, -1, 1, -2, 2], target=2
Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
Explanation: Both the quadruplets add up to the target.
 */
public class QuadrupleSumToTarget {
    public static void main(String[] args) {
        int[] arr1 = {4, 1, 2, -1, 1, -3}; //-3 -1 1 1 2 4

        searchQuadruplets(arr1, 1).forEach(System.out::println);

        int[] arr2 = {2, 0, -1, 1, -2, 2};
        searchQuadruplets(arr2, 2).forEach(System.out::println);
    }
    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        // TODO: Write your code here
        Arrays.sort(arr);
        for(int i = 0; i < arr.length-3;i++) {
            int val1 = arr[i];
            for(int j = i+1; j < arr.length-2; j++) {
                int left = j+1;
                int right = arr.length-1;
                while(left < right) {
                    int sum = val1 + arr[j] + arr[left] + arr[right];
                    if( sum == target) {
                        quadruplets.add(Arrays.asList(val1, arr[j], arr[left], arr[right]));
                        left++;
                        right--;
                    }
                    else if(sum > target) {
                        right--;
                    }
                    else {
                        left++;
                    }
                }
            }
        }
        return quadruplets;
    }
}
