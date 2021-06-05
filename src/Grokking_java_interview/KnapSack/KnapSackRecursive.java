package Grokking_java_interview.KnapSack;

public class KnapSackRecursive {

    public int solveKnapsackRecursive(int[] profits, int[] weights, int capacity) {
        // TODO: Write your code here
        return solveKnapsackRecursiveUtils(profits, weights, capacity, 0);
    }
    public int solveKnapsackRecursiveUtils(int[] profits, int[] weights, int capacity, int currIndex) {
        // TODO: Write your code here
        if(capacity <= 0 || currIndex >= weights.length)
            return 0;

        int maxProfit1 = 0;
        if(weights[currIndex] <= capacity) {
            maxProfit1 = profits[currIndex] + solveKnapsackRecursiveUtils(profits, weights,
                    capacity-weights[currIndex], currIndex+1);
        }
        int maxProfit2 = solveKnapsackRecursiveUtils(profits, weights,
                capacity, currIndex+1);

        return Math.max(maxProfit1, maxProfit2);
    }
    public static void main(String[] args) {
        KnapSackRecursive ks = new KnapSackRecursive();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsackRecursive(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsackRecursive(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}