package algoexpert.Hard;

import java.util.*;

public class allprob {
    public static void main(String[] args) {
        int n = 12;
        int[] denoms = new int[]{2, 3, 7};
        //noOfWays(denoms, n);
        int n1 = 3;
        int[] denoms1 = new int[]{2, 1};
        //System.out.println(minNumberOfCoinsForChange(n1, denoms1));

    }

    //========================================================================
    static int noOfWays(int[]denoms, int n) {

        int[] ways = new int[n+1];
        ways[0] = 1;
        for(int denom : denoms) {
            for(int amount = 1; amount < n+1; amount++) {
                if(denom <= amount)
                    ways[amount] += ways[amount - denom];
            }
        }

        return ways[n];
    }

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        // Write your code here.
        int[] dp = new int[n+1];
        int[] index = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < denoms.length; i++) {
            for(int j = 1; j <= n; j++) {
                if(denoms[i] <= j) {
                    if(dp[j] > dp[j- denoms[i]]+1) {
                        dp[j] = dp[j- denoms[i]]+1;
                        index[j] = i;
                    }
                }
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
    //======================================================================================
    //Move element to end
    //======================================================================================
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // Write your code here.
        int i = 0;
        int j = array.size() - 1;
        while(i < j) {
            while(j >= 0 && array.get(j) == toMove) {
                j--;
                continue;
            }
            while(i < array.size() && array.get(i) != toMove) {
                i++;
                continue;
            }
            if(i < j) {
                Collections.swap(array, i, j);
            }
        }
        return array;
    }
    //======================================================================================
    // monotonic array
    //======================================================================================
    public static boolean isMonotonic(int[] array) {
        // Write your code here.
        if (array.length <= 2)
            return true;

        boolean isIncresing = true;
        int i = 1;
        while (i < array.length && array[i - 1] == array[i]) {
            i++;
            continue;
        }
        if (i == array.length)
            return true;

        if (array[i - 1] > array[i])
            isIncresing = false;

        for (; i < array.length; i++) {
            if (isIncresing == true && array[i - 1] <= array[i])
                continue;
            else if (isIncresing == false && array[i - 1] >= array[i])
                continue;

            return false;

        }

        return true;
    }
    //======================================================================================
    // river size array
    //======================================================================================
    public static List<Integer[]> dir = new ArrayList<>();
    public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        dir.add(new Integer[]{1,0});
        dir.add(new Integer[]{-1,0});
        dir.add(new Integer[]{0,1});
        dir.add(new Integer[]{0,-1});
        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 1 && !visited[i][j]) {
                    result.add(dfsLookUp(matrix, visited, i, j));
                }
            }
        }
        return result;
    }
    static int dfsLookUp(int[][] matrix, boolean[][] visited, int i, int j) {
        int count = 0;
        if(isSafe(matrix.length, matrix[0].length, i, j) && matrix[i][j] == 1 && !visited[i][j]) {
            visited[i][j] = true;
            count++;
            for(Integer[] di : dir)
                count += dfsLookUp(matrix, visited, i + di[0], j + di[1]);
        }
        return count;
    }
    static boolean isSafe(int R, int C, int i, int j) {
        return i < R && i >= 0 && j < C && j >= 0;
    }
    //======================================================================================
    // kadanes Algo
    //======================================================================================
    public static int kadanesAlgorithm(int[] array) {
        // Write your code here.
        if(array.length == 0)
            return 0;
        if(array.length == 1)
            return array[0];
        int maxSum = array[0];
        int sumSoFar = array[0];
        for(int i = 1; i < array.length; i++) {
            sumSoFar = Math.max(array[i], sumSoFar + array[i]);
            if(maxSum < sumSoFar)
                maxSum = sumSoFar;

            if(sumSoFar < 0)
                sumSoFar = 0;
        }

        return maxSum;
    }
    //======================================================================================
    // levenshteinDistance
    //======================================================================================

    public static int levenshteinDistance(String str1, String str2) {
        // Write your code here.
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int j = 0; j <= str2.length(); j++)
            dp[0][j] = j;

        for(int i = 0; i <= str1.length(); i++)
            dp[i][0] = i;

        for(int i = 1; i <= str1.length(); i++) {
            for(int j = 1; j <= str2.length(); j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                }
            }
        }

        return dp[str1.length()][str2.length()];
    }

    //======================================================================================
    // shiftedBinarySearchUtils
    //======================================================================================
    public static int shiftedBinarySearch(int[] array, int target) {
        // Write your code here.
        return shiftedBinarySearchUtils(array, 0, array.length-1, target);
    }

    static int shiftedBinarySearchUtils(int[] array, int start, int end, int target) {
        if(start == end) {
            if (array[start] == target)
                return start;
            else
                return -1;
        }

        int mid = start + (end-start)/2;
        if(array[mid] == target)
            return mid;

        if(array[start] <= array[mid]) {
            if(target >= array[start] && target <= array[mid])
                return shiftedBinarySearchUtils(array, start, mid, target);
            else {
                return shiftedBinarySearchUtils(array, mid+1, end, target);
            }
        }
        else {
            if(target >= array[mid] && target <= array[end])
                return shiftedBinarySearchUtils(array, mid+1, end, target);
            else {
                return shiftedBinarySearchUtils(array, start, mid, target);
            }
        }
    }

    //======================================================================================
    // multiStringSearch
    //======================================================================================
    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
        // Write your code here.
        Boolean resultArray[] = new Boolean[smallStrings.length];
        Arrays.fill(resultArray, Boolean.FALSE);
        for(int s = 0; s < smallStrings.length; s++) {

            int lps[] = new int[smallStrings[s].length()];
            computeLPSArray(smallStrings[s], smallStrings[s].length(), lps);
            int i = 0;
            int j = 0;
            while (i < bigString.length()) {
                if(smallStrings[s].charAt(j) == bigString.charAt(i))
                {
                    i++;
                    j++;
                }
                if(j == smallStrings[s].length()) {
                    resultArray[s] = true;
                    break;
                }
                else if (i < bigString.length() && smallStrings[s].charAt(j) != bigString.charAt(i)) {
                    if(j != 0)
                        j = lps[j-1];
                    else
                        i++;
                }
            }
        }
        return new ArrayList<Boolean>(Arrays.asList(resultArray));
    }
    static void computeLPSArray(String pat, int M, int lps[])
    {
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else
            {
                if (len != 0) {
                    len = lps[len - 1];
                }
                else
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }


    //======================================================================================
    // longestSubstringWithoutDuplication
    //======================================================================================
    public static String longestSubstringWithoutDuplication(String str) {
        // Write your code here
        if(str.length() == 0 || str.length() == 1)
            return str;

        int preIndex = 0;
        int[] indexs = new int[]{0,0};
        HashMap<Character, Integer> hMap = new HashMap<>();
        int max = 1;
        for(int i = 0; i < str.length(); i++) {
            if(hMap.containsKey((str.charAt(i)))) {
                if((i - preIndex) > max) {
                    max = i - preIndex;
                    indexs[0] = preIndex;
                    indexs[1] = i-1;
                }
                if(hMap.get(str.charAt(i)) >= preIndex)
                    preIndex = hMap.get(str.charAt(i)) + 1;
            }
            else {
                if((i - preIndex + 1) > max) {
                    max = i - preIndex + 1;
                    indexs[0] = preIndex;
                    indexs[1] = i;
                }
            }
            hMap.put(str.charAt(i), i);
        }
        return str.substring(indexs[0], indexs[1]+1);
    }


    //======================================================================================
    // searchForRange
    //======================================================================================

    public static int[] searchForRange(int[] array, int target) {
        // Write your code here.
        Range range = new Range(-1,-1);
        searchForRangeUtils(array, 0, array.length-1, target, range);
        return new int[]{range.start, range.end};
    }
    public static void searchForRangeUtils(int[] array, int s, int e, int target, Range range) {
        // Write your code here.
        if(s > e)
            return;

        int mid = (s + e)/2;
        if(array[mid] == target)
        {
            if(range.start == -1 && range.end == -1) {
                range.start = mid;
                range.end = mid;
            }	else {
                if(range.start >= mid)
                    range.start = mid;
                if(range.end <= mid)
                    range.end = mid;
            }
        }
        if(target <= array[mid])
            searchForRangeUtils(array, s, mid-1, target, range);
        if(target >= array[mid])
            searchForRangeUtils(array, mid+1, e, target, range);
    }
    static class Range {
        public int start;
        public int end;
        Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    //======================================================================================
    // shiftedBinarySearchUtils
    //======================================================================================



    //======================================================================================
    // shiftedBinarySearchUtils
    //======================================================================================


    //======================================================================================
    // shiftedBinarySearchUtils
    //======================================================================================
}
