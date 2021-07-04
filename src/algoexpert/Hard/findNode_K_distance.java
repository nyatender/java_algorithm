package algoexpert.Hard;

import java.util.*;

public class findNode_K_distance {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class Pair<U, V> {
        public final U first;
        public final V second;

        private Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    // O(n) time | O(n) space - where n is the number of nodes in the tree
    public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        HashMap<Integer, BinaryTree> nodesToParents = new HashMap<Integer, BinaryTree>();
        populateNodesToParents(tree, nodesToParents, null);
        BinaryTree targetNode = getNodeFromValue(target, tree, nodesToParents);
        return breadthFirstSearchForNodesDistanceK(targetNode, nodesToParents, k);
    }

    public ArrayList<Integer> breadthFirstSearchForNodesDistanceK(
            BinaryTree targetNode, HashMap<Integer, BinaryTree> nodesToParents, int k) {
        Queue<Pair<BinaryTree, Integer>> queue = new LinkedList<Pair<BinaryTree, Integer>>();
        queue.offer(new Pair<BinaryTree, Integer>(targetNode, 0));
        HashSet<Integer> seen = new HashSet<Integer>(targetNode.value);
        seen.add(targetNode.value);
        while (queue.size() > 0) {
            Pair<BinaryTree, Integer> vals = queue.poll();
            BinaryTree currentNode = vals.first;
            int distanceFromTarget = vals.second;

            if (distanceFromTarget == k) {
                ArrayList<Integer> nodeDistanceK = new ArrayList<Integer>();
                for (Pair<BinaryTree, Integer> pair : queue) {
                    nodeDistanceK.add(pair.first.value);
                }
                nodeDistanceK.add(currentNode.value);
                return nodeDistanceK;
            }
            List<BinaryTree> connectedNodes = new ArrayList<BinaryTree>();
            connectedNodes.add(currentNode.left);
            connectedNodes.add(currentNode.right);
            connectedNodes.add(nodesToParents.get(currentNode.value));
            for (BinaryTree node : connectedNodes) {
                if (node == null)
                    continue;
                if (seen.contains(node.value))
                    continue;
                seen.add(node.value);
                queue.add(new Pair<BinaryTree, Integer>(node, distanceFromTarget + 1));
            }
        }
        return new ArrayList<Integer>();
    }

    public BinaryTree getNodeFromValue(
            int value, BinaryTree tree, HashMap<Integer, BinaryTree> nodesToParents) {
        if (tree.value == value)
            return tree;
        BinaryTree nodeParent = nodesToParents.get(value);
        if (nodeParent.left != null && nodeParent.left.value == value)
            return nodeParent.left;
        return nodeParent.right;
    }

    public void populateNodesToParents(
            BinaryTree node, Map<Integer, BinaryTree> nodesToParents, BinaryTree parent) {
        if (node != null) {
            nodesToParents.put(node.value, parent);
            populateNodesToParents(node.left, nodesToParents, node);
            populateNodesToParents(node.right, nodesToParents, node);
        }
    }
}
