package algoexpert.Easy;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        // Write your code here.
        //SumVal sum = new SumVal(0, 0 );
        if(root == null)
            return  new ArrayList<>();

        ArrayList<Integer> sum = new ArrayList<Integer>();
        branchSumsUtils(root, 0, sum);
        return sum;
    }

    public static void branchSumsUtils(BinaryTree root, int sumSoFar,  ArrayList<Integer> sum) {
        // Write your code here.
        if(root.left == null && root.right == null ) {
            sum.add(sumSoFar+root.value);
            return;
        }

        sumSoFar += root.value;

        if(root.left != null)
            branchSumsUtils(root.left, sumSoFar, sum);

        if(root.right != null)
            branchSumsUtils(root.right, sumSoFar, sum);
    }
}

