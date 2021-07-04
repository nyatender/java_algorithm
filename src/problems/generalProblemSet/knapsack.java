package problems.generalProblemSet;

import java.util.Arrays;

public class knapsack {
    public static void main(String[] args) {
        int[] weight = {1,3,4,5};
        int[] values = {1,4,5,7};
        int total = 7;

        int[] table = new int[total];
        Arrays.fill(table, Integer.MAX_VALUE);
        table[0] = 0;

        int[] indexTable = new int[total];
        Arrays.fill(indexTable, -1);

        for(int i = 0; i < weight.length; i++) {
            for(int j = 0; j < table.length; j++) {
                if(j >= weight[i]) {
                    table[i] = values[i] + Math.min(table[j], table[j - weight[i]]);
                }
            }
        }

    }
}
