package algoexpert.veryHard;

import java.util.ArrayList;
import java.util.HashMap;

public class rightSiblingTree {

    public static BinaryTree rightSiblingTree(BinaryTree root) {
        // Write your code here.
        if(root == null)
            return null;
        HashMap<Integer, ArrayList<BinaryTree>> mapRightSiblings = new HashMap<>();
        //rightSiblingTreeUtils(root.left, root.right);
        for(ArrayList<BinaryTree> entry : mapRightSiblings.values()) {
            for(BinaryTree list : entry) {
                if(list != null)
                    list.right = null;
            }
        }
        return root;
    }
    public static void rightSiblingTreeUtils(BinaryTree root, int key, HashMap<Integer, ArrayList<BinaryTree>> mapRightSiblings) {
        // Write your code here.
        ArrayList<BinaryTree> list = mapRightSiblings.getOrDefault(key, new ArrayList<BinaryTree>());
        if(root == null) {
            list.add(null);
            return;
        }
        list.add(root);

        rightSiblingTreeUtils(root.left, key+ 1, mapRightSiblings);
        rightSiblingTreeUtils(root.right, key+ 1, mapRightSiblings);
    }
    // This is the class of the input root. Do not edit it.
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}