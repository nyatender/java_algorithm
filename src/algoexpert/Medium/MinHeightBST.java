package algoexpert.Medium;
import java.util.*;
public class MinHeightBST {
    public static BST minHeightBst(List<Integer> array) {
        // Write your code here.
        Integer[] arr = new Integer[array.size()];
        return buildBST(array, 0, array.size()-1);
    }
    static private BST buildBST(List<Integer> array, int s, int end) {
        if(s > end)
            return null;

        int mid = (s + end)/2 ;
        BST root = new BST(array.get(mid));
        root.left = buildBST(array, s, mid-1);
        root.right = buildBST(array, mid+1, end);

        return root;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
}
