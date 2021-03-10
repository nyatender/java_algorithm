
/*


Pattern Matcher

you are given two non-empty strings. The first one is a patter consisting
of only "x" s and / or "y" s; the other one is a normal string of alphanumeric
characters. Write a function that checks whether the normal string matches
the patters.

A string S0 is said to match a pattern if replacing all "x"s in the pattern with somr
non=empty substring S1 of S0 and replacing all "y" s in the pattern with some
non-empty substring S2 of S0 yields the same string S0.

If the input string doesn't match the input pattern, the function should
return an empty array;
otherwise, it should return an array holding the string S1 and S2 that represent
"x" and "y" in the normal string in the order. If the pattern does'nt contain
any "x"s or "y" s the representative letter should be represented by an empty
string in the final array that you return.
* */
package algoexpert.Hard;

import java.util.HashMap;

public class PatternMatcher {
    public static void main(String[] args) {
        String pattern = "xxyxxy";
        String str = "gogopowerrangergogopowerranger";
        patternMatcher(pattern, str);
    }

    public static String[] patternMatcher(String pattern, String str) {
        // Write your code here.
        String[] res = new String[2];
        HashMap<Character, Integer> charCount = new HashMap<>();
        charCount.put('x', 0);
        charCount.put('y', 0);
        for(int i = 0; i < pattern.length(); i++) {
            if(pattern.charAt(i) == 'x')
                charCount.put('x', charCount.get('x')+1);
            else if(pattern.charAt(i) == 'y')
                charCount.put('y', charCount.get('y')+1);
        }
        Boolean switched = new Boolean(false);
        Integer Y_Pos = -1;
        char[] newPattern = isFirstYPos(pattern, switched, Y_Pos );

        int xCount = charCount.get('x');
        int yCount = charCount.get('y');
        if(yCount != 0) {
            for (int i = 1; i < str.length(); i++) {
                int lengthOf_x = i;
                int lengthOF_y = (newPattern.length - xCount * lengthOf_x) / yCount;
                if(IsPatternMatch(newPattern, str, lengthOf_x, Y_Pos, lengthOF_y)) {
                    if(!switched) {
                        res[0] = str.substring(0, lengthOf_x);
                        res[1] = str.substring(Y_Pos, lengthOF_y);
                    }
                    else {
                        res[1] = str.substring(0, lengthOf_x);
                        res[0] = str.substring(Y_Pos, lengthOF_y);
                    }
                    return res;
                }
            }
        }

        return res;
    }

    static  boolean IsPatternMatch(char[] pattern, String str, int x_end, int y_start, int y_end) {
        String x_str = str.substring(0, x_end);
        if(y_start + y_end > str.length())
            return false;
        String y_str = str.substring(y_start, y_end);

        String resultantStr = new String();
        for(int i = 0; i < pattern.length; i++) {
            if(pattern[i] == 'x')
                resultantStr += x_str;
            else
                resultantStr += y_str;
        }
       return resultantStr.equals(str);
    }
    static char[] isFirstYPos(String pattern, Boolean switched, Integer Y_Pos ) {

        char[] newPatterArray = pattern.toCharArray();
        for(int i = 0; i < newPatterArray.length; i++) {
            if(Y_Pos == -1 && newPatterArray[i] == 'y') {
                Y_Pos = i;
                break;
            }
        }
        if(pattern.charAt(0) == 'x') {
            return newPatterArray;
        }
        switched = true;
        for(int i = 0; i < newPatterArray.length; i++) {
            if(newPatterArray[i] == 'x')
                newPatterArray[i] = 'y';
            else {
                newPatterArray[i] = 'x';
            }
        }

        return newPatterArray;
    }
}

