package algoexpert.veryHard;

import java.util.*;

/*
Flatten Binary Tree
    Write a function that takes in a Binary Tree, flattens it, and returns its leftmost node.
    A flattened Binary Tree is a structure that's nearly identical to a Doubly Linked List (except that
    nodes have left and right pointers instead of prev and next pointers), where nodes
    follow the original tree's left-to-right order.
    Note that if the input Binary Tree happens to be a valid Binary Search Tree, the nodes in the
    flattened tree will be sorted.
    The flattening should be done in place, meaning that the original data structure should be
    mutated (no new structure should be created).
    Each BinaryTree node has an integer value , a left child node, and a right child node.
    Children nodes can either be BinaryTree nodes themselves or None / null .
    Sample Input
    tree =    1
            /   \
           2     3
          / \   /
         4  5  6
           / \
          7   8
    Sample Output
    4 <-> 2 <-> 7 <-> 5 <-> 8 <-> 1 <-> 6 <-> 3 // the leftmost node with value 4
*/
public class flatterABinaryTree {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.right.left = new BinaryTree(6);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.left.right.left = new BinaryTree(7);
        root.left.right.right = new BinaryTree(8);

        BinaryTree result = flattenBinaryTree(root);
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.right;
        }
    }
    // O(n) time | O(n) space - where n is the number of nodes in the Binary Tree
    public static BinaryTree flattenBinaryTree(BinaryTree root) {
        List<BinaryTree> inOrderNodes = getNodesInOrder(root, new ArrayList<BinaryTree>());
        for (int i = 0; i < inOrderNodes.size() - 1; i++) {
            BinaryTree leftNode = inOrderNodes.get(i);
            BinaryTree rightNode = inOrderNodes.get(i + 1);
            leftNode.right = rightNode;
            rightNode.left = leftNode;
        }
        return inOrderNodes.get(0);
    }

    public static List<BinaryTree> getNodesInOrder(BinaryTree tree, List<BinaryTree> array) {
        if (tree != null) {
            getNodesInOrder(tree.left, array);
            array.add(tree);
            getNodesInOrder(tree.right, array);
        }
        return array;
    }

    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}

