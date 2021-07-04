package algoexpert.Medium;

import java.util.Arrays;

/*
Number Of Ways To Traverse Graph
You're given two positive integers representing the width and height of a grid-shaped,
rectangular graph. Write a function that returns the number of ways to reach the bottom right
corner of the graph when starting at the top left corner. Each move you take must either go
down or right. In other words, you can never move up or left in the graph.
For example, given the graph illustrated below, with width = 2 and height = 3 , there are
three ways to reach the bottom right corner when starting at the top left corner:
 _ _
|_|_|
|_|_|
|_|_|
1. Down, Down, Right
2. Right, Down, Down
3. Down, Right, Down
Note: you may assume that width * height >= 2 . In other words, the graph will never be a
1x1 grid.
Sample Input
width = 4
height = 3
Sample Output
10
 */
public class NoOfWaysToTraverseGraph {
    public static void main(String[] args) {
        System.out.println(numberOfWaysToTraverseGraph(4,3));
    }
    static public int numberOfWaysToTraverseGraph(int width, int height) {
        // Write your code here.
        int[][] matrix = new int[height][width];

        for(int i = 0; i < height; i++)
            Arrays.fill(matrix[i], 0);

        for(int i = 1; i < width; i++)
            matrix[0][i] = 1;

        for(int i = 1; i < height; i++)
            matrix[i][0] = 1;

        for(int i =1; i < height; i++) {
            for(int j = 1; j < width; j++) {
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
            }
        }

        return matrix[height-1][width-1];
    }
}

