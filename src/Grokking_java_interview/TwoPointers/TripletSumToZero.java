package Grokking_java_interview.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {
    /*
    Input: [-3, 0, 1, 2, -1, 1, -2]
    Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
    Explanation: There are four unique triplets whose sum is equal to zero.

    Input: [-5, 2, -1, -2, 3]
    Output: [[-5, 2, 3], [-2, -1, 3]]
    Explanation: There are two unique triplets whose sum is equal to zero.
     */

    public static void main(String[] args) {
        int[] Input = {-3, 0, 1, 2, -1, 1, -2};
        searchTriplets(Input).forEach(System.out::println);
    }
    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(i > 0 && arr[i] == arr[i-1])
                continue;
            searchTripletsUtils(arr, i+1, -arr[i], triplets);
        }
        return triplets;
    }
    public static void searchTripletsUtils(int[] arr, int start, int sum, List<List<Integer>> triplets) {

        int end = arr.length -1;
        while(start < end) {
            int currSum = arr[start] + arr[end];
            if(currSum + sum > 0) {
                end--;
            }
            else if(currSum + sum < 0) {
                start++;
            }
            else {
                triplets.add(Arrays.asList(-sum, arr[start], arr[end]));
                start++;
                end--;
                while(start < end && arr[start] == arr[start-1])
                    start++;
                while(start < end && arr[end] == arr[end-1])
                    end--;

            }
        }
    }
}
