package Grokking_java_interview.TreeBreadthFirstSearch;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class ZigzagTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // TODO: Write your code here
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean level = true;
        while(!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (level) {
                    if (node.right != null)
                        queue.add(node.right);
                    if (node.left != null)
                        queue.add(node.left);
                } else {
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
            }
            level = !level;
            if(list.size() != 0)
                result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = ZigzagTraversal.traverse(root);
        System.out.println("Zigzag traversal: " + result);
    }
}
