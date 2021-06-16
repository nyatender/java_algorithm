package algoexpert.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Same BSTs
An array of integers is said to represent the Binary Search Tree (BST) obtained
by inserting each integer in the array, from left to right, into the BST.
Write a function that takes in two arrays of integers and determines whether
these arrays represent the same BST. Note that you're not allowed to construct
any BSTs in your code.
A BST is a Binary Tree that consists only of BST nodes. A node is said to be a
valid BST node if and only if it satisfies the BST property: its value is strictly
greater than the values of every node to its left; its value is less than or equal to
the values of every node to its right; and its children nodes are either valid BST
nodes themselves or None / null .
Sample Input
arrayOne = [10, 15, 8, 12, 94, 81, 5, 2, 11]
arrayTwo = [10, 8, 5, 15, 2, 12, 11, 94, 81]
Sample Output
true // both arrays represent the BST below
 10
 / \
 8 15
 / / \
 5 12 94
 / / /
2 11 81

 */
public class SameBST {
    public static void main(String[] args) {
        List<Integer> arrayOne = new ArrayList<>(Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, 11));
        List<Integer> arrayTwo = new ArrayList<>(Arrays.asList(10, 8, 5, 15, 2, 12, 11, 94, 81));

        System.out.println(sameBsts(arrayOne, arrayTwo));
    }

    // O(n^2) time | O(n^2) space - where n is the number of
    // nodes in each array, respectively
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne.size() != arrayTwo.size())
            return false;
        if (arrayOne.size() == 0 && arrayTwo.size() == 0)
            return true;
        if (arrayOne.get(0).intValue() != arrayTwo.get(0).intValue())
            return false;
        List<Integer> leftOne = getSmaller(arrayOne);
        List<Integer> leftTwo = getSmaller(arrayTwo);
        List<Integer> rightOne = getBiggerOrEqual(arrayOne);
        List<Integer> rightTwo = getBiggerOrEqual(arrayTwo);
        return sameBsts(leftOne, leftTwo) && sameBsts(rightOne, rightTwo);
    }

    public static List<Integer> getSmaller(List<Integer> array) {
        List<Integer> smaller = new ArrayList<Integer>();
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i).intValue() < array.get(0).intValue())
                smaller.add(array.get(i));
        }
        return smaller;
    }

    public static List<Integer> getBiggerOrEqual(List<Integer> array) {
        List<Integer> biggerOrEqual = new ArrayList<Integer>();
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i).intValue() >= array.get(0).intValue())
                biggerOrEqual.add(array.get(i));
        }
        return biggerOrEqual;
    }
}
