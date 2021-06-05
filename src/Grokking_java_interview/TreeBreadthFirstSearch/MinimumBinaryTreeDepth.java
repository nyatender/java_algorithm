package Grokking_java_interview.TreeBreadthFirstSearch;

import java.util.*;

class Result {
    int min;
    Result(int l) {
        this.min = l;
    }
}
class MinimumBinaryTreeDepth {
    public static int findDepth(TreeNode root) {
        // TODO: Write your code here
        if(root == null)
            return 0;
        Result result = new Result(Integer.MAX_VALUE);
        findDepthUtils(root, 1, result);
       // findDepthUtils(root.right, pair);
        return result.min;
    }
    public static void findDepthUtils(TreeNode root, int level, Result result) {
        // TODO: Write your code here
        if(root == null) {
            result.min = Math.min(result.min, level);
            return;
        }

        findDepthUtils(root.left, level + 1, result);
        findDepthUtils(root.right, level + 1, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
    }
}
