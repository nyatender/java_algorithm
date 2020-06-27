/*
package test;

import java.util.*;

public class arrayRotation
{
    public static void main(String[] args) {
        */
/*{
            int[] arr = new int[]{-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
            int[] output = rearrangeArr(arr, arr.length);
            for (int i = 0; i < output.length; i++)
                System.out.print(output[i] + " ");
        } *//*

        getPermutaion();
    }
    public static int[] rearrangeArr(int[] input, int length)
    {
        int[] result = new int[length];
        for(int i = 0; i < length;) {
            if(input[i] >= 0 && input[i] < input.length && input[i] != i)
            {
                int source = input[input[i]];
                input[input[i]] = input[i];
                input[i] = source;
            }
            else
                i++;
        }
        return input;
    }
    // non repeated after k, maximum combination of string
    public static void getCombinationOftheStrings(String input, int k) {

        PriorityQueue<String> Queue = new PriorityQueue<String>(input.length(), Collections.reverseOrder());

        char ch = input.charAt(0);
        int pre = 0;
        for(int i = 1; i < input.length(); i++) {
            while(input.charAt(i) == ch && i < input.length())
                i++;
            String tempStr = input.substring(pre, i);
            Queue.offer(tempStr);
        }
        String preString = new String();
        String result = new String();
        while(!Queue.isEmpty()) {
           String temp = Queue.poll();
           if(temp.length() > k)
               result += temp.substring(0, k);
           else
               result += temp;

            if(preString.length() > k)
                preString =  temp.substring(k, temp.length());
        }

    }
    public static void getPermutaion()
    {
        String input = "abc";
        HashMap<Integer, ArrayList<String>> result = new LinkedHashMap<>();
        ArrayList<String> list = new ArrayList<>();
        list.add(Character.toString(input.charAt(0)));
        result.put(1, new ArrayList<String>(input.charAt(0)));
        for(int i = 1; i < input.length(); i++) {
            ArrayList<String> tempList = new ArrayList<>();
            tempList.add(Character.toString(input.charAt(i)));
            result.get(1).add(Character.toString(input.charAt(i)));
            for(int j =0; j < list.size(); j++) {
                tempList.add(input.charAt(i) + list.get(j));
                if(result.get(input.charAt(i) + list.get(j)) == null)
                    result.put((input.charAt(i) + list.get(j)).length(), new ArrayList<String>(input.charAt(i)));
                result.get((list.get(j) + input.charAt(i)).length()).add(Character.toString(input.charAt(i)));
                tempList.add(list.get(j) + input.charAt(i));
            }
            list.addAll(tempList);
        }
      //  list.forEach(item -> System.out.println(item) );
        for(Map.Entry item : result.entrySet())
            System.out.println(item.getValue());
    }
}
*/

package test;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.regex.Pattern;

public class arrayRotation {

    public static String MissingDigit(String str) {
        // code goes here
        String[] input = str.split(" ");
        boolean isFound = false;
        int pos = 0;
        for(int i = 0; i < input.length; i++  ) {
            if(input[i].contains("x")) {
                isFound = true;
                pos = i;
                break;
            }
        }

        String compareTo = new String();
        String b = new String();
        String Res = new String();
        String op;
        if(pos == 0) {
            compareTo = input[0];
            op = input[1];
            Res = findResult(input[4], input[2], op, false);
        }
        else if(pos == 2) {
            compareTo = input[2];
            op = input[1];
            Res = findResult(input[4], input[0], op, false);

        }
        else if(pos == 4) {
            op = input[1];
            compareTo = findResult(input[0], input[2], op, true);;
            Res = input[4];
        }
        int index = compareTo.indexOf('x');
        char ch = Res.charAt(index);
        return Character.toString(ch);
    }

    public static String findResult(String a, String b, String op, boolean isCorrectSign)
    {
        int x = Integer.parseInt(a);
        int y = Integer.parseInt(b);

        int result = 0;
        if(op.compareTo("*") == 0) {
            if(isCorrectSign == true) {
                result = x*y;
            }
            else {
                result = x/y;
            }
        }
        else if(op.compareTo("/") == 0) {
            if(isCorrectSign == true) {
                result = x/y;
            }
            else {
                result = x*y;
            }
        }
        else if(op.compareTo("+") == 0) {
            if(isCorrectSign == true) {
                result = x+y;
            }
            else {
                result = x-y;
            }
        }
        else if(op.compareTo("-") == 0) {
            if(isCorrectSign == true) {
                result = x-y;
            }
            else {
                result = x+y;
            }
        }

        return String.valueOf(result);
    }
    public static String WildcardCharacters(String str) {
        // code goes here
        String[] input = str.split(" ");
        boolean dp[][] = new boolean[input[0].length()+1][input[1].length()+1];

        for(int i = 0; i <= str.length(); i++) {
            for(int j = 0; j <= str.length(); j++) {

                if(input[0].charAt(i) == input[1].charAt(j) || input[1].charAt(j) == '*') {
                    dp[i+1][j+1] = dp[i][j];
                }
                else if(input[1].charAt(i) == '+') {
                    dp[i+1][j+1] = dp[i+1][j] || dp[i][j+1];
                }
                else
                    dp[i+1][j+1] = false;
            }
        }

        return Boolean.toString(dp[input[0].length()][input[1].length()]);
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(MissingDigit("1x0 * 12 = 1200"
        ));
    }

}
