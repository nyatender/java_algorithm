package algoexpert.Medium;

import java.util.ArrayList;
import java.util.List;

public class spiralTravalsal {

    public static List<Integer> spiralTraverse(int[][] matrix) {
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;
        ArrayList<Integer> output = new ArrayList<>();
        int startRow = 0;
        int startCol = 0;

        while(startRow <= endRow && startCol <= endCol) {
            for(int c = startCol; c <= endCol; c++) {
                output.add(matrix[startRow][c]);
            }
            for(int r = startRow+1; r <= endRow; r++) {
                output.add(matrix[r][endCol]);
            }
            for(int c = endCol-1; c >= startCol; c--) {
                if(startRow == endRow)
                    break;
                output.add(matrix[endRow][c]);
            }
            for(int r = endRow-1; r > startRow; r--) {
                if(startCol == endCol)
                    break;
                output.add(matrix[r][startCol]);
            }
            startRow++;
            startCol++;
            endCol--;
            endRow--;
        }
        return output;
    }

    public static void main(String[] args) {
        int[][] matrix = {  {1,    2,   3,    4, 5},
                            {16,  17,  18,   19, 6},
                            {15,  24,  25,   20, 7},
                            {14,  23,  22,   21, 8},
                            {13,  12,  11,   10, 9}};
        //int[][] matrix = {{1, 2, 3, 4, 5}};
        //int[][] matrix = {{1},{2},{3},{4},{5}};

        List<Integer> result = spiralTraverse(matrix);
        for(int i = 0; i < result.size(); i++)
            System.out.print(result.get(i) + " ");
        //result.forEach(item -> System.out::println(item));
    }
}
