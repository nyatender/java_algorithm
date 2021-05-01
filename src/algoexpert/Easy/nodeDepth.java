package algoexpert.Easy;

public class nodeDepth {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.left.left.left = new BinaryTree(8);
        root.left.left.right = new BinaryTree(9);

        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);
        System.out.println(AllNodeDepths(root));
    }

    //=============================================================
    public static int nodeDepths(BinaryTree root) {
        // Write your code here.
        return root == null ? 0 : nodeDepthsUtils(root, 0);
    }

    static int nodeDepthsUtils(BinaryTree root, int d) {
        if (root.left == null && root.right == null)
            return d;

        int l = root.left == null ? 0 : nodeDepthsUtils(root.left, d + 1);
        int r = root.right == null ? 0 : nodeDepthsUtils(root.right, d + 1);

        return l + r + d;
    }
    //=================================================================================
    public static int AllNodeDepths(BinaryTree root) {
        // Write your code here.
        AllSubTreeSum sum = new AllSubTreeSum(0);
        if(root == null)
            return 0;
        AllNodeDepthsUtils(root, sum);
        return sum.val;
    }
    static int AllNodeDepthsUtils(BinaryTree root, AllSubTreeSum sum) {
        if (root.left == null && root.right == null)
            return 1;

        int leftNodeCount = 0;
        if(root.left != null)
            leftNodeCount = AllNodeDepthsUtils(root.left, sum);

        int rightNodeCount = 0;
        if(root.right != null)
            rightNodeCount = AllNodeDepthsUtils(root.right, sum);

        sum.add(leftNodeCount, rightNodeCount);
        return leftNodeCount + rightNodeCount   + 3;
    }
    static class AllSubTreeSum {
        private int val;
        AllSubTreeSum(int i) {
            val = i;
        }
        void add(int a, int b) {
            val += a + b;
        }
        void add(int a, int b, int i) {
            val += a + b + i;
        }
    }
    //=================================================================================
    static class BinaryTree {
        int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
