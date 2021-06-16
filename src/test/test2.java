package test;

import algoexpert.veryHard.rightSiblingTree;

import java.util.*;

public class test2 {
    // Function to print all distinct palindrome
    // sub-strings of s
    private final int CAPACITY;
    test2(int capacity) {
        CAPACITY = 10;
        HashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(CAPACITY, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest)
            {
                return size() > CAPACITY;
            }
        };
    }
    public static void main(String args[]) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);

        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);

        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);

        root.left.left.left = new BinaryTree(8);
        root.left.left.right = new BinaryTree(9);

        root.left.right.right = new BinaryTree(10);

        root.right.left.left = new BinaryTree(11);
        root.right.left.left.left = new BinaryTree(14);

        root.right.right.left = new BinaryTree(12);
        root.right.right.right = new BinaryTree(13);

        HashMap<Integer, ArrayList<Integer>> res = new HashMap<>();
        rightSiblingTree1(root, null, true);

        HashMap<Integer, Integer> v = new LinkedHashMap<>();

    }

    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
    public static void rightSiblingTree1(BinaryTree root, BinaryTree parent, boolean isleftChild) {

        if(root == null)
            return;

        BinaryTree left = root.left;
        BinaryTree right = root.right;

        rightSiblingTree1(left, root, true);

        if(parent == null) {
            root.right = null;
        }
        else if(isleftChild == true) {
            root.right = parent.right;
        }
        else {
            if(parent.right == null)
                root.right = null;
             else
                root.right = parent.right.left;
        }
        rightSiblingTree1(right, root, false);
    }

}