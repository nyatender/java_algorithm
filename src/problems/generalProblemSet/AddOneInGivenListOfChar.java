package problems.generalProblemSet;

import java.util.ArrayList;
import java.util.Arrays;

public class AddOneInGivenListOfChar {
    public static void addOneInGivenNumber(ArrayList<Character> number) {
        int lastIndex = number.size()-1;
        int val = 0;
        int carry = 1;
        ArrayList<Character> result = new ArrayList<>();
        while(lastIndex >= 0) {
            val = (number.get(lastIndex) - '0') + carry;
            if (val >= 10) {
                number.set(lastIndex, '0');
                carry = 1;
                lastIndex--;
            } else {
                number.set(lastIndex, Character.forDigit(val, 10));
                carry = 0;
                break;
            }
        }
        if(carry == 1) {
            number.add(0, '1');
        }
    }

    public static void main(String[] args) {
        ArrayList<Character> input1 = new ArrayList<>(Arrays.asList('1', '2', '3'));
        ArrayList<Character> input2 = new ArrayList<>(Arrays.asList('1', '9', '9'));
        ArrayList<Character> input3 = new ArrayList<>(Arrays.asList('9', '9', '9'));

        addOneInGivenNumber(input1);
        input1.forEach(i -> System.out.print(i + " "));
        System.out.println();
        addOneInGivenNumber(input2);
        input2.forEach(i -> System.out.print(i + " "));
        System.out.println();
        addOneInGivenNumber(input3);
        input3.forEach(i -> System.out.print(i + " "));
    }
}