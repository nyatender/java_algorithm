package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeBreathFirstSearch {
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class RightViewTree {
    public static List<TreeNode> traverse(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null)
            return result;
        // TODO: Write your code here
        Queue<TreeNode> Q = new LinkedList<>();
        result.add(root);
        Q.offer(root);
        Q.offer(null);
        while (!Q.isEmpty()) {
            TreeNode node = Q.poll();
            TreeNode preNode = null;
            while (node != null) {
                if (node.left != null) {
                    Q.offer(node.left);
                    preNode = node.left;
                }
                if (node.right != null) {
                    Q.offer(node.right);
                    preNode = node.right;
                }
                node = Q.poll();
            }
            if (!Q.isEmpty()) {
                result.add(preNode);
                Q.offer(null);
            }
        }
        return result;
    }
}