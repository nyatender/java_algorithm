package Grokking_java_interview.BitWiseXOR;

import java.lang.Math;

class CalculateComplement {
    public static int bitwiseComplement(int n) {
        // TODO: Write your code here
        int result = 0;
        for(int i = 0; n != 0; i++) {
            if(n%2 == 0) {
                result += Math.pow(2, i);
            }
            n = n/2;
        }
        return result;
    }

    public static void main( String args[] ) {
        System.out.println("Bitwise complement is: " + CalculateComplement.bitwiseComplement(8));
        System.out.println("Bitwise complement is: " + CalculateComplement.bitwiseComplement(10));
    }
}
