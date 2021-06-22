package DynamicProgramming;

public class LongestAlternativeSeq {
    public static void main(String[] args) {
        int[] arr = { 1,3,4,5};

        boolean isIncreasing = arr[1] > arr[0];
        LongestAlternativeSeq obj = new LongestAlternativeSeq();
       int res = Math.max(obj.longAltSeq(arr, -1,0, true), obj.longAltSeq(arr, -1,0, false));
        System.out.println(res);
    }

    int longAltSeq(int[] arr, int i, int j, boolean isIncreasing) {
        if(j >= arr.length)
            return 0;

        int c1 = 0;
        if(isIncreasing) {
            if (i == -1 || arr[i] < arr[j]) {
                c1 = 1 + longAltSeq(arr, j, j + 1, !isIncreasing);
            }
        }
        else {
            if (i == -1 || arr[i] > arr[j]) {
                c1 = 1 + longAltSeq(arr, j, j + 1, !isIncreasing);
            }
        }
        int c2 = longAltSeq(arr, i, j + 1, isIncreasing);

        return Math.max(c1, c2);
    }
}
