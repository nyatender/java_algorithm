package Grokking_java_interview.TwoPointers;

/*
Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.

Input: str1="xy#z", str2="xzz#"
Output: true
Explanation: After applying backspaces the strings become "xz" and "xz" respectively.

Input: str1="xy#z", str2="xyz#"
Output: false
Explanation: After applying backspaces the strings become "xz" and "xy" respectively.

Input: str1="xp#", str2="xyz##"
Output: true
Explanation: After applying backspaces the strings become "x" and "x" respectively.
In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.

 */

import java.util.Arrays;
import java.util.Collections;

class BackspaceCompare {
    public static void main(String[] args) {
        String[] str1= {"xy#z" , "xy#z", "xp#"};
        String[] str2= {"xzz#" , "xyz#", "xyz##"};

        for(int i = 0; i < str1.length; i++)
            System.out.println(compare(str1[i], str2[i]));

    }

    public static boolean compare(String str1, String str2) {
        // TODO: Write your code here
        int i = str1.length()-1;
        int j = str2.length()-1;
        while(i >= 0 && j >= 0) {
            int count1 = 0;
            int count2 = 0;
            while(i >= 0 && str1.charAt(i) == '#') {
                count1++;
                i--;
            }
            while(j >= 0 && str2.charAt(j) == '#') {
                count2++;
                j--;
            }
            i = i - count1;
            j = j - count2;
            if(i >= 0 && j >= 0 && str1.charAt(i) == str2.charAt(j)) {
                i--;
                j--;
            }
            else if(i != 0 || j != 0){
                return false;
            }

        }
        return true;
    }
}
