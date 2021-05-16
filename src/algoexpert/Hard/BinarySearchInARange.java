package algoexpert.Hard;

import java.util.Arrays;

public class BinarySearchInARange {
    public static void main(String[] args) {
        int[] array = {0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71,73};
        int target = 45;

        Arrays.stream(searchForRange(array, target)).forEach(System.out::println);
    }
    public static int[] searchForRange(int[] array, int target) {
        // Write your code here.
        Range range = new Range(-1,-1);
        searchForRangeUtils(array, 0, array.length-1, target, range);
        return new int[]{range.start, range.end};
    }
    public static void searchForRangeUtils(int[] array, int s, int e, int target, Range range) {
        // Write your code here.
        if(s > e)
            return;

        int mid = (s + e)/2;
        if(array[mid] == target)
        {
            if(range.start == -1 && range.end == -1) {
                range.start = mid;
                range.end = mid;
            }	else {
                if(range.start >= mid)
                    range.start = mid;
                if(range.end <= mid)
                    range.end = mid;
            }
        }
        if(target <= array[mid])
            searchForRangeUtils(array, s, mid-1, target, range);
        if(target >= array[mid])
            searchForRangeUtils(array, mid+1, e, target, range);
    }
    static class Range {
        public int start;
        public int end;
        Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}