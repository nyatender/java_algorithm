package algoexpert.Medium;

public class BinaryTreeDiameter {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(3);
        root.right = new BinaryTree(2);
        root.left.left = new BinaryTree(7);
        root.left.left.left = new BinaryTree(8);
        root.left.left.left.left = new BinaryTree(9);

        root.left.right = new BinaryTree(4);
        root.left.right.right = new BinaryTree(5);
        root.left.right.right.right = new BinaryTree(6);

        System.out.println(binaryTreeDiameter(root));
    }
    // Average case: when the tree is balanced
    // O(n) time | O(h) space - where n is the number of nodes in
    // the Binary Tree and h is the height of the Binary Tree
    static public int binaryTreeDiameter(BinaryTree tree) {

        return getTreeInfo(tree).diameter;
    }
    static public TreeInfo getTreeInfo(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfo(0, 0);
        }
        TreeInfo leftTreeInfo = getTreeInfo(tree.left);
        TreeInfo rightTreeInfo = getTreeInfo(tree.right);

        int longestPathThroughRoot = 1 + leftTreeInfo.height + rightTreeInfo.height;
        int maxDiameterSoFar = Math.max(leftTreeInfo.diameter, rightTreeInfo.diameter);

        int currentDiameter = Math.max(longestPathThroughRoot, maxDiameterSoFar);
        int currentHeight = 1 + Math.max(leftTreeInfo.height, rightTreeInfo.height);

        return new TreeInfo(currentDiameter, currentHeight);
    }
    static class NodeInfo {
        int maxPathSoFar;
        int maxPathSumSoFar;
        public NodeInfo(int msf, int mpsssf) {
            this.maxPathSoFar = msf;
            this.maxPathSumSoFar = mpsssf;
        }
    }
    public static int maxPathSum(BinaryTree tree) {
        // Write your code here.
        if(tree == null)
            return 0;

        NodeInfo maxSumOfPath = new NodeInfo(Integer.MIN_VALUE, Integer.MIN_VALUE);
        return maxPathSumCal(tree).maxPathSumSoFar;
    }
    public static NodeInfo maxPathSumCal(BinaryTree tree) {
        if(tree == null) {
            return null;
        }
        NodeInfo l1 = maxPathSumCal(tree.left);
        NodeInfo r1 = maxPathSumCal(tree.right);

        int maxPathFromLeftAndRight = Math.max(l1.maxPathSoFar, r1.maxPathSoFar);
        int currMaxPathSum = tree.value + maxPathFromLeftAndRight;
        int maxPathIncludingNode = Math.max(tree.value + maxPathFromLeftAndRight, maxPathFromLeftAndRight);
        maxPathIncludingNode = Math.max(tree.value + l1.maxPathSoFar + r1.maxPathSoFar, maxPathIncludingNode);
        maxPathIncludingNode = Math.max(Math.max(l1.maxPathSumSoFar, r1.maxPathSumSoFar), maxPathIncludingNode);

        return new NodeInfo(currMaxPathSum, maxPathIncludingNode);
    }

    static class TreeInfo {
        public int diameter;
        public int height;
        public TreeInfo(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
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



