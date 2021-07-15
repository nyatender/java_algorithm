package algoexpert.Hard;

import java.util.HashMap;
import java.util.Map;

public class nodeDepth {
    public static void main(String[] args) {

    }
    public static int allKindsOfNodeDepths(BinaryTree root) {
        if (root == null) return 0;
        return allKindsOfNodeDepths(root.left) + allKindsOfNodeDepths(root.right) + nodeDepths(root, 0);
    }

    public static int nodeDepths(BinaryTree node, int depth) {
        if (node == null)
            return 0;
        return depth + nodeDepths(node.left, depth + 1) + nodeDepths(node.right, depth+1);
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
