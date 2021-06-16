package algoexpert.veryHard;
import java.util.*;
/*
All Kinds Of Node Depths
The distance between a node in a Binary Tree and the tree's root is called the node's depth.
Write a function that takes in a Binary Tree and returns the sum of all of its subtrees' nodes'
depths.
Each BinaryTree node has an integer value , a left child node, and a right child node.
Children nodes can either be BinaryTree nodes themselves or None / null .
Sample Input
tree = 1
 / \
 2 3
 / \ / \
 4 5 6 7
 / \
8 9
Sample Output
26
// The sum of the root tree's node depths is 16.
// The sum of the tree rooted at 2's node depths is 6.
// The sum of the tree rooted at 3's node depths is 2.
// The sum of the tree rooted at 4's node depths is 2.
// Summing all of these sums yields 26.

 */
public class allKindsOfNodeDepths {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.left.left.left = new BinaryTree(8);
        root.left.left.right = new BinaryTree(9);

        System.out.println(allKindsOfNodeDepths(root));
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
        // Average case: when the tree is balanced
        // O(nlog(n)) time | O(h) space - where n is the number of nodes in
        // the Binary Tree and h is the height of the Binary Tree
        public static int allKindsOfNodeDepths(BinaryTree root) {
            int sumOfAllDepths = 0;
            List<BinaryTree> stack = new ArrayList<BinaryTree>();
            stack.add(root);
            while (stack.size() > 0) {
                BinaryTree node = stack.remove(stack.size() - 1);
                if (node == null) continue;
                sumOfAllDepths += nodeDepths(node, 0);
                stack.add(node.left);
                stack.add(node.right);
            }
            return sumOfAllDepths;
        }
        public static int nodeDepths(BinaryTree node, int depth) {
            if (node == null)
                return 0;
            return depth + nodeDepths(node.left, depth + 1) + nodeDepths(node.right, depth + 1);
        }

        //Sol2====================================================================
        public static int allKindsOfNodeDepthsSol2(BinaryTree root) {
            if (root == null) return 0;
            return allKindsOfNodeDepths(root.left) + allKindsOfNodeDepths(root.right) + nodeDepthsSol2(root, 0);
        }
        public static int nodeDepthsSol2(BinaryTree node, int depth) {
            if (node == null)
                return 0;
            return depth + nodeDepthsSol2(node.left, depth + 1) + nodeDepthsSol2(node.right, depth+1);
        }

        //Sol3====================================================================
        public static int allKindsOfNodeDepthsSol3(BinaryTree root) {
            Map<BinaryTree, Integer> nodeCounts = new HashMap<BinaryTree, Integer>();
            Map<BinaryTree, Integer> nodeDepths = new HashMap<BinaryTree, Integer>();
            addNodeCounts(root, nodeCounts);
            addNodeDepths(root, nodeDepths, nodeCounts);
            return sumAllNodeDepthsSol3(root, nodeDepths);
        }
        public static int sumAllNodeDepthsSol3(BinaryTree node, Map<BinaryTree, Integer> nodeDepths) {
         if (node == null)
             return 0;
         return sumAllNodeDepthsSol3(node.left, nodeDepths)
                 + sumAllNodeDepthsSol3(node.right, nodeDepths)
                 + nodeDepths.get(node);
        }
    public static void addNodeDepths(
            BinaryTree node, Map<BinaryTree, Integer> nodeDepths, Map<BinaryTree, Integer> nodeCounts) {
            nodeDepths.put(node, 0);
        if (node.left != null) {
            addNodeDepths(node.left, nodeDepths, nodeCounts);
            nodeDepths.put(
                    node, nodeDepths.get(node) + nodeDepths.get(node.left) + nodeCounts.get(node.left));
        }
         if (node.right != null) {
             addNodeDepths(node.right, nodeDepths, nodeCounts);
             nodeDepths.put(
                     node, nodeDepths.get(node) + nodeDepths.get(node.right) + nodeCounts.get(node.right));
         }
    }
    public static void addNodeCounts(BinaryTree node, Map<BinaryTree, Integer> nodeCounts) {
        nodeCounts.put(node, 1);
        if (node.left != null) {
            addNodeCounts(node.left, nodeCounts);
            nodeCounts.put(node, nodeCounts.get(node) + nodeCounts.get(node.left));
        }
        if (node.right != null) {
            addNodeCounts(node.right, nodeCounts);
            nodeCounts.put(node, nodeCounts.get(node) + nodeCounts.get(node.right));
        }
    }

}