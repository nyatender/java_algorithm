package algoexpert.veryHard;

import java.util.ArrayList;
import java.util.HashMap;
/*
Right Sibling Tree
Write a function that takes in a Binary Tree, transforms it into a Right Sibling Tree, and returns its
root.
A Right Sibling Tree is obtained by making every node in a Binary Tree have its right property
point to its right sibling instead of its right child. A node's right sibling is the node immediately to
its right on the same level or None / null if there is no node immediately to its right.
Note that once the transformation is complete, some nodes might no longer have a node
pointing to them. For example, in the sample output below, the node with value 10 no longer
has any inbound pointers and is effectively unreachable.
The transformation should be done in place, meaning that the original data structure should be
mutated (no new structure should be created).
Each BinaryTree node has an integer value , a left child node, and a right child
node. Children nodes can either be BinaryTree nodes themselves or None / null .
Sample Input
tree =               1
                /           \
               2             3
             /  \           /  \
            4    5         6    7
          /   \    \     /     /  \
         8     9    10  11    12   13
                       /
                      14
Sample Output
                 1 // the root node with value 1
               /
              2-----------3
            /           /
           4-----5-----6-------7
          /           /       /
        8---9       10-11   12-13 // the node with value 10 no longer has a node pointing
                   /
                 14

 */
public class rightSiblingTree {

    public static void main(String[] args) {
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

        BinaryTree res = rightSiblingTree(root);
        while(res != null) {
            BinaryTree right = res.right;
            System.out.print(res.value + " ");
            while(right != null) {
                System.out.print(right.value + " ");
                right = right.right;
            }
            System.out.println();
            res = res.left;
        }
    }

        // O(n) time | O(d) space - where n is the number of nodes in
        // the Binary Tree and d is the depth (height) of the Binary Tree
        public static BinaryTree rightSiblingTree(BinaryTree root) {
            mutate(root, null, false);
            return root;
        }
        public static void mutate(BinaryTree node, BinaryTree parent, boolean isLeftChild) {
            if (node == null)
                return;

            var left = node.left;
            var right = node.right;
            mutate(left, node, true);

            if (parent == null) {
                node.right = null;
            } else if (isLeftChild) {
                node.right = parent.right;
            } else {
                if (parent.right == null) {
                    node.right = null;
                } else {
                    node.right = parent.right.left;
                }
            }
            mutate(right, node, false);
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