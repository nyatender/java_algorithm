package algoexpert.veryHard;

import java.util.Arrays;

/*
 * Partitioning the string into palindromes.
         *
         * https://leetcode.com/problems/palindrome-partitioning/
         * https://leetcode.com/problems/palindrome-partitioning-ii/
 */
public class miniNumberOfPalimdromicPartitions {
    public static int palindromePartitioningMinCuts(String str) {
        // Write your code here.
        boolean[][] table = new boolean[str.length()][str.length()];

        for(int i = 0; i < str.length(); i++) {
            for(int j = i; j < str.length(); j++) {
                table[i][j] = isPalindrome(str, i, j);
            }
        }
        int[] cuts = new int[str.length()];
        Arrays.fill(cuts, Integer.MAX_VALUE);
        for(int i = 0; i < str.length(); i++) {
            if(table[0][i]) {
                cuts[i] = 0;
            }
            else {
                cuts[i] = cuts[i-1] + 1;
                for(int j = 1; j < i; j++) {
                    if(table[j][i] && cuts[j-1] + 1 < cuts[i])
                        cuts[i] = cuts[j-1] + 1;
                }
            }
        }

        return cuts[str.length()-1];
    }
    static boolean isPalindrome(String str, int s, int e) {
        if(s >= e)
            return true;

        if(str.charAt(s) == str.charAt(e))
            return isPalindrome(str, s+1, e-1);

        return false;
    }
}
