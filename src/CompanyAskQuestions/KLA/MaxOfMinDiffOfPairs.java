package CompanyAskQuestions.KLA;

import java.util.Arrays;
//https://www.geeksforgeeks.org/maximum-of-minimum-difference-of-all-pairs-from-subsequences-of-given-size/
public class MaxOfMinDiffOfPairs {

    // Function to check a subsequence can
// be formed with min difference mid
    static boolean can_place(int A[], int n,
                             int B, int mid)
    {
        int count = 1;
        int last_position = A[0];

        // If a subsequence of size B
        // with min diff = mid is possible
        // return true else false
        for(int i = 1; i < n; i++)
        {
            if (A[i] - last_position >= mid)
            {
                last_position = A[i];
                count++;
                if (count == B)
                {
                    return true;
                }
            }
        }
        return false;
    }

    // Function to find the maximum of
// all minimum difference of pairs
// possible among the subsequence
    static int find_min_difference(int A[],
                                   int n, int B)
    {

        // Sort the Array
        Arrays.sort(A);

        // Stores the boundaries
        // of the search space
        int s = 0;
        int e = A[n - 1] - A[0];

        // Store the answer
        int ans = 0;

        // Binary Search
        while (s <= e)
        {
            int mid = (s + e) / 2;

            // If subsequence can be formed
            // with min diff mid and size B
            if (can_place(A, n, B, mid))
            {
                ans = mid;

                // Right half
                s = mid + 1;
            }
            else
            {

                // Left half
                e = mid - 1;
            }
        }
        return ans;
    }

    // Driver Code
    public static void main(String[] args)
    {
//        int A[] = { 1, 2, 3, 5 };
//        int B = 3;
          int A[] = {5, 17, 11}, B = 2;
//          // 5 11 17


        int min_difference = find_min_difference(A, A.length, B);

        System.out.print(min_difference);
    }
}