package test;

import java.util.ArrayList;
import java.util.List;

public class zAlgo {
    public static void main(String[] args) {
// non-empty immutable set
        List<String> list = List.of("Geeks", "For", "Geeks");
        int n = 5;

        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;

        getNoOfConfigurations(n, dp);

    }
    public static int getNoOfConfigurations(int n, int[] dp) {
        if(n == 0)
            return 0;

        if(dp[n] != 0)
            return dp[n];

        int sum = 0;
        for(int i = 1; i < n; i++) {
            if(dp[i] == 0)
                dp[i] = getNoOfConfigurations(i, dp);
            if(dp[n-i] == 0)
                dp[n-i] = getNoOfConfigurations(n-i, dp);
            sum += dp[i] + dp[n-i];
        }
        dp[n] = sum;
        return dp[n];
    }
    void kpm(String text, String pattern) {

        int[] zArr = new int[pattern.length()];
        calculateZArr(zArr, pattern);
        int i = 0;
        int j = 0;
        int len = 0;
        ArrayList<Integer[]> result = new ArrayList<>();
        int pre = 0;
        while(i < text.length()) {
            if(text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if(j == pattern.length()) {

                Integer[] values = {pre, i};
                result.add(values);

                i++;
                j--;
            }
            else if(i < text.length() && text.charAt(i) != pattern.charAt(i)) {
                if(zArr[j] != 0) {
                    j = zArr[j];
                }
                else {
                    i++;
                    j = 0;
                }
            }
        }

    }

    void calculateZArr(int[] zArr, String pattern) {
        int i = 0;
        int j = 1;
        while( i < pattern.length()) {

            if(pattern.charAt(i) == pattern.charAt(j)) {
                i++;
                zArr[i] = j;
                j++;
            }
            else {
                if(zArr[j] != 0)
                    j = zArr[j-1];
                else {
                    zArr[j] = 0;
                    i++;
                }
            }
        }

    }
}
