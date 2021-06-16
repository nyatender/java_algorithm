package DynamicProgramming;

import java.util.ArrayList;

public class countway {

    public int CountWays(int n) {
        // TODO: Write your code here

        return -1;
    }
    public ArrayList<Integer> CountWaysUtils(int n, int i, ArrayList<ArrayList<Integer>> res) {
        if(n - i < 0)
            return null;

        if(n == 0) {
            return new ArrayList<Integer>();
        }

        ArrayList<Integer> r1 = CountWaysUtils(n-i, i, res);
        if(r1 != null) {
            r1.add(i);
        }
        ArrayList<Integer> r2 = CountWaysUtils(n-i, i+1, res);
        if(r2 != null) {
            r2.add(i+1);
        }

        return null;
    }

    public static void main(String[] args) {
        countway en = new countway();
        System.out.println(en.CountWays(4));
        System.out.println(en.CountWays(5));
        System.out.println(en.CountWays(6));
    }
}