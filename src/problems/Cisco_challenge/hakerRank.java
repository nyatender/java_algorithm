package problems.Cisco_challenge;

import java.util.ArrayList;

public class hakerRank {
    public static void main(String[] args) {
        //============================================
        String str = "..@qw.qeqw.rb@h.asd.hello!fg";
        System.out.println(CheckWord(str));
        //============================================

        //============================================
        System.out.println(CheckIfNumBinaryisPalindrom(9));
        //============================================

        //============================================
        String input1 = "10100111010";
        int k = 3; //count substring 2 time 1's and 2 time 0's
        System.out.println(printSubstrings(input1, k));
        //============================================

        int[] arary = new int[] {1/3, 1/4, 1/5}; //find how many highest common fractions
        //maxGCFofFraction(array)

        double[] trashVal = new double[] {1.1, 2.1, 3.1, 2.1, 1.1, 2.8, 1.7};
        System.out.println(countTrashRemove(trashVal));
    }

    //=======================================================================
    //=======================================================================
    static ArrayList<String> CheckWord(String str) {
        ArrayList<String> out = new ArrayList<>();

        int i = 0;
        while(!isValidChar(str, i)) {
            i++;
        }
        int lastIndex = i;
        while(i < str.length()) {
            if(isValidChar(str, i)) {
                i++;
                continue;
            }
            if(i - lastIndex > 1)
            {
                out.add(str.substring(lastIndex, i));
            }
            while(i < str.length() && !isValidChar(str, i)) {
                i++;
            }
            lastIndex = i;
            i++;
        }
        if(i - lastIndex > 1)
        {
            out.add(str.substring(lastIndex, i));
        }

        return out;
    }
    static boolean isValidChar(String str, int i) {
    if(     str.charAt(i) == '.' ||
            str.charAt(i) == '@' ||
            str.charAt(i) == '!')
            return  false;
        return  true;
    }
    //=======================================================================
    //=======================================================================

    static boolean CheckIfNumBinaryisPalindrom(int num) {
        String binaryVal = convertToBinary(num);
        int i = 0;
        int j = binaryVal.length() - 1;
        boolean isPalimdrom = true;
        while(i < j) {
            if(binaryVal.charAt(i) != binaryVal.charAt(j)) {
                isPalimdrom = false;
                break;
            }
            i++;
            j--;
        }
        return isPalimdrom;
    }
    static String convertToBinary(int num) {
        StringBuilder str = new StringBuilder();
        while(num != 0) {
            str.append(num%2);
            num = num/2;
        }
        return str.toString();
    }
    //=======================================================================
    //=======================================================================
    //"10100111010";
    static ArrayList<String> printSubstrings(String input, int k) {

        ArrayList<String> output = new ArrayList<>();
        if(k > input.length())
            return output;

        int countsOf_1 = 0;
        int countsOf_0 = 0;
        int s = 0;
        int i = 0;
        while(i < input.length()) {
            if(countsOf_1 == k && countsOf_0 == k) {
                output.add(input.substring(s, i));
            }
            if(input.charAt(i) == '0')
                countsOf_0++;
            if(input.charAt(i) == '1')
                countsOf_1++;

            while(countsOf_0 > k || countsOf_1 > k) {
                if(input.charAt(s) == '1')
                    countsOf_1--;
                else
                    countsOf_0--;
                s++;
            }
            i++;
        }
        if(countsOf_1 == k && countsOf_0 == k) {
            output.add(input.substring(s, i));
        }
        return output;
    }

   static int countTrashRemove(double[] trash) {
        if(trash.length == 0)
            return 0;

        double v = 3;
        int i = 1;
        int count = 0;
        double sum = trash[0];
        while(i < trash.length) {
            if(sum > v) {
                count++;
                sum = 0;
            }
            sum += trash[i];
            i++;
        }
        if(sum > v) {
            count++;
        }
        return count;
    }
}
