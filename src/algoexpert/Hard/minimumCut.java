package algoexpert.Hard;

public class minimumCut {
    public static void main(String[] args) {

        String str = "abcbm";
        System.out.println(palindromePartitioningMinCuts(str));
    }

    public static int palindromePartitioningMinCuts(String str) {
        // Write your code here.
        int minCut = str.length() - 1;
        for(int i = 1; i < str.length(); i++) {
            int tempCut = str.length() - 1;
            for(int j = 0; j+i < str.length(); j ++) {
                if (isPalindrome(str, j, j + i)) {
                    tempCut = tempCut - i;
                }
            }
            if(tempCut < minCut)
                minCut = tempCut;
        }

        return minCut;
    }

    static boolean isPalindrome(String str, int s, int e) {
        if(s >= e)
            return true;

        if(str.charAt(s) == str.charAt(e))
            return isPalindrome(str, s+1, e-1);

        return false;
    }
}
