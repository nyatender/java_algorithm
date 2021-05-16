package algoexpert.veryHard;
import java.util.*;
public class RightSmallerThan {
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