package problems;

/*

you have to find sum of the binaries and number produce by these binaries.

 Example: given number 3
 num -> binary
 1   -> 1
 2   -> 10
 3   -> 11

 sum of binary 11011 -> 27
 you can get number by dividing by 10 power 9 + 7
 */

import java.util.ArrayList;
import java.util.Iterator;

public class BigBinaryNumber {

    public static void main(String[] args)
    {
        int num = 7;
        long sum = findBigNum(num);
    }


    static long findBigNum(long num)
    {
        final long div = (long)Math.pow(10, 9) + 7;
        long sum = 0;
        if(num < 1 || num > div)
            return sum;
        ArrayList<String> arr = new ArrayList<>();
        arr.add ("0");
        arr.add ("1");
        for(int i = 2; i <= num; i*=2)
        {
            ArrayList<String> tempArr = new ArrayList<>();
            Iterator<String> it = arr.iterator();
            int count = i;
            for(int j = i; j > 0; j--)
                tempArr.add(new String("0" + it.next()));
            it = arr.iterator();
            for(int j = i; j > 0 && count <= num; j--, count++)
                tempArr.add(new String("1" + it.next()));
            arr = new ArrayList<String>(tempArr);
        }
        arr.forEach(item -> {
            System.out.println(item);
        });
        return sum;
    }

}
