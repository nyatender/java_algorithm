package test;

import java.util.*;

public class zigzag {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    static public List<List<TreeNode>> traverse(TreeNode root) {
        List<List<TreeNode>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean isLeftToRight = true;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<TreeNode> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(isLeftToRight) {
                    list.add(node);
                }
                else {
                    list.add(0, node);
                }
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            result.add(list);
            isLeftToRight = !isLeftToRight;
        }
        return result;
    }
    public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        return maxPathSumUtils(root).get(1);
    }

    public ArrayList<Integer> maxPathSumUtils(TreeNode root) {
        if(root == null)
            return (new ArrayList<Integer>(Arrays.asList(0, Integer.MIN_VALUE)));

        ArrayList<Integer> leftPathVal = maxPathSumUtils(root.left);
        int leftPathSumAsBranch = leftPathVal.get(0);
        int maxPathSumOfLeft = leftPathVal.get(1);

        ArrayList<Integer> rightPathVal = maxPathSumUtils(root.right);
        int rightPathSumAsBranch = rightPathVal.get(0);
        int maxPathSumOfRight = rightPathVal.get(1);

        int maxFromLeftAndRight = Math.max(leftPathSumAsBranch, rightPathSumAsBranch);
        int maxPathSumIncludingOrExcludingNode = Math.max(maxFromLeftAndRight + root.val, root.val);
        int maxPathSumOfNodeSoFar = leftPathSumAsBranch + rightPathSumAsBranch + root.val;

        maxPathSumOfNodeSoFar = Math.max(maxPathSumOfNodeSoFar, maxPathSumIncludingOrExcludingNode);
        maxPathSumOfNodeSoFar = Math.max(maxPathSumOfNodeSoFar, Math.max(maxPathSumOfLeft, maxPathSumOfRight));

        return new ArrayList(Arrays.asList(maxPathSumIncludingOrExcludingNode, maxPathSumOfNodeSoFar));
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        List<List<TreeNode>> result = zigzag.traverse(root);
        for(List<TreeNode> item : result)
            for(TreeNode nodes : item)
                System.out.print(nodes.val + " ");
    }
}

