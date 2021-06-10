package algoexpert.veryHard;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/distinct-palindromic-sub-strings-of-the-given-string-using-dynamic-programming/
public class palindromeSubStrs {

    // Function to print all distinct palindrome
    // sub-strings of s
    static void palindromeSubStr(String s)
    {
        //map<string, int> m;
        Map<String , Integer> map = new HashMap<>();
        int n = s.length();

        // table for storing results (2 rows for odd-
        // and even-length palindromes
        int[][] R = new int[2][n+1];

        // Find all sub-string palindromes from the
        // given input string insert 'guards' to
        // iterate easily over s
        s = "@" + s + "#";

        for (int j = 0; j <= 1; j++)
        {
            int rp = 0;   // length of 'palindrome radius'
            R[j][0] = 0;

            int i = 1;
            while (i <= n)
            {
                //  Attempt to expand palindrome centered
                // at i
                while (s.charAt(i - rp - 1) == s.charAt(i + j + rp))
                    rp++;  // Incrementing the length of
                // palindromic radius as and
                // when we find vaid palindrome

                // Assigning the found palindromic length
                // to odd/even length array
                R[j][i] = rp;
                int k = 1;
                while ((R[j][i - k] != rp - k) && (k < rp))
                {
                    R[j][i + k] = Math.min(R[j][i - k],
                            rp - k);
                    k++;
                }
                rp = Math.max(rp - k, 0);
                i += k;
            }
        }

        // remove 'guards'
        s = s.substring(1, s.length()-1);

        // Put all obtained palindromes in a hash map to
        // find only distinct palindromess
        map.put(s.substring(0,1), 1);
        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j <= 1; j++)
                for (int rp = R[j][i]; rp > 0; rp--)
                    map.put(s.substring(i - rp - 1,  i - rp - 1 + 2 * rp + j), 1);
            map.put(s.substring(i, i + 1), 1);
        }

        // printing all distinct palindromes from
        // hash map
        System.out.println("Below are " + (map.size())
                + " palindrome sub-strings");

        for (Map.Entry<String, Integer> ii:map.entrySet())
            System.out.println(ii.getKey());
    }

    // Driver program
    public static void main(String args[])
    {
        palindromeSubStr("aabaa");
    }
}