package DynamicProgramming;

import java.util.Arrays;

public class minDel {
    public int findMDI(String s, String t) {
        int c1 = findLCSLength(s.toCharArray(), t.toCharArray());
        return s.length() - c1;
    }

    private int findLCSLength(char[] s1, char[] s2) {
        Arrays.sort(s1);
        Arrays.sort(s2);
        int[][] dp = new int[s1.length + 1][s2.length + 1];
        int maxLength = 0;
        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i - 1] == s2[j - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength;
    }
//    private int findLCSLength1(String s1, String s2) {
//
//        int[] freq1 = new int[26];
//        for(int i = 0; i < s1.length(); i++) {
//            int index = s1.charAt(i) - 'a';
//            freq1[index]++;
//        }
//        int[] freq2 = new int[26];
//        for(int i = 0; i < s2.length(); i++) {
//            int index = s2.charAt(i) - 'a';
//            freq2[index]++;
//        }
//    }

    public static void main(String[] args) {
        minDel mdi = new minDel();
//        System.out.println(mdi.findMDI("123122"));
//        System.out.println(mdi.findMDI("123456"));
//        System.out.println(mdi.findMDI("abdc" +
//                "                          bda"));
    }
}