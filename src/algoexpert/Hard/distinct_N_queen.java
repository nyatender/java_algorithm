package algoexpert.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class distinct_N_queen {
    public static void main(String[] args) {
        distinct_N_queen obj = new distinct_N_queen();
        System.out.println(obj.totalNQueens(1));
    }

    public int totalNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            Integer[] board = new Integer[n];
            Arrays.fill(board, -1);
            solveNQueensUtils(board, row, n);
        }
        return resultValues.size();
    }

    private ArrayList<Integer[]> resultValues = new ArrayList<>();

    public boolean solveNQueensUtils(Integer[] board, int r, int n) {
        if (n == 0)
            return true;

        if (n != 0 && r >= board.length)
            return false;

        for (int c = 0; c < board.length; c++) {
            if (isPossibleToPlace(board, r, c, n)) {
                board[r] = c;
                if (solveNQueensUtils(board, r + 1, n - 1)) {
                    Integer[] it = new Integer[board.length];
                    for (int i = 0; i < board.length; i++)
                        it[i] = board[i];
                    resultValues.add(it);
                }
                board[r] = -1;
            }
        }
        return false;
    }

    public boolean isPossibleToPlace(Integer[] board, int r, int c, int n) {
        for (int pre = 0; pre < r; pre++) {
            int currCol = board[pre];
            boolean isDiagonalPlacing = (Math.abs(pre - r) == Math.abs(currCol - c));
            if (currCol != -1 && (currCol == c || isDiagonalPlacing)) {
                return false;
            }
        }
        return true;
    }
}