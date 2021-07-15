package algoexpert.Hard;

import java.util.ArrayList;
import java.util.HashMap;

public class maxProfitWithKTransaction {
    public static void main(String[] args) {
        int[] price = {5, 11, 3, 50, 60, 90};
        int k = 2;
        System.out.println(maxProfitWithKTransactions(price, k));
    }

    public static int maxProfitWithKTransactions(int[] prices, int k) {
        // Write your code here.
        if (prices.length == 0) {
            return 0;
        }
        int dp[][] = new int[k+1][prices.length];

//        for (int i = 1; i <= k; i++) {
//            for (int j = 1; j < prices.length; j++){
//                int max_so_far = Integer.MIN_VALUE;
//                for (int m = 0; m < j; m++)
//                    max_so_far = Math.max(max_so_far, prices[j] - prices[m] + dp[i - 1][m]);
//
//                dp[i][j] = Math.max(dp[i] [j - 1], max_so_far);
//            }
//        }
        for (int i = 1; i <= k; i++) {
            int max_so_far = Integer.MIN_VALUE;
            for (int j = 1; j < prices.length; j++) {
                max_so_far = Math.max(max_so_far,dp[i - 1][j-1] - prices[j-1]);
                dp[i][j] = Math.max(dp[i] [j - 1], max_so_far + prices[j]);
            }
        }

        return dp[k][prices.length-1];
    }

}
