package algoexpert.Hard;

import java.util.ArrayList;
import java.util.Arrays;
/*
Max Path Sum In Binary Tree
Write a function that takes in a Binary Tree and returns its max path sum.
A path is a collection of connected nodes in a tree, where no node is
connected to more than two other nodes; a path sum is the sum of the
values of the nodes in a particular path.
Each BinaryTree node has an integer value , a left child node, and
a right child node. Children nodes can either be BinaryTree nodes
themselves or None / null .
Sample Input
tree =     1
         /   \
        2     3
       / \   / \
      4   5 6   7
Sample Output
18 // 5 + 2 + 1 + 3 + 7
 */
import java.util.*;
public class MaxPathSumOfBinaryTree {

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);

        System.out.println(maxPathSum(root));
    }

    // O(n) time | O(log(n)) space
    public static int maxPathSum(BinaryTree tree) {
        List<Integer> maxSumArray = findMaxSum(tree);
        return maxSumArray.get(1);
    }
    public static List<Integer> findMaxSum(BinaryTree tree) {
        if (tree == null) {
            return new ArrayList<Integer>(Arrays.asList(0, Integer.MIN_VALUE));
        }
        List<Integer> leftMaxSumArray = findMaxSum(tree.left);
        List<Integer> rightMaxSumArray = findMaxSum(tree.right);

        Integer leftMaxSumAsBranch = leftMaxSumArray.get(0);
        Integer leftMaxPathSum = leftMaxSumArray.get(1);

        Integer rightMaxSumAsBranch = rightMaxSumArray.get(0);
        Integer rightMaxPathSum = rightMaxSumArray.get(1);

        Integer maxChildSumAsBranch = Math.max(leftMaxSumAsBranch, rightMaxSumAsBranch);
        Integer maxSumAsBranch = Math.max(maxChildSumAsBranch + tree.value, tree.value);
        Integer maxSumAsRootNode = Math.max(leftMaxSumAsBranch + tree.value + rightMaxSumAsBranch, maxSumAsBranch);
        int maxPathSum = Math.max(leftMaxPathSum, Math.max(rightMaxPathSum, maxSumAsRootNode));
        return new ArrayList<Integer>(Arrays.asList(maxSumAsBranch, maxPathSum));
    }
    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;
        public BinaryTree(int value) {
            this.value = value;
        }
    }
}

