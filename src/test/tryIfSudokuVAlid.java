package test;

public class tryIfSudokuVAlid {
    public static void main(String[] args) {
        char [][] board = { { '.','.','.','8','.','.','.','.','.'},
                            {'.','.','.','.','.','.','.','.','.'},
                            {'.','6','.','.','.','.','3','.','.'},
                            {'7','.','.','9','6','4','1','.','.'},
                            {'6','.','9','.','.','.','.','.','.'},
                            {'.','.','.','.','.','.','.','5','.'},
                            {'.','.','9','.','.','.','.','.','.'},
                            {'.','.','.','.','.','.','.','.','5'},
                            {'.','.','1','.','.','.','.','2','.'}};
        System.out.println((new tryIfSudokuVAlid()).isValidSudoku(board));
    }
    public boolean isValidSudoku(char[][] board) {
        return isValidSudokuUtils(board, 0, 0);
    }

    boolean isValidSudokuUtils(char[][] board, int r, int c) {

        int currRow = r;
        int currCol = c;

        if(currCol == board.length) {
            currRow++;
            currCol = 0;
            if(currRow == board.length)
                return true;
        }
        if(board[currRow][currCol] != '.') {
            return checkDuplicateDigits(board, currRow, currCol);
        }

        return isValidSudokuUtils(board, currRow, currCol+1);

    }
    boolean checkDuplicateDigits(char[][] board, int r, int c) {

        if(checkInAllThreeCell(board, r, c)) {
            if(isValidSudokuUtils(board, r, c+1)) {
                return true;
            }
        }

        return false;
    }

    boolean checkInAllThreeCell(char[][] board, int r, int c) {

        int val = board[r][c]-'0';
        int freq = 0;
        for(int i = 0; i < 9; i++) {
            if(board[i][r] == '.')
                continue;
            if(board[i][r]-'0' == val) {
                freq++;
                if(freq > 1)
                    return false;
            }
        }
        freq = 0;

        for(int i = 0; i < 9; i++) {
            if(board[i][c] == '.')
                continue;
            if(board[i][c]-'0' == val) {
                freq++;
            }
            if(freq > 1)
                return false;
        }
        freq = 0;
        int currRowCell = (r/3)*3;
        int currColCell = (c/3)*3;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[currRowCell+i][currColCell+j] == '.')
                    continue;
                if(board[currRowCell+i][currColCell+j]-'0' == val) {
                    freq++;
                }
                if(freq > 1)
                    return false;
            }
        }

        return true;
    }
}
