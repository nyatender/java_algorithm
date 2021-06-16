package test;

public class validSoduku {
    public static void main(String[] args) {
        char [][] board = {{'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'}};
/*
5 3 4 6 7 8 9 1 2
6 7 2 1 9 5 3 4 8
1 9 8 3 4 2 5 6 7
8 5 9 7 6 1 4 2 3
4 2 6 8 5 3 7 9 1
7 1 3 9 2 4 8 5 6
9 6 1 5 3 7 2 8 4
2 8 7 4 1 9 6 3 5
3 4 5 2 8 6 1 7 9
 */
        char [][] board1 = (new validSoduku()).solveSudoku(board);
        for(int i = 0; i < board1.length; i++) {
            for(int j = 0; j < board1.length; j++) {
                System.out.print(board1[i][j] + " ");
            }
            System.out.println();
        }
    }
    public char [][]  solveSudoku(char[][] board) {
        solveSudokoUtils(board, 0, 0);
        return board;
    }
    boolean solveSudokoUtils(char[][] board, int r, int c) {
        int currRow = r;
        int currCol = c;

        if(currCol == board[0].length) {
            currRow = currRow+1;
            currCol = 0;
            if(currRow == board.length)
                return true;
        }

        if(board[currRow][currCol] == '.') {
            return fillTheBlanckSpot(board, currRow, currCol);
        }

        return solveSudokoUtils(board, currRow, currCol+1);
    }
    boolean fillTheBlanckSpot(char[][] board, int r, int c) {

        int base = '0';
        for(int i = 1; i < 10; i++) {
            if(isValidNumber(board, r, c, i)) {
                char key = (char)(base + i);
                board[r][c] = key;
                if(solveSudokoUtils(board, r, c + 1))
                    return true;
            }
        }
        board[r][c] = '.';
        return false;
    }
    public boolean isValidNumber(char[][] board, int r, int c, int val) {

        boolean isValidRow = true;
        boolean isValidCol = true;

        int base = '0';
        for(int i = 0; i < 9; i++) {
            if(board[r][i] != '.' && val == (int)board[r][i] - base) {
                isValidRow = false;
                break;
            }
        }
        if(isValidRow == false)
            return false;
        for(int i = 0; i < 9; i++) {
            if(val == (int)board[i][c] - base) {
                isValidCol = false;
                break;
            }
        }
        if(isValidCol == false)
            return false;

        int sRow = (r/3)*3;
        int sCol = (c/3)*3;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                int row = i+sRow;
                int col = j+sCol;
                if(board[row][col] != '.' && val == board[row][col] - '0') {
                    return false;
                }
            }
        }
        return true;
    }
}