package algoexpert.Hard;

import java.util.*;

public class findNode_K_distance {
    public static void main(String[] args) {

    }
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
    static class Pair<U, V>    {
        public final U first;
        public final V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    static ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        // Write your code here.
        HashMap<Integer, BinaryTree > nodeToParent = new HashMap<>();
        populateNodeToParent(nodeToParent, tree, null);
        BinaryTree targetNode = getTargetNode(nodeToParent, tree, target);
        if(targetNode == null)
            return new ArrayList<>();
        ArrayList<Integer> result = breathFirstSearch(nodeToParent,targetNode, k);

        return result;
    }
    static BinaryTree getTargetNode(HashMap<Integer, BinaryTree > nodeToParent, BinaryTree root, Integer target) {
        BinaryTree parent = nodeToParent.get(target);
        if(root.value == target)
            return root;

        if(parent == null)
            return null;

        if(parent.left != null && parent.left.value == target)
            return parent.left;

        return parent.right;
    }
    static void populateNodeToParent(HashMap<Integer, BinaryTree > nodeToParent, BinaryTree root, BinaryTree parentNode) {
        if(root == null)
            return;

        nodeToParent.put(root.value, parentNode);
        populateNodeToParent(nodeToParent, root.left, root);
        populateNodeToParent(nodeToParent, root.right, root);
    }
    static ArrayList<Integer> breathFirstSearch(HashMap<Integer, BinaryTree> nodeToparent, BinaryTree targetNode, Integer k ) {

        Queue<Pair<BinaryTree, Integer>> queue = new LinkedList<>();
        //BinaryTree nodeVal = nodeToparent.get(root.value);
        HashSet<Integer>seen =  new HashSet<>(targetNode.value);
        queue.offer(new Pair(targetNode, 0));
        int distanceKAway = 0;

        while(!queue.isEmpty()) {
            Pair<BinaryTree, Integer> pair = queue.poll();
            BinaryTree arr = pair.first;
            int dis = pair.second;

            if(dis == k) {

            }

        }

        return new ArrayList<>();
    }
}
