package test;

import java.util.ArrayList;
import java.util.List;

public class zAlgo {
    public static void main(String[] args) {
// non-empty immutable set
        List<String> list = List.of("Geeks", "For", "Geeks");
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
