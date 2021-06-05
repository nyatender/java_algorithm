package DynamicProgramming;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class longestIncreasingSubSequence {
    public static void main(String[] args) {
        //int[] input = {3,4,-1,0,6,2,3};
        int[] input = {2,5,1,8,3};
        System.out.println(findTheLongestSequence(input));
    }
    static int findTheLongestSequence(int[] input) {
        int length = input.length;
        int[] output = new int[length];
        Arrays.fill(output, 1);

        int actualSolution[] = new int[input.length];
        for(int i=0; i < input.length; i++){
            actualSolution[i] = i;
        }
        for(int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if(input[i] > input[j]) {
                    if (input[j] + 1 > input[i]) {
                        output[i] = output[j] + 1;
                        actualSolution[i] = j;
                    }
                }
            }
        }
        int val = -1;
        for(int i = 0; i < output.length; i++) {
            val = Math.max(val, output[i]);
        }
       // Arrays.sort((Integer[])output, Collections.reverseOrder());
       // return Arrays.stream(output).sorted(Collections.reverseOrder()).limit(1).findFirst().getAsInt();
        //return output[length-1];
        return  val;
    }
}
