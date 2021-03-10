/*
Multi String Search

write a function that takes in a big string and array of small strings, all of which are
smaller in length than the big string. The function should return an array of booleans, where each
boolean represents whether the small string at that index in array of small strings is contained in the big string.

Note that you can't use language build in string matching methods.

Sample Input#1

bigString = "this is a big string"
smallString = ["this", "yo", "is", "a", "bigger", "kappa"]

Sample Output#1

[true, false,true, true, false, true, false]

Sample Input#2

bigString = "abcdefghijklmnopqrstuvwxyz"
smallString = ["abc", "mnopqr", "wyz", "no", "e", "tuuv"]

Sample Output#2

[true, true, false, true, true, false]
*/
package algoexpert.Hard;

import java.util.*;

public class MultiStringSearch {
    public static void main(String[] args) {
        String bigString = "abcdefghijklmnopqrstuvwxyz";
        String smallString[] = {"abc", "mnopqr", "wyz", "no", "e", "tuuv"};
        multiStringSearch(bigString, smallString).forEach(item -> System.out.println(item));
    }
    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
        // Write your code here.
        Boolean resultArray[] = new Boolean[smallStrings.length];
        Arrays.fill(resultArray, Boolean.FALSE);
        for (int s = 0; s < smallStrings.length; s++) {

            int lps[] = new int[smallStrings[s].length()];
            computeLPSArray(smallStrings[s], smallStrings[s].length(), lps);
            int i = 0;
            int j = 0;
            while (i < bigString.length()) {
                if (smallStrings[s].charAt(j) == bigString.charAt(i)) {
                    i++;
                    j++;
                }
                if (j == smallStrings[s].length()) {
                    resultArray[s] = true;
                    break;
                } else if (i < bigString.length() && smallStrings[s].charAt(j) != bigString.charAt(i)) {
                    if (j != 0)
                        j = lps[j - 1];
                    else
                        i++;
                }
            }
        }
        return new ArrayList<Boolean>(Arrays.asList(resultArray));
    }

    static void computeLPSArray(String pat, int M, int lps[]) {
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}
