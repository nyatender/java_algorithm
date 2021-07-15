package DynamicProgramming.palindrome;

public class findLPSLengthRecursive {

    public int findLPSLength(String st) {
        return findLPSLengthRecursive(st, 0, st.length() - 1);
    }

    private int findLPSLengthRecursive(String st, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return 0;

        // every string with one character is a palindrome
        if (startIndex == endIndex)
            return 1;

        // case 1: elements at the beginning and the end are the same
        if (st.charAt(startIndex) == st.charAt(endIndex)) {
            int remainingLength = endIndex - startIndex - 1;
            // check if the remaining string is also a palindrome
            if (remainingLength == findLPSLengthRecursive(st, startIndex + 1, endIndex - 1))
                return remainingLength + 2;
        }

        // case 2: skip one character either from the beginning or the end
        int c1 = findLPSLengthRecursive(st, startIndex + 1, endIndex);
        int c2 = findLPSLengthRecursive(st, startIndex, endIndex - 1);
        return Math.max(c1, c2);
    }
    //Memoization
    //===========================================================
    public int findLPSLengthMemo(String st) {
        Integer[][] dp = new Integer[st.length()][st.length()];
        return findLPSLengthRecursive(dp, st, 0, st.length() - 1);
    }

    private int findLPSLengthRecursive(Integer[][] dp, String st, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return 0;

        // every string with one character is a palindrome
        if (startIndex == endIndex)
            return 1;

        if (dp[startIndex][endIndex] == null) {
            // case 1: elements at the beginning and the end are the same
            if (st.charAt(startIndex) == st.charAt(endIndex)) {
                int remainingLength = endIndex - startIndex - 1;
                // check if the remaining string is also a palindrome
                if (remainingLength == findLPSLengthRecursive(dp, st, startIndex + 1, endIndex - 1)) {
                    dp[startIndex][endIndex] = remainingLength + 2;
                    return dp[startIndex][endIndex];
                }
            }

            // case 2: skip one character either from the beginning or the end
            int c1 = findLPSLengthRecursive(dp, st, startIndex + 1, endIndex);
            int c2 = findLPSLengthRecursive(dp, st, startIndex, endIndex - 1);
            dp[startIndex][endIndex] = Math.max(c1, c2);
        }

        return dp[startIndex][endIndex];
    }
    //BottomUP
    //========================================================
    public int findLPSLengthBottomUp(String st) {
        // dp[i][j] will be 'true' if the string from index 'i' to index 'j' is a
        // palindrome
        boolean[][] dp = new boolean[st.length()][st.length()];

        // every string with one character is a palindrome
        for (int i = 0; i < st.length(); i++)
            dp[i][i] = true;

        int maxLength = 1;
        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
                if (st.charAt(startIndex) == st.charAt(endIndex)) {
                    // if it's a two character string or if the remaining string is a palindrome too
                    if (endIndex - startIndex == 1 || dp[startIndex + 1][endIndex - 1]) {
                        dp[startIndex][endIndex] = true;
                        maxLength = Math.max(maxLength, endIndex - startIndex + 1);
                    }
                }
            }
        }

        return maxLength;
    }
    //=============================================================
    public static String longestPalindromicSubstring(String str) {
        String longest = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                String substring = str.substring(i, j + 1);
                if (substring.length() > longest.length() && isPalindrome(substring))
                    longest = substring;
            }
        }

        return longest;
    }
    public static boolean isPalindrome(String str) {
        int leftIdx = 0;
        int rightIdx = str.length() - 1;
        while (leftIdx < rightIdx) {
            if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
                return false;
            }
            leftIdx++;
            rightIdx--;
        }
        return true;
    }
    //==================================================================
    public static String longestPalindromicSubstring1(String str) {
        int[] currentLongest = {0, 1};
        for (int i = 1; i < str.length(); i++) {
            int[] odd = getLongestPalindromeFrom(str, i - 1, i + 1);
            int[] even = getLongestPalindromeFrom(str, i - 1, i);
            int[] longest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
            currentLongest =
                    currentLongest[1] - currentLongest[0] > longest[1] - longest[0]
                            ? currentLongest
                            : longest;
        }
        return str.substring(currentLongest[0], currentLongest[1]);
    }
    public static int[] getLongestPalindromeFrom(String str, int leftIdx, int rightIdx) {
        while (leftIdx >= 0 && rightIdx < str.length()) {
            if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
                break;
            }
            leftIdx--;
            rightIdx++;
        }
        return new int[]{leftIdx + 1, rightIdx};
    }

    public static void main(String[] args) {
        findLPSLengthRecursive lps = new findLPSLengthRecursive();
        System.out.println(lps.findLPSLength("abdbca"));
        System.out.println(lps.findLPSLength("cddpd"));
        System.out.println(lps.findLPSLength("pqr"));
    }
}