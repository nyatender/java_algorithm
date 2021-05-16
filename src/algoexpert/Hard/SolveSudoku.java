package algoexpert.Hard;

import java.util.ArrayList;
import java.util.HashMap;

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
    }

    public ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
        // Write your code here.
        //HashMap<Integer, ArrayList<Integer>>sudoku = new HashMap<>();
        //HashMap<Integer, Integer[]> sudoku = new HashMap<>();
        final int size = 8;
        for(int i = 0; i < board.size(); i++) {
            for(int j = 0; j < board.get(0).size(); j++) {
                //sudoku.put(i, new HashMap<>())
            }

        }

        return new ArrayList<ArrayList<Integer>>();
    }
}
