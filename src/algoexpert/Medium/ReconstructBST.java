package algoexpert.Medium;

import java.util.ArrayList;

public class ReconstructBST {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        // Write your code here.
        if(preOrderTraversalValues.size() == 0)
            return null;

        int currVal = preOrderTraversalValues.get(0);
        int endIndexOfLeftSubTree = preOrderTraversalValues.size();

        for(int i = 1; i < preOrderTraversalValues.size(); i++) {
            if(currVal <= preOrderTraversalValues.get(i)) {
                endIndexOfLeftSubTree = i;
                break;
            }
        }
        BST leftSubTree = reconstructBst((ArrayList<Integer>) preOrderTraversalValues.subList(1, endIndexOfLeftSubTree));
        BST rightSubTree = reconstructBst((ArrayList<Integer>) preOrderTraversalValues.subList(endIndexOfLeftSubTree, preOrderTraversalValues.size()));

        BST newNode = new BST(currVal);
        newNode.left = leftSubTree;
        newNode.right = rightSubTree;

        return newNode;

    }

}
