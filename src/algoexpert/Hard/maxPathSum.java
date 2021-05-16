package algoexpert.Hard;

public class maxPathSum {
    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1  );
        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);

        root.right = new BinaryTree(3);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);
        IntegerVal maxSubTreeVal = new IntegerVal(Integer.MIN_VALUE);
        IntegerVal maxPathVal = new IntegerVal(Integer.MIN_VALUE);

        maxPathSumCal(root, maxSubTreeVal, maxPathVal);
        maxPathVal.val = Math.max(maxPathVal.val, maxSubTreeVal.val);
        System.out.println(maxPathVal.val);
    }
    static class IntegerVal {
        int val;
        IntegerVal(int v) {
           this.val = v;
        }
    }
    static int maxPathSumCal(BinaryTree tree, IntegerVal maxSumSubTree, IntegerVal maxSumOfPath) {
        // Write your code here.
        if(tree == null)
            return 0;

        if(tree.left == null && tree.right == null)
            return tree.value;

        int leftMax = Integer.MIN_VALUE;
        if(tree.left != null) {
            leftMax = maxPathSumCal(tree.left, maxSumSubTree, maxSumOfPath);
            maxSumOfPath.val = Math.max(maxSumOfPath.val, leftMax);
        }

        int rightMax = Integer.MIN_VALUE;
        if(tree.right != null) {
            rightMax = maxPathSumCal(tree.right, maxSumSubTree, maxSumOfPath);
            maxSumOfPath.val = Math.max(maxSumOfPath.val, rightMax);

        }

        maxSumOfPath.val = maxSumOfPath.val + tree.value;
        int curr_maxSumSubTree = (tree.left == null ? 0 : leftMax) + (tree.right == null ? rightMax : 0) + tree.value;
        maxSumSubTree.val = Math.max(maxSumSubTree.val, curr_maxSumSubTree);

        return maxSumOfPath.val;
    }

}
