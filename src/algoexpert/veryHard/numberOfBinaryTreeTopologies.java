package algoexpert.veryHard;
/*
Number Of Binary Tree Topologies
Write a function that takes in a non-negative integer n and returns the number of
possible Binary Tree topologies that can be created with exactly n nodes.
A Binary Tree topology is defined as any Binary Tree configuration, irrespective of node
values. For instance, there exist only two Binary Tree topologies when n is equal to
2 : a root node with a left node, and a root node with a right node.
Note that when n is equal to 0 , there's one topology that can be created: the None
/ null node.
Sample Input
n = 3
Sample Output
5
 */
public class numberOfBinaryTreeTopologies {
    public static void main(String[] args) {
        System.out.println(numberOfBTreeTopologies(3));
    }
    public static int numberOfBTreeTopologies(int n) {
        // Write your code here.
        if(n == 0)
            return 1;

        int[] T = new int[n+1];
        T[0] = 1;
        T[1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                // lets 10, 11  n = 2;
                // if 10 is root then left side it have 0 and right side n - 1 = 2 - 1 = 1
                // if 11 is root then left side it have n - 1 and right side 0
                // total = 1 + 1 = 2
                T[i] += T[j]*T[i-j-1];
            }
        }

        return T[n];
    }
}
