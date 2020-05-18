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

public class BigBinaryNumber {

    public static void main(String[] args)
    {
        int num = 3;
        long sum = findBigNum(num);
    }

    static long findBigNum(long num)
    {
        final long div = (long)Math.pow(10, 9) + 7;
        long sum = 0;
        if(num < 1 || num > div)
            return sum;

        System.out.println(Math.ceil(Math.log1p(16)));
//        int j = 0;
//        for(long i = num; i > 0; i--)
//        {
//            long temp = i;
//            while (temp != 0)
//            {
//                long val = temp % 2;
//                temp = temp/2;
//                double v = Math.pow(2, j++) * val;
//                sum += v % div;
//            }
//        }
        return sum;
    }

}
