package algoexpert.veryHard;

/*
Max Profit With K Transactions
You're given an array of positive integers representing the prices of a single stock on
various days (each index in the array represents a different day). You're also given an
integer k , which represents the number of transactions you're allowed to make. One
transaction consists of buying the stock on a given day and selling it on another, later
day.
Write a function that returns the maximum profit that you can make by buying and
selling the stock, given k transactions.
Note that you can only hold one share of the stock at a time; in other words, you can't
buy more than one share of the stock on any given day, and you can't buy a share of
the stock if you're still holding another share. Also, you don't need to use all k
transactions that you're allowed.
Sample Input
prices = [5, 11, 3, 50, 60, 90]
k = 2
Sample Output
93 // Buy: 5, Sell: 11; Buy: 3, Sell: 90
 */
public class MaxProfitWithKTransactions {
    public static void main(String[] args) {
        int[] prices = {5,11,3,50,60,90};
        int k = 2;
        System.out.println(maxProfitWithKTransactions(prices, k));
    }
    public static int maxProfitWithKTransactions(int[] prices, int noOfTransactions) {
        // Write your code here.
        if(prices.length == 0)
            return 0;
        int Row = noOfTransactions+1;
        int Col = prices.length;
        int[][] dp = new int[Row][Col];

//        for(int k = 1; k < Row; k++) {
//            for(int d = 1; d < Col; d++) {
//                int maxProfit = Integer.MIN_VALUE;
//                for(int m = 0; m < d; m++) {
//                    maxProfit = Math.max(maxProfit,  dp[k - 1][m] + prices[d] - prices[m]);
//                }
//                dp[k][d] = Math.max(dp[k][d - 1], maxProfit);
//            }
//        }
        for(int k = 1; k < Row; k++) {
            int maxProfit = Integer.MIN_VALUE;
            for(int d = 1; d < Col; d++) {
                maxProfit = Math.max(maxProfit, dp[k - 1][d-1] - prices[d-1]);
                dp[k][d] = Math.max(dp[k][d - 1], maxProfit + prices[d]);
            }
        }

        return dp[Row-1][Col-1];
    }
}
