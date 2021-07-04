package problems.generalProblemSet;

import java.util.ArrayList;

/*
8.	Given a number as input we need to print the number in its prime factorization form.
For e.g. Input: 24
Output: 2,2,2,3
Complexity: Medium

 */
public class prime {
    public static void main(String[] args) {
        ArrayList<Integer> result =  new ArrayList<>();
        PrimeFactor(10, 2, result);
        result.forEach(System.out::println);
    }

    static void PrimeFactor(int num, int div, ArrayList<Integer> result) {
        if(num <= div) {
            result.add(div);
            return;
        }

        if(num % div != 0) {
            PrimeFactor(num, div+1, result);
        }
        else {
            num = num / div;
            result.add(div);
            PrimeFactor(num, div, result);
        }
    }
}
