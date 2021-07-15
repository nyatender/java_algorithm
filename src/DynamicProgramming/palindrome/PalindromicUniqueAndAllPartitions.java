package DynamicProgramming.palindrome;

import java.util.ArrayList;
import java.util.HashSet;

public class PalindromicUniqueAndAllPartitions {
    public static void main(String[] args) {
        System.out.println(palindromicPartitions("abdbca"));
        System.out.println(palindromicPartitions("abcbm"));
        System.out.println(palindromicPartitions("abdbca"));
        System.out.println(palindromicPartitions("cdpdd"));
        System.out.println(palindromicPartitions("pqr"));
        System.out.println(palindromicPartitions("cddpd"));
    }
    static ArrayList palindromicPartitions(String input) {
        ArrayList<String> re = new ArrayList<>();
        HashSet<String> uniquePartition = new HashSet<>();
        for(int i = 0; i < input.length(); i++) {
            re.add(Character.toString(input.charAt(i)));
            uniquePartition.add(Character.toString(input.charAt(i)));
        }
        for(int len = 1; len < input.length(); len++) {
            for(int j = 0; j+len < input.length(); j++) {
                if(isPalindrome(input, j, len+j)) {
                    String subStr = input.substring(j, j+len+1);
                    re.add(subStr);
                    uniquePartition.add(subStr);
                }
            }
        }
        System.out.println("\nunique partitions");
        System.out.println(uniquePartition);
        System.out.println("All partitions");
        return re;
    }
    static boolean isPalindrome(String input, int start, int end) {
        while(start < end) {
            if(input.charAt(start) != input.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
