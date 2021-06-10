package algoexpert.veryHard;

/*
Non-Attacking Queens
Write a function that takes in a positive integer n and returns the number of nonattacking placements of n queens on an n x n chessboard.
A non-attacking placement is one where no queen can attack another queen in a single
turn. In other words, it's a placement where no queen can move to the same position as
another queen in a single turn.
In chess, queens can move any number of squares horizontally, vertically, or diagonally in
a single turn.
+--+--+--+--+
| |Q | | |
+--+--+--+--+
| | | |Q |
+--+--+--+--+
|Q | | | |
+--+--+--+--+
| | |Q | |
+--+--+--+--+
The chessboard above is an example of a non-attacking placement of 4 queens on a 4x4
chessboard. For reference, there are only 2 non-attacking placements of 4 queens on a
4x4 chessboard.
Sample Input
n = 4
Sample Output
2
 */

class NonAttackingQueens {
    public static void main(String[] args) {
        System.out.println((new NonAttackingQueens()).nonAttackingQueens(4));
    }
    // Lower Bound: O(n!) time | O(n) space - where n is the input number
    public int nonAttackingQueens(int n) {
        // Each index of `columnPlacements` represents a row of the chessboard,
        // and the value at each index is the column (on the relevant row) where
        // a queen is currently placed.
        int[] columnPlacements = new int[n];
        return getNumberOfNonAttackingQueenPlacements(0, columnPlacements, n);
    }
    public int getNumberOfNonAttackingQueenPlacements(int row, int[] columnPlacements, int boardSize) {
        if (row == boardSize)
            return 1;
        int validPlacements = 0;
        for (int col = 0; col < boardSize; col++) {
            if (isNonAttackingPlacement(row, col, columnPlacements)) {
                columnPlacements[row] = col;
                validPlacements +=
                        getNumberOfNonAttackingQueenPlacements(row + 1, columnPlacements, boardSize);
            }
        }
        return validPlacements;
    }
    // As `row` tends to `n`, this becomes an O(n)-time operation.
    public boolean isNonAttackingPlacement(int row, int col, int[] columnPlacements) {
        for (int previousRow = 0; previousRow < row; previousRow++) {
            int columnToCheck = columnPlacements[previousRow];
            boolean sameColumn = (columnToCheck == col);
            boolean onDiagonal = Math.abs(columnToCheck - col) == (row - previousRow);
            if (sameColumn || onDiagonal) {
                return false;
            }
        }
        return true;
    }
}

