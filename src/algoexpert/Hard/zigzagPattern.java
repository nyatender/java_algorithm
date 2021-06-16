package algoexpert.Hard;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class zigzagPattern {
    public static void main(String[] args) {
        List<List<Integer>> array = new ArrayList<>();
        array.add(Arrays.asList(1, 3, 4, 10));
        array.add(Arrays.asList(2, 5, 9, 11));
        array.add(Arrays.asList(6, 8, 12, 15));
        array.add(Arrays.asList(7, 13, 14, 16));
        //Integer [][]list = (Integer[][])array.toArray();
        Integer[][] matrix = new Integer[array.size()][];
        for (int i = 0; i < array.size(); i++) {
            List<Integer> row = array.get(i);
            matrix[i] = row.toArray(new Integer[row.size()]);
        }
        for(int i = 0; i < matrix.length; i++) {
            for(int c = 0; c < matrix[0].length; c++) {
                System.out.print(matrix[i][c] + " ");
            }
            System.out.println();
        }
        int j = 0;
       // zigzagTraverse(array).forEach(val -> System.out.print(val + " "));
    }
    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        // Write your code here.
        ArrayList<Integer> result = new ArrayList<Integer>();
        int R = array.size() -1;
        int C = array.get(0).size()-1;

        int row = 0;
        int col = 0;

        boolean isGoingDown = true;
        while(isOutOfBound(row, col, R, C)) {
            result.add(array.get(row).get(col));
            if(isGoingDown) {
                if(col == 0 || row == R) {
                    isGoingDown = false;
                    if(row == R) {
                        col++;
                    }
                    else {
                        row++;
                    }
                }
                else {
                    row++;
                    col--;
                }
            }
            else {
                if (row == 0 || col == C) {
                    isGoingDown = true;
                    if (col == C) {
                        row++;
                    } else {
                        col++;
                    }
                } else {
                    row--;
                    col++;
                }
            }
        }

        return result;
    }
    public static boolean isOutOfBound(int row, int col, int R, int C) {
        return row <= R && col <= C;
    }
}
