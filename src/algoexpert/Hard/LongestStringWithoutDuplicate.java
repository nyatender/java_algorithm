package algoexpert.Hard;

import java.util.HashMap;

public class LongestStringWithoutDuplicate {
    public static void main(String[] args) {
        String str = "clementisacap";
        System.out.println(longestSubstringWithoutDuplication(str));
    }
    //"clementisacap"
    public static String longestSubstringWithoutDuplication(String str) {
        // Write your code here
        if(str.length() == 0 || str.length() == 1)
            return str;

        int pre = 0;
        int[] indexs = new int[]{0,0};
        HashMap<Character, Integer> hMap = new HashMap<>();
        int max = 1;
        for(int i = 0; i < str.length(); i++) {
            if(hMap.containsKey((str.charAt(i)))) {
                if((i - pre) > max) {
                    max = i - pre;
                    indexs[0] = pre;
                    indexs[1] = i-1;
                }
                if(hMap.get(str.charAt(i)) >= pre)
                    pre = hMap.get(str.charAt(i)) + 1;
            }
            else {
                if((i - pre + 1) > max) {
                    max = i - pre + 1;
                    indexs[0] = pre;
                    indexs[1] = i;
                }
            }
            hMap.put(str.charAt(i), i);
        }
        return str.substring(indexs[0], indexs[1]+1);
    }
}
