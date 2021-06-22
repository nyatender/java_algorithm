package DynamicProgramming;

public class practice {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        // TODO: Write your code here
        if (capacity <= 0)
            return 0;
        Integer[][] dp = new Integer[weights.length][capacity+1];
        return solveKnapsackUtils(profits, weights, capacity, 0, dp);
    }

    public int solveKnapsackUtils(int[] profits, int[] weights, int capacity, int index, Integer[][] dp) {
        // TODO: Write your code here
        if (capacity <= 0 || index >= profits.length)
            return 0;

        if(dp[index][capacity] == null) {
            int sum1 = 0;
            if (weights[index] <= capacity)
                sum1 = profits[index] + solveKnapsackUtils(profits, weights,
                        capacity - weights[index], index + 1, dp);

            int sum2 = solveKnapsackUtils(profits, weights, capacity, index + 1, dp);
            dp[index][capacity] = Math.max(sum1, sum2);
        }

        return dp[index][capacity];
    }
    public int findLPSLength(String st) {
        return LPS(st, 0, st.length() - 1);
    }
    public int LPS(String st, int s, int e) {
        if(s > e)
            return 0;

        if(s == e)
            return 1;

        int maxLength = 1;
        if(st.charAt(s) == st.charAt(e)) {
            int maxLen = LPS(st, s+1, e-1);
            if(maxLen > 1) {
                maxLength += 2;
            }
        }
        else {
            int maxLen = Math.max(LPS(st, s+1, e), LPS(st, s, e-1));
            maxLength = Math.max(maxLength, maxLen);
        }

        return maxLength;
    }
    public static void main(String[] args) {
        practice ks = new practice();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}