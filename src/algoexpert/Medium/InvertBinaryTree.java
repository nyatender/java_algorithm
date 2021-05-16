package algoexpert.Medium;

public class InvertBinaryTree {
    public static void invertBinaryTree(BinaryTree tree) {
        // Write your code here.
        if(tree == null)
            return;

        if(tree.left == null && tree.right == null)
            return;

        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);

        BinaryTree temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;
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
