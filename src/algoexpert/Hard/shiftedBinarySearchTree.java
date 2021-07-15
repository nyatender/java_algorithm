package algoexpert.Hard;

public class shiftedBinarySearchTree {
    public static void main(String[] args) {
        int[] array = new int[]{45, 61, 71, 72, 73, 0, 1, 21, 33, 37};
        //int[] array = new int[]{23, 111, 1, 5};
        int target = 33;
        System.out.println(shiftedBinarySearch(array, target));
    }

    public static int shiftedBinarySearch(int[] array, int target) {
        // Write your code here.
        return shiftedBinarySearchUtils(array, 0, array.length-1, target);
    }

    static int shiftedBinarySearchUtils(int[] array, int start, int end, int target) {
        if(start == end) {
            if (array[start] == target)
                return start;
            else
                return -1;
        }

        int mid = start + (end-start)/2;
        if(array[mid] == target)
            return mid;

        if(array[start] <= array[mid]) {
            if(target >= array[start] && target <= array[mid])
                return shiftedBinarySearchUtils(array, start, mid, target);
            else {
                return shiftedBinarySearchUtils(array, mid+1, end, target);
            }
        }
        else {
            if(target >= array[mid+1] && target <= array[end])
                return shiftedBinarySearchUtils(array, mid+1, end, target);
            else {
                return shiftedBinarySearchUtils(array, start, mid, target);
            }
        }
    }
    static class Range {
        public int start;
        public int end;
        Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    /*
     "array": [0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73],
     "target": 45
     */
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
            }

            if(range.start >= mid)
                range.start = mid;
            if(range.end <= mid)
                range.end = mid;
        }
        if(target <= array[mid-1])
            searchForRangeUtils(array, s, mid-1, target, range);
        if(target >= array[mid])
            searchForRangeUtils(array, mid+1, e, target, range);
    }
}
