package algoexpert.veryHard;
import java.util.*;
/*
Right Smaller Than
Write a function that takes in an array of integers and returns an array of the same length,
where each element in the output array corresponds to the number of integers in the
input array that are to the right of the relevant index and that are strictly smaller than the
integer at that index.
In other words, the value at output[i] represents the number of integers that are to
the right of i and that are strictly smaller than input[i] .
Sample Input
array = [8, 5, 11, -1, 3, 4, 2]
Sample Output
[5, 4, 4, 0, 1, 1, 0]
// There are 5 integers smaller than 8 to the right of it.
// There are 4 integers smaller than 5 to the right of it.
// There are 4 integers smaller than 11 to the right of it.
// Etc..
 */
public class RightSmallerThan {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(8, 5, 11, -1, 3, 4, 2));
        List<Integer>result = rightSmallerThan(arr);
        result.forEach(i -> System.out.print(i + " "));
    }
    public static List<Integer> rightSmallerThan(List<Integer> array) {
        // Write your code here.
        if(array.size() == 0)
            return new ArrayList<Integer>();

        int last = array.size() - 1;
        SpecialBST root = new SpecialBST(last, array.get(last), 0);
        for(int i = array.size() - 2; i >= 0; i--) {
            root.insert(i, array.get(i));
        }

        ArrayList<Integer> results = new ArrayList<Integer>(array);

        getNextGreaterElements(root, results);

        return results;
    }

    static public void getNextGreaterElements(SpecialBST root, ArrayList<Integer> results) {
        if(root == null)
            return;
        results.set(root.idx, root.numSmallerAtInsertTime);

        getNextGreaterElements(root.leftSubTree, results);
        getNextGreaterElements(root.rightSubTree, results);
    }


    static class SpecialBST {
        private int idx;
        private int value;
        private int leftSubTreeCount;
        private int numSmallerAtInsertTime;
        private SpecialBST leftSubTree = null;
        private SpecialBST rightSubTree = null;

        public SpecialBST(int idx, int value, int numSmallerAtInsertTime) {
            this.idx = idx;
            this.value = value;
            this.leftSubTreeCount = 0;
            this.numSmallerAtInsertTime = numSmallerAtInsertTime;
        }
        public void insert(int idx, int value) {
            insertUtils(idx, value, 0);
        }
        public void insertUtils(int idx, int value, int numSmallerAtInsertTime) {
            if(value < this.value) {
                leftSubTreeCount++;
                if(leftSubTree == null) {
                    leftSubTree = new SpecialBST(idx, value, numSmallerAtInsertTime);
                }
                else {
                    leftSubTree.insertUtils(idx, value, numSmallerAtInsertTime);
                }
            }
            else {
                numSmallerAtInsertTime += leftSubTreeCount;
                if(value > this.value)
                    numSmallerAtInsertTime++;

                if(rightSubTree == null) {
                    rightSubTree = new SpecialBST(idx, value, numSmallerAtInsertTime);
                } else {
                    rightSubTree.insertUtils(idx, value, numSmallerAtInsertTime);
                }
            }
        }
    }
}