package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class knapsack {
    public static void main(String[] args) {
        knapsack ks = new knapsack();
        int[] profits = { 15, 50, 60, 90 };
        int[] weights = { 1, 3, 4, 5 };
        //int maxProfit = ks.knapsackUtils(profits, weights, 0, 8);
        int capacity = 8;
        Integer[][] dp = new Integer[weights.length][capacity+1];
        int maxProfit = ks.knapsackUtils2(profits, weights, 0, 8, dp);
        //Integer[] result = ks.getTheItemInAnswer(dp, weights);
//        for(int i = 0; i < result.length; i++)
//            System.out.println(result[i] + " ");
        System.out.println(maxProfit);
    }
//    Integer[] getTheItemInAnswer(Integer[][] dp, int[] weights) {
//        int j = dp.length-1;
//        ArrayList<Integer> res = new ArrayList<>();
//        for(int i = dp.length-1; i > 0;) {
//            if(j >= 1) {
//                if(dp[i][j] == dp[i-1][j]) {
//                    i--;
//                }
//                else {
//                    res.add(weights[i]);
//                    j = j - weights[i];
//                }
//            }
//            else
//                break;
//        }
//        return (Integer[]) res.toArray();
//    }
    int knapsackUtils(int[] profits, int[] weights, int index, int capacity) {
        if(capacity <= 0 || profits.length <= 0 || profits.length != weights.length || index >= weights.length)
            return 0;

        int maxProfit1 = 0;
        if(weights[index] <= capacity)
            maxProfit1 = profits[index] + knapsackUtils(profits, weights, index, capacity - weights[index]);

        int maxProfit2 = knapsackUtils(profits, weights, index+1, capacity);
        return Math.max(maxProfit1, maxProfit2);
    }
    int knapsackUtils2(int[] profits, int[] weights, int index, int capacity, Integer[][]dp) {
        if(capacity <= 0 || profits.length <= 0 || profits.length != weights.length || index >= weights.length)
            return 0;

        if(dp[index][capacity] != null)
            return dp[index][capacity];

        int maxProfit1 = 0;
        if(weights[index] <= capacity)
            maxProfit1 = profits[index] + knapsackUtils(profits, weights, index, capacity - weights[index]);

        int maxProfit2 = knapsackUtils(profits, weights, index+1, capacity);
        dp[index][capacity] = Math.max(maxProfit1, maxProfit2);

        return dp[index][capacity];
    }
}
