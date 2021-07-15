package algoexpert.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SolveSudoku {
    public static void main(String[] args) {
        int[][] board = {
                {7, 8, 0, 4, 0, 0, 1, 2, 0},
                {6, 0, 0, 0, 7, 5, 0, 0, 9},
                {0, 0, 0, 6, 0, 1, 0, 7, 8},
                {0, 0, 7, 0, 4, 0, 2, 6, 0},
                {0, 0, 1, 0, 5, 0, 9, 3, 0},
                {9, 0, 4, 0, 6, 0, 0, 0, 5},
                {0, 7, 0, 3, 0, 0, 0, 1, 2},
                {1, 2, 0, 0, 0, 7, 4, 0, 0},
                {0, 4, 9, 2, 0, 6, 0, 0, 7},
        };
        List<List<Integer>> b = new ArrayList<>();
        b.add(Arrays.asList(7, 8, 0, 4, 0, 0, 1, 2, 0));
        b.add(Arrays.asList(6, 0, 0, 0, 7, 5, 0, 0, 9));
        b.add(Arrays.asList(0, 0, 0, 6, 0, 1, 0, 7, 8));
        b.add(Arrays.asList(0, 0, 7, 0, 4, 0, 2, 6, 0));
        b.add(Arrays.asList(0, 0, 1, 0, 5, 0, 9, 3, 0));
        b.add(Arrays.asList(9, 0, 4, 0, 6, 0, 0, 0, 5));
        b.add(Arrays.asList(0, 7, 0, 3, 0, 0, 0, 1, 2));
        b.add(Arrays.asList(1, 2, 0, 0, 0, 7, 4, 0, 0));
        b.add(Arrays.asList(0, 4, 9, 2, 0, 6, 0, 0, 7));

        //(new SolveSudoku()).solveSudoku(b);
    }

    // O(1) time | O(1) space - assuming a 9x9 input board
    public ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
        solvePartialSudoku(0, 0, board);
        return board;
    }

    public boolean solvePartialSudoku(int row, int col, ArrayList<ArrayList<Integer>> board) {
        int currentRow = row;
        int currentCol = col;
        if (currentCol == board.get(currentRow).size()) {
            currentRow += 1;
            currentCol = 0;
            if (currentRow == board.size()) {
                return true; // board is completed
            }
        }
        if (board.get(currentRow).get(currentCol) == 0) {
            return tryDigitsAtPosition(currentRow, currentCol, board);
        }
        return solvePartialSudoku(currentRow, currentCol + 1, board);
    }

    public boolean tryDigitsAtPosition(int row, int col, ArrayList<ArrayList<Integer>> board) {
        for (int digit = 1; digit < 10; digit++) {
            if (isValidAtPosition(digit, row, col, board)) {
                board.get(row).set(col, digit);
                if (solvePartialSudoku(row, col + 1, board)) {
                    return true;
                }
            }
        }
        //backtrack
        board.get(row).set(col, 0);
        return false;
    }

    public boolean isValidAtPosition(
            int value, int row, int col, ArrayList<ArrayList<Integer>> board) {
        boolean rowIsValid = !board.get(row).contains(value);
        boolean columnIsValid = true;
        for (int r = 0; r < board.size(); r++) {
            if (board.get(r).get(col) == value)
                columnIsValid = false;
        }
        if (!rowIsValid || !columnIsValid) {
            return false;
        }
        // Check subgrid constraints
        int subgridRowStart = (row / 3) * 3;
        int subgridColStart = (col / 3) * 3;
        for (int rowIdx = 0; rowIdx < 3; rowIdx++) {
            for (int colIdx = 0; colIdx < 3; colIdx++) {
                int rowToCheck = subgridRowStart + rowIdx;
                int colToCheck = subgridColStart + colIdx;
                int existingValue = board.get(rowToCheck).get(colToCheck);
                if (existingValue == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
