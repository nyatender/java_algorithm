package DynamicProgramming;

public class longestPalindromicSubstring {
    public static void main(String[] args) {
        String str =  "abdbca";
        longestPalindromicSubstring obj = new longestPalindromicSubstring();
        int MaxLength = obj.longestPalindromicSubStr(str, 0, str.length()-1);
        System.out.println(MaxLength);

        Integer[][] dp = new Integer[str.length()][str.length()];
        MaxLength = obj.longestPalindromicSubStrWithMemoization(str, 0, str.length()-1, dp);
        System.out.println(MaxLength);

        MaxLength = obj.longestPalindromicSuStrBottomUp(str);
        System.out.println(MaxLength);
    }
    int longestPalindromicSubStr(String str, int startIndex, int endIndex) {
        if(startIndex > endIndex) {
            return 0;
        }
        if(startIndex == endIndex)
            return 1;

        if(str.charAt(startIndex) == str.charAt(endIndex)) {
            int remainingLen = endIndex-startIndex-1;
            if(remainingLen == longestPalindromicSubStr(str,startIndex+1, endIndex-1)) {
                return 2 + remainingLen;
            }
        }

        return Math.max(longestPalindromicSubStr(str, startIndex+1, endIndex),
                 longestPalindromicSubStr(str, startIndex, endIndex-1));
    }
    int longestPalindromicSubStrWithMemoization(String str, int startIndex, int endIndex, Integer[][] dp) {
        if(startIndex > endIndex) {
            return 0;
        }
        if(startIndex == endIndex)
            return 1;

        if(dp[startIndex][endIndex] == null) {
            if (str.charAt(startIndex) == str.charAt(endIndex)) {
                int remainingLen = endIndex - startIndex - 1;
                if (remainingLen == longestPalindromicSubStrWithMemoization(str, startIndex + 1, endIndex - 1, dp)) {
                    dp[startIndex][endIndex] = 2 + remainingLen;
                    return dp[startIndex][endIndex];
                }
            }

            int c1 = longestPalindromicSubStrWithMemoization(str, startIndex + 1, endIndex, dp);
            int c2 = longestPalindromicSubStrWithMemoization(str, startIndex, endIndex - 1, dp);

            dp[startIndex][endIndex] = Math.max(c1,c2);

        }
        return dp[startIndex][endIndex];
    }

    int longestPalindromicSuStrBottomUp(String str) {
        boolean[][]dp = new boolean[str.length()][str.length()];

        for (int i = 0; i < str.length(); i++)
            dp[i][i] = true;

        int maxLength = 1;
        for(int i = 2; i < str.length(); i++) {
            for(int j = 0; j < str.length()-i+1; j++) {
                int end = j + i - 1;
                if(end - j == 1 || str.charAt(j) == str.charAt(end)) {
                    if(dp[j+1][end-1] == true)
                        maxLength = Math.max(maxLength, i);
                }
            }

        }
        return maxLength;
    }
}
