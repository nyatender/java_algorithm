package algoexpert.Hard;

import java.util.*;

public class kthLargestInBST {
    public static void main(String[] args) {
        BST root = new BST(15);
        root.left = new BST(5);
        root.right = new BST(20);
        root.left.left = new BST(2);
        root.left.right = new BST(5);
        root.left.left.left = new BST(1);
        root.left.left.right = new BST(3);

        root.right.left = new BST(17);
        root.right.right = new BST(22);

        int k = 3;
        System.out.println(findKthLargestValueInBst(root, 3));
    }
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }
    public static int findKthLargestValueInBst(BST tree, int k) {
        // Write your code here.
        BST root = tree;
        Stack<BST> st = new Stack<BST>();
        //PriorityQueue<Integer> pq =new PriorityQueue<>((x, y) -> (y - x));
        ArrayList<Integer> pq = new ArrayList<>();
        st.push(root);
        while(!st.empty()) {
            while(root != null) {
                st.push(root);
                root = root.left;
            }
            if(!st.empty()) {
                BST t = st.pop();
                pq.add(t.value);
                root = t.right;
            }
        }
        return pq.get(pq.size() - k - 1);
    }
}
