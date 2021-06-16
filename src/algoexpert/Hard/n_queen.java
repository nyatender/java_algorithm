package algoexpert.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 */
public class n_queen {
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> result = solveNQueens(4);
        result.forEach(i -> System.out.println(i));
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        for(int row = 0; row < n; row++) {
            Integer[] board = new Integer[n];
            Arrays.fill(board, -1);
            if(solveNQueensUtils(board, row,  n)) {
                //result.add(intArrayToArrayList(board));
            }
        }
       for(Integer[] i : resultValues) {
           result.add(intArrayToArrayList(i));
       }
        return result;
    }
    public static ArrayList<String> intArrayToArrayList(Integer[] arr) {
        ArrayList<String> res = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            StringBuilder item = new StringBuilder();
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] != -1 && arr[i] == j) {
                    item.append("Q");
                    continue;
                }
                item.append(".");
            }
            res.add(item.toString());
        }
        return res;
    }
    static private ArrayList<Integer[]> resultValues = new ArrayList<>();
    public static boolean solveNQueensUtils(Integer[] board, int r, int n) {
        if(n == 0 )
            return true;
        if(n != 0 && r >= board.length)
            return false;

        for (int c = 0; c < board.length; c++) {
            if (isPossibleToPlace(board, r, c, n)) {
                board[r] = c;
                if (solveNQueensUtils(board, r + 1, n - 1)) {
                    Integer[] it = new Integer[board.length];
                    for(int i = 0; i < board.length; i++)
                        it[i] = board[i];
                    resultValues.add(it);
                }
                board[r] = -1;
            }
        }
        return false;
    }
    public static boolean isPossibleToPlace(Integer[] board, int r, int c, int n) {
        for(int pre = 0; pre < r; pre++) {
            int currCol = board[pre];
            boolean isDiagonalPlacing = (Math.abs(pre-r) == Math.abs(currCol-c));
            if(currCol != -1 && (currCol == c || isDiagonalPlacing)) {
                return false;
            }
        }
        return true;
    }
}
