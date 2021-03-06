package DynamicProgramming.palindrome;

public class PalimdromicPartitions1 {
    //=======================================================================
    public int findMPPCuts(String st) {
        return this.findMPPCutsRecursive(st, 0, st.length() - 1);
    }
    private int findMPPCutsRecursive(String st, int startIndex, int endIndex) {
        // we don't need to cut the string if it is a palindrome
        if (startIndex >= endIndex || isPalindrome(st, startIndex, endIndex))
            return 0;

        // at max, we need to cut the string into its 'length-1' pieces
        int minimumCuts = endIndex - startIndex;
        for (int i = startIndex; i <= endIndex; i++) {
            if (isPalindrome(st, startIndex, i)) {
                // we can cut here as we have a palindrome from 'startIndex' to 'i'
                minimumCuts = Math.min(minimumCuts, 1 + findMPPCutsRecursive(st, i + 1, endIndex));
            }
        }
        return minimumCuts;
    }

    private boolean isPalindrome(String st, int x, int y) {
        while (x < y) {
            if (st.charAt(x++) != st.charAt(y--))
                return false;
        }
        return true;
    }
    //===================================================================
    public int findMPPCutsMemo(String st) {
        Integer dp[][] = new Integer[st.length()][st.length()];
        Boolean dpIsPalindrome[][] = new Boolean[st.length()][st.length()];
        return this.findMPPCutsRecursive(dp, dpIsPalindrome, st, 0, st.length()-1);
    }

    private int findMPPCutsRecursive(Integer dp[][], Boolean dpIsPalindrome[][],
                                     String st, int startIndex, int endIndex) {

        if(startIndex >= endIndex || isPalindrome(dpIsPalindrome, st, startIndex, endIndex))
            return 0;

        if(dp[startIndex][endIndex] == null) {
            // at max, we need to cut the string into its 'length-1' pieces
            int minimumCuts = endIndex-startIndex;
            for (int i=startIndex; i <= endIndex; i++) {
                if(isPalindrome(dpIsPalindrome, st, startIndex, i)){
                    // we can cut here as we have a palindrome from 'startIndex' to 'i'
                    minimumCuts = Math.min(minimumCuts, 1+findMPPCutsRecursive(dp, dpIsPalindrome, st, i+1, endIndex));
                }
            }
            dp[startIndex][endIndex] = minimumCuts;
        }
        return dp[startIndex][endIndex];
    }
    private boolean isPalindrome(Boolean dpIsPalindrome[][], String st, int x, int y) {
        if(dpIsPalindrome[x][y] == null) {
            dpIsPalindrome[x][y]=true;
            int i=x, j=y;
            while(i < j) {
                if(st.charAt(i++) != st.charAt(j--)) {
                    dpIsPalindrome[x][y]=false;
                    break;
                }
                // use memoization to find if the remaining string is a palindrome
                if(i < j && dpIsPalindrome[i][j] != null) {
                    dpIsPalindrome[x][y] = dpIsPalindrome[i][j];
                    break;
                }
            }
        }
        return dpIsPalindrome[x][y];
    }
    public static void main(String[] args) {
        PalimdromicPartitions1 mpp = new PalimdromicPartitions1();
        System.out.println(mpp.findMPPCuts("abdbca"));
        System.out.println(mpp.findMPPCuts("cdpdd"));
        System.out.println(mpp.findMPPCuts("pqr"));
        System.out.println(mpp.findMPPCuts("pp"));
    }
}