package test;

import java.util.ArrayList;
import java.util.List;

public class maximalSquares {
    public static void main(String[] args) {
        char[][] matrix = { {'1', '0', '1', '0', '0'},
                            {'1', '0', '1', '1', '1'},
                            {'1', '1', '1', '1', '1'},
                            {'1', '0', '0', '1', '0'}
                         };
      //  char[][] matrix = { {'0', '1'} };
        System.out.println(maximalSquare(matrix));
    }
    static public int maximalSquare(char[][] matrix) {
        if(matrix == null)
            return 0;

        int[][] table = new int[matrix.length+1][matrix[0].length+1];

        int maximim = 0;
        int len = 0;
        int row = 0;
        int col = 0;
        for(int i = 1; i < table.length; i++ ) {
            for(int j = 1; j < table[0].length; j++ ) {
                if(matrix[i-1][j-1] == '1') {
                    int minVal = Math.min(table[i-1][j], table[i][j-1]);
                    minVal = Math.min(table[i-1][j-1], minVal);
                    table[i][j] = minVal + 1;
                    if(maximim < table[i][j]) {
                        maximim = table[i][j];
                        row = i - 1;
                        col = j - 1;
                    }
                }
            }
        }
        int count = 0;
        row -= maximim;
        col -= maximim;
        List<Character> res = new ArrayList<>();
        int rRow = row;
        int dCol = col;

        int tRow = row;
        int tCol = col;
        while(maximim != count) {
            res.add(matrix[rRow][dCol- count]);
            res.add(matrix[rRow- count][dCol]);
            res.add(matrix[tRow][tCol]);
            tRow--;
            tCol--;
        }

        return maximim*maximim;
    }
}
