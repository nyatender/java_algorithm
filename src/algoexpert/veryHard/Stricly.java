package algoexpert.veryHard;

import java.util.Arrays;

public class Stricly {
    public static void main(String[] args) {
        int[] arr = {
                2,6,4,5,7
        };
        System.out.println(function1(arr));
    }

    static boolean function1(int[] arr) {

        int i = 1;
        while(i < arr.length) {
            if(arr[i-1] > arr[i])
                break;
            i++;
        }
        int start = 0;
        if(i >= 2) {
            start = i-2;
        }
        int x = arr[start] + 1;
        if(arr[i-1] - x < arr[i])
            return true;
        else {
            while (arr[i - 1] - x > arr[i]) {
                x++;
            }
        }
        if(arr[i-1] - x < arr[i])
            return true;

        return false;
    }
}
