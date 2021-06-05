package Grokking_java_interview.TwoPointers;

/*
Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects,
hence, we can’t count 0s, 1s, and 2s to recreate the array.

The flag of the Netherlands consists of three colors: red, white and blue; and since our input array also consists of
three different numbers that is why it is called Dutch National Flag problem.
Input: [1, 0, 2, 1, 0]
Output: [0 0 1 1 2]

Input: [2, 2, 0, 1, 2, 0]
Output: [0 0 1 2 2 2 ]
 */
public class DuchNationalFlagProblem {
    public static void main(String[] args) {
       int[] Input = {0,2,1, 0, 2, 1, 0};
       sort2(Input);
       for(int i = 0; i < Input.length; i++)
           System.out.println(Input[i] + " ");
    }

    static void sort2(int[] arr) {
        int s = 0;
        int end = arr.length-1;
        int i = 0;
        while( i < end) {
            if(arr[i] == 0) {
                Swap(arr, i, s);
                i++;
                s++;
            }
            else if(arr[i] == 1) {
                i++;
            }
            else {
                Swap(arr, i, end);
                end--;
            }
        }
    }

    static void Swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
