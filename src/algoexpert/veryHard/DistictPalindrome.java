package algoexpert.veryHard;

import java.util.HashMap;

public class DistictPalindrome {
    // Function to return the count
    // of distinct palindromic sub-strings
    // of the given string s
    static int palindromeSubStrs(String s)
    {

        // To store the positions of
        // palindromic sub-strings
        int[][] dp = new int[s.length()][s.length()];
        int st, end, i, len;

        // Map to store the sub-strings
        HashMap<String, Boolean> m = new HashMap<>();

        for (i = 0; i < s.length(); i++)
        {

            // Sub-strings of length 1 are palindromes
            dp[i][i] = 1;

            // Store continuous palindromic sub-strings
            m.put(s.substring(i, i + 1), true);
        }

        // Store palindromes of size 2
        for (i = 0; i < s.length() - 1; i++)
        {
            if (s.charAt(i) == s.charAt(i + 1))
            {
                dp[i][i + 1] = 1;
                m.put(s.substring(i, i + 2), true);
            }

            // If str[i...(i+1)] is not a palindromic
            // then set dp[i][i + 1] = 0
            else
                dp[i][i + 1] = 0;
        }

        // Find palindromic sub-strings of length>=3
        for (len = 3; len <= s.length(); len++)
        {
            for (st = 0; st <= s.length() - len; st++)
            {

                // End of palindromic substring
                end = st + len - 1;

                // If s[start] == s[end] and
                // dp[start+1][end-1] is already palindrome
                // then s[start....end] is also a palindrome
                if (s.charAt(st) == s.charAt(end) &&
                        dp[st + 1][end - 1] == 1)
                {

                    // Set dp[start][end] = 1
                    dp[st][end] = 1;
                    m.put(s.substring(st, end + 1), true);
                }

                // Not a palindrome
                else
                    dp[st][end] = 0;
            }
        }

        // Return the count of distinct palindromes
        return m.size();
    }

    // Driver Code
    public static void main(String[] args)
    {
        String s = "aabaa";
        System.out.println(palindromeSubStrs(s));
    }
}

// This code is contributed by
// sanjeev2552
