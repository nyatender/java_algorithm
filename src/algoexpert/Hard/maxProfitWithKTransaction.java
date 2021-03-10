package algoexpert.Hard;

import java.util.ArrayList;
import java.util.HashMap;

public class maxProfitWithKTransaction {
    public static void main(String[] args) {
//        String big = "a$fuu+afff+affaffa+a$Affab+a+a+$a$";
//        String small = "a+$aaAaaaa$++";
//        //"affa+a$Affab+a+a+$a
//        //String output = "f$axb$";
//        System.out.println(findStringinAnother(big, small));
        String str = "abc";
        boolean[][] cuts = new boolean[str.length()][str.length()];
        for(int i = 0; i < cuts[0].length; i++) {
            for (int j = 0; j < cuts.length; j++) {
                System.out.print(cuts[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int maxProfitWithKTransactions(int[] prices, int k) {
        // Write your code here.
        int dp[][] = new int[k+1][prices.length];

        for(int i = 1; i < prices.length; i++) {
            for(int j = 1; j <= k; j++) {
                int maxProfit = Integer.MIN_VALUE;
                for(int m = j-1; m > 0; m--)
                    maxProfit = Math.max(dp[i-1][m] + (prices[j] - prices[m]), maxProfit);
                dp[i][j] = Math.max(dp[i][j-1], maxProfit);
            }
        }

        return dp[k][prices.length-1];
    }

    public static int maxProfitWithKTransactions1(int[] prices, int k) {
        // Write your code here.
        int dp[][] = new int[k+1][prices.length];

        for(int i = 1; i < prices.length; i++) {
            for(int j = 1; j <= k; j++) {
                int maxProfit = Integer.MIN_VALUE;
                for(int m = j-1; m > 0; m--)
                    maxProfit = Math.max(dp[i-1][m] - prices[m], maxProfit);
                dp[i][j] = Math.max(dp[i][j-1], maxProfit + prices[j]);
            }
        }

        return dp[k][prices.length-1];
    }

    private static boolean kmpSearch(String str, String pattern) {

        int len = pattern.length();
        int[] kmpArray = computeKMPArray(pattern, len);

        int i = 0;
        int j = 0;

        boolean isFound = false;
        while(i < str.length()) {
            if(pattern.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if(j == len) {
                System.out.println(" matched pattern at index: " + (i-j));
                j = kmpArray[j-1];
                isFound = true;
            }
            else if(i < str.length() && pattern.charAt(i) != pattern.charAt(j) ){
                if(j != 0)
                    j = kmpArray[j-1];
                else
                    i++;
            }
        }
        return isFound;
    }

    static int[] computeKMPArray(String pattern, int len) {
        int i = 0;
        int j = 1;
        int[] lps = new int[len];
        lps[0] = 0;
        while(i < len) {
            if(pattern.charAt(i) == pattern.charAt(j)) {
                i++;
                lps[j] = i;
                j++;
            }

            if(j != 0) {
                lps[j] = lps[j-1];
            }
            else {
                lps[j] = 0;
                i++;
            }
        }

        return lps;
    }

    //abcd$ef$axb$c$
    //$$abf
    //f$axb$
    static String findStringinAnother(String bigString, String smallString) {
        HashMap<Character, Integer> mapSmall = new HashMap<>();
        for(int i = 0; i < smallString.length(); i++) {
            if(!mapSmall.containsKey(smallString.charAt(i))) {
                mapSmall.put(smallString.charAt(i), 1);
            }
            else {
                mapSmall.put(smallString.charAt(i), mapSmall.get(smallString.charAt(i))+1);
            }
        }
        int start = -1;
        int minLen = 0;
        int end = 0;
        for(; end < bigString.length(); end++ ) {
            if (mapSmall.containsKey(bigString.charAt(end)) &&
                    mapSmall.get(bigString.charAt(end)) > 0) {
                mapSmall.put(bigString.charAt(end), mapSmall.get(bigString.charAt(end))-1);
                if (start == -1)
                    start = end;
                minLen++;
            }
            if(minLen == smallString.length()) {
                break;
            }
        }
        int minStart = start;
        int minEnd = end;
        ArrayList<Integer> countIndex = new ArrayList<>();
        String str = "adafadsf";
        str.charAt(0);
        if(minLen == smallString.length())
        {
            minLen = minEnd - minStart + 1;
            end++;
            while(end < bigString.length()) {
                if(bigString.charAt(end) == bigString.charAt(start)) {
                    start++;
                    while(!mapSmall.containsKey(bigString.charAt(start)))
                        start++;
                }
                if((end - start + 1) < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                    minEnd = end;
                }
                end++;
            }
        } else {
            return new String();
        }

        return minEnd == bigString.length() ? bigString.substring(minStart, minEnd) : bigString.substring(minStart, minEnd+1);
    }
}
