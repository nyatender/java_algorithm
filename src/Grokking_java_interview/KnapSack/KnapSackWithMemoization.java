package Grokking_java_interview.KnapSack;

import java.util.Arrays;

public class KnapSackWithMemoization {

    public int solveKnapsackRecursive(int[] profits, int[] weights, int capacity) {
        // TODO: Write your code here
        Integer[][] dp = new Integer[profits.length][capacity+1];
        return solveKnapsackRecursiveUtils(profits, weights, capacity,dp, 0);
    }
    public int solveKnapsackRecursiveUtils(int[] profits, int[] weights, int capacity,
                                           Integer[][] dp,
                                           int currIndex ) {
        // TODO: Write your code here
        if(capacity <= 0 || currIndex >= weights.length)
            return 0;

        if(dp[currIndex][capacity] != null)
            return dp[currIndex][capacity];

        int maxProfit1 = 0;
        if(weights[currIndex] <= capacity) {
            maxProfit1 = profits[currIndex] + solveKnapsackRecursiveUtils(profits, weights,
                    capacity-weights[currIndex], dp, currIndex+1);
        }
        int maxProfit2 = solveKnapsackRecursiveUtils(profits, weights,
                capacity, dp, currIndex+1);

        dp[currIndex][capacity] = Math.max(maxProfit1, maxProfit2);
        return dp[currIndex][capacity];
    }
    public static void main(String[] args) {
        KnapSackWithMemoization ks = new KnapSackWithMemoization();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsackRecursive(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsackRecursive(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}