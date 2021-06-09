package test;

public class test {


    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        // TODO: Write your code here

        return -1;
    }

    public static void main(String[] args) {
        test ks = new test();
        int[] profits = { 15, 50, 60, 90 };
        int[] weights = { 1, 3, 4, 5 };
        int maxProfit = ks.solveKnapsack(profits, weights, 8);
        System.out.println(maxProfit);
    }

    public static int palindromePartitioningMinCuts(String str) {

        boolean[][] dp =  new boolean[str.length()][str.length()];
        for(int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++)
                dp[i][j] = isPalindrome(str, i, j);
        }

        int[] cuts = new int[str.length()];

        for(int i = 0; i < str.length(); i++) {
            if(dp[0][i]) {
                cuts[i] = 0;
            }
            else {
                cuts[i] = cuts[i-1] + 1;
                for(int j = 1; j < i; j++) {
                    if(dp[j][i] && cuts[j-1] + 1 < cuts[i])
                        cuts[i] = cuts[j-1] + 1;
                }
            }
        }
        return cuts[str.length()-1];
    }
    public static boolean isPalindrome(String str, int i, int j) {
        while(i < j) {
            if(str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public void StringInterleave() {
        String one = "algoexpert";
        String two = "your-dream-job";
        String three = "your-algodream-expertjob";

        System.out.println(interleavingDP(one, two, three));
    }
    public  static boolean interleavingDP(String one, String two, String three) {

        if(one.length() + two.length() != three.length())
            return false;
        boolean[][] dp = new boolean[three.length()][three.length()];
        return interleavingDPUtils(one, two, three, 0, 0 );
    }
    public  static boolean interleavingDPUtils(String one, String two, String three, int i, int j) {
        int k = i + j;

        if(k == three.length())
            return true;

        boolean result = false;
        if(i < one.length() && one.charAt(i) == three.charAt(k)) {
            if(interleavingDPUtils(one, two, three, i+1, j))
                return true;
        }

        if(j < two.length() && two.charAt(j) == three.charAt(k)) {
            return interleavingDPUtils(one, two, three,  i, j+1);
        }

        return false;
    }
}
