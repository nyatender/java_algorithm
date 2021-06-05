package problems;

import java.util.ArrayList;

public class generateNGreyCode {
    public static void main(String[] args) {

        generateNGreyCode(3).forEach(System.out::println);
    }

    static ArrayList<String> generateNGreyCode(int n) {
        ArrayList<String> start = new ArrayList<>();
        start.add("0");
        start.add("1");

        int sizeOfGresyCode = start.get(0).length();
        while(n > sizeOfGresyCode) {
            int len = start.size();
            int[] newArr = new int[len*2];
            ArrayList<String> res = new ArrayList<>();
            for(int i = 0; i < len; i++) {
                res.add("0" + start.get(i));
            }
            for(int i = len-1; i >= 0; i--) {
                res.add("1" + start.get(i));
            }
            sizeOfGresyCode = res.get(0).length();
            start = res;
        }

        return start;
    }

    static ArrayList<String> generateNGreyCode(int n, boolean isRecursive) {

        ArrayList<String> result = new ArrayList<>();
        result.add("0");
        result.add("1");
        generateNGreyCodeUtils(result, n, 0);
        return result;
    }
    static void generateNGreyCodeUtils(ArrayList<String> input, int n, int index) {
//        if(input.get(0).length() == n)
//            return;
//
//        if(index >= input.size())
//            return;
//
//        ArrayList<String> newList = new ArrayList<>();
//        newList.add("0" + input.get(index) );
//        generateNGreyCodeUtils(newList, n, index+1);
//
//        newList.add("1" + input.get(index) );
//        generateNGreyCodeUtils(input, n, index+1);

    }
}
