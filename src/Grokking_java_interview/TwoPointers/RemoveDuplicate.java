package Grokking_java_interview.TwoPointers;

public class RemoveDuplicate {
    /*
    Input: [2, 3, 3, 3, 6, 9, 9]
    Output: 4
    Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].

    Input: [2, 2, 2, 11]
    Output: 2
    Explanation: The first two elements after removing the duplicates will be [2, 11].
     */

    public static void main(String[] args) {
        int[] Input = {2, 3, 3, 3, 6, 9, 9};
        System.out.println(removeInSortedArray(Input));
    }
    public static int removeInSortedArray(int[] Input) {
        // TODO: Write your code here

        int duplicate = 1;
        for(int i = 1; i < Input.length; i++) {
            if(Input[duplicate-1] != Input[i]) {
                Input[duplicate] = Input[i];
                duplicate++;
            }
        }

        return duplicate;
    }
    /*
    Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3
    Output: 4
    Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].
     */
    public static int removeInUnsortedArray(int[] Input, int key) {
        // TODO: Write your code here

        int duplicate = 0;
        for(int i = 0; i < Input.length; i++) {
            if(Input[i] != key) {
                Input[duplicate] = Input[i];
                duplicate++;
            }
        }

        return duplicate;
    }
}
