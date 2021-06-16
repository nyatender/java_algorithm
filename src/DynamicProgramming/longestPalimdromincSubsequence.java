package DynamicProgramming;

public class longestPalimdromincSubsequence {

    public static void main(String[] args) {
        String in = "abdbca";
        longestPalimdromincSubsequence obj = new longestPalimdromincSubsequence();

        //with recursion
        System.out.println(obj.findLPSLengthRecursive(in, 0, in.length()-1));

        //with memoization
        Integer[][] dp = new Integer[in.length()][in.length()];
        System.out.println(obj.findLPSLengthRecursiveWithMemoization(in, 0, in.length()-1, dp));

        //TopDown
        System.out.println(obj.findLPSTopDown(in));

    }

    public int findLPSLength(String st) {
        return findLPSLengthRecursive(st, 0, st.length() - 1);
    }

    private int findLPSLengthRecursive(String st, int startIndex, int endIndex) {
        if(startIndex > endIndex)
            return 0;
        if(startIndex == endIndex)
            return 1;

        if(st.charAt(startIndex) == st.charAt(endIndex))
            return 2 + findLPSLengthRecursive(st, startIndex+1, endIndex-1);

        return Math.max(findLPSLengthRecursive(st, startIndex, endIndex-1),
                        findLPSLengthRecursive(st, startIndex+1, endIndex));
    }
    private int findLPSLengthRecursiveWithMemoization(String st, int startIndex, int endIndex, Integer[][] dp) {
        if(startIndex > endIndex)
            return 0;
        if(startIndex == endIndex)
            return 1;

        if(dp[startIndex][endIndex] == null) {

            if (st.charAt(startIndex) == st.charAt(endIndex)) {
                dp[startIndex][endIndex] = 2 + findLPSLengthRecursiveWithMemoization(st, startIndex + 1, endIndex - 1, dp);
            } else {
                int c1 = findLPSLengthRecursiveWithMemoization(st, startIndex, endIndex - 1, dp);
                int c2 = findLPSLengthRecursiveWithMemoization(st, startIndex + 1, endIndex, dp);

                dp[startIndex][endIndex] = Math.max(c1,c2);
            }
        }
        return dp[startIndex][endIndex];
    }

    private int findLPSTopDown(String st) {
        int[][] dp = new int[st.length()][st.length()];
        for(int i = 0; i < st.length(); i++)
            dp[i][i] = 1;
        int maxLength = 1;
        for(int L = 2; L <= st.length(); L++) {
            for(int start = 0; start < st.length()-L+1; start++) {
                int end = start + L - 1;
                if(st.charAt(start) == st.charAt(end)) {
                        dp[start][end] = 2+dp[start+1][end-1];
                }
                else {
                    dp[start][end] = Math.max(dp[start+1][end], dp[start][end-1]);

                }
                maxLength = Math.max(maxLength, dp[start][end]);
            }
        }

        return maxLength;
    }
}
