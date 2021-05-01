package algoexpert.Easy;

public class findClosestValueInBST {
        static class minValue {
            int minDiff = Integer.MAX_VALUE;
            int minNode = -1;
            minValue(int min, int minNode) {
                this.minNode = minNode;
            }
        }
        public static int findClosestValueInBst(BST tree, int target) {
            // Write your code here.
            if(tree == null)
                return 0;

            minValue minV = new minValue(tree.value, tree.value);
            findClosestValueInBstUtil(tree, minV, target);

            return minV.minNode;
        }
        static void findClosestValueInBstUtil(BST tree, minValue min, int target) {
            if(tree == null)
                return;

            int val = Math.abs(tree.value - target);
            if(val <= min.minDiff) {
                min.minDiff = val;
                min.minNode = tree.value;
                if(val == 0)
                    return;
            }

            if(target < tree.value)
                findClosestValueInBstUtil(tree.left, min, target);

            else if(target > tree.value)
                findClosestValueInBstUtil(tree.right, min, target);

    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
