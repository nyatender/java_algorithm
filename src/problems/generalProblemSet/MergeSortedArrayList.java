package problems.generalProblemSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedArrayList {
    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        // Write your code here.
        ArrayList<Integer> result = new ArrayList<>();

        int[] index = new int[arrays.size()];
        int totalIterations = 0;
        for(List<Integer> arr : arrays) {
            totalIterations += arr.size();
        }
        while(totalIterations-- > 0) {
            int minVal = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int i = 0; i < arrays.size(); i++) {

                if(index[i] >= arrays.get(i).size())
                    continue;

                int currentVal = arrays.get(i).get(index[i]);

                if(minVal > currentVal) {
                    minVal = currentVal;
                    minIndex = i;
                }
            }
            if(minIndex != -1) {
                result.add(minVal);
                index[minIndex]++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1,5,9,12));
        input.add(Arrays.asList(-1, 0));
        input.add(Arrays.asList(-124, 81, 121));
        input.add(Arrays.asList(3,6,12,20,150));

        MergeSortedArrayList.mergeSortedArrays(input).forEach(x -> System.out.print(x + " "));
    }
}