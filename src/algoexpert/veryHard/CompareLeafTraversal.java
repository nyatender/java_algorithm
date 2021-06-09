package algoexpert.veryHard;

import java.util.ArrayList;
import java.util.List;

/*
Compare Leaf Traversal
Write a function that takes in the root nodes of two Binary Trees and returns a boolean
representing whether their leaf traversals are the same.
The leaf traversal of a Binary Tree traverses only its leaf nodes from left to right. A leaf node is any
node that has no left or right children.
For example, the leaf traversal of the following Binary Tree is 1, 3, 2 .
 4
 / \
1 5
 / \
 3 2
Each BinaryTree node has an integer value , a left child node, and a right child node.
Children nodes can either be BinaryTree nodes themselves or None / null .
Sample Input
tree1 = 1
 / \
 2 3
 / \ \
 4 5 6
 / \
 7 8
tree2 = 1
 / \
 2 3
 / \ \
 4 7 5
 / \
 8 6
Sample Output
true

 */
public class CompareLeafTraversal {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public boolean compareLeafTraversal(BinaryTree tree1, BinaryTree tree2) {
        // Write your code here.
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        compareLeafTraversalUtils(tree1, list1);
        compareLeafTraversalUtils(tree2, list2);

        if(list1.size() != list2.size())
            return false;

        for(int i =0; i < list1.size(); i++) {
            if(list1.get(i) != list2.get(i))
                return false;
        }
        return true;
    }
    public void compareLeafTraversalUtils(BinaryTree tree, List<Integer> result) {
        // Write your code here.
        if(tree == null)
            return;

        if(tree.left == null && tree.right == null) {
            result.add(tree.value);
            return;
        }
        compareLeafTraversalUtils(tree.left, result);
        compareLeafTraversalUtils(tree.right, result);
    }
}
