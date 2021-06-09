package test;

//https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
public class minimumCuts {
    public static void main(String[] args) {
        int n = 7;
        int[] cuts = {1,3,4,5};

        int start = 0;
        int end = cuts.length - 1;
        int[][] dp = new int[n][n];

        int result = Integer.MIN_VALUE;
        for(int i = 0; i < cuts.length-1; i++){
            if(cuts[i] > start && cuts[i] < end){
                int val = (end - start) + cal(start, cuts[i], cuts, dp) + cal(cuts[i],end , cuts, dp);
                result = Math.min(val, result);
            }
        }
        System.out.println(result);
    }
    public static int cal(int start, int end, int[]cuts, int[][]dp){
        if(dp[start][end]!= -1){//Some initializations need to be done
            return dp[start][end];
        }
        int result = 1000000;
        for(int i = 0; i < cuts.length; i++){
            if(cuts[i]> start && cuts[i]<end){
                int val = (end - start + 1) + cal(start, cuts[i], cuts, dp) + cal(cuts[i],end , cuts, dp);
                result = Math.min(val, result);
            }
        }
        return dp[start][end] = result;
    }

}
