package algoexpert.Hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DistinctPalindrome {
    public static void main(String[] args) {
        //String input = "aabaac";
        String input = "aabaa";
        System.out.println(distinctPalimdromes(input));
    }

    public static int distinctPalimdromes(String input) {

        if (input.length() == 0)
            return 0;
        Map<String, Integer> uniqueLength = new HashMap<>();
        char[] arr = input.toCharArray();
        int row = input.length();
        int col = input.length();
        boolean[][] table = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            table[i][i] = true;
            String key = input.substring(i, i + 1);
            uniqueLength.put(key, uniqueLength.getOrDefault(key, 0) + 1);
            if (i < row - 1 && arr[i] == arr[i + 1]) {
                table[i][i + 1] = true;
                key = input.substring(i, i + 2);
                uniqueLength.put(key, uniqueLength.getOrDefault(key, 0) + 1);
            }
        }

        for (int l = 3; l <= row; l++) {
            for (int start = 0; start + l - 1 < row; start++) {
                int end = start + l - 1;
                if (arr[start] == arr[end]) {
                    if (table[start + 1][end - 1]) {
                        String key = input.substring(start, end + 1);
                        uniqueLength.put(key, uniqueLength.getOrDefault(key, 0) + 1);
                        table[start][end] = true;
                    } else {
                        table[start][end] = false;
                    }
                }
            }
        }
        Set<String> enty = uniqueLength.keySet();
        for (String in : enty)
            System.out.print(in + " ");
        return uniqueLength.size();
    }
}