package algoexpert.veryHard;
import java.util.*;

public class numberOFBinaryTopologies {
    public static int numberOfBinaryTreeTopologies(int n) {
        // Write your code here.
        if(n == 0)
            return 1;

        int[] T = new int[n+1];
        T[0] = 1;
        T[1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                // lets 10, 11  n = 2;
                // if 10 is root then left side it have 0 and right side n - 1 = 2 - 1 = 1
                // if 11 is root then left side it have n - 1 and right side 0
                // total = 1 + 1 = 2
                T[i] += T[j]*T[i-j-1];
            }
        }
        return T[n];
    }

    public static void main(String[] args) {
        System.out.println(numberOFBinaryTopologies.numberOfBinaryTreeTopologies(5));
    }
}
