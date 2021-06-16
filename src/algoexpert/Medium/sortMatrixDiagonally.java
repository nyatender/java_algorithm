package algoexpert.Medium;

//https://leetcode.com/problems/sort-the-matrix-diagonally/

public class sortMatrixDiagonally {
    public static void main(String[] args) {
       int[][] mat = {{3, 3, 1, 1},
                      {2, 2, 1, 2},
                      {1, 1, 1, 2}};
       // O/P
//        [
//         [1,1,1,1],
//         [1,2,2,2],
//         [1,2,3,3]
//        ]
        int row=mat.length;
        int col=mat[0].length;
       int[][] result = diagonalSort(mat);
        for(int i=0;i<row;i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] diagonalSort(int[][] mat) {

        int row=mat.length;
        int col=mat[0].length;
        for(int i=0;i<row;i++) {

            for(int j=0;j<col;j++){

                for(int r=i+1,c=j+1;r<row && c<col;r++,c++){

                    if(mat[i][j]>mat[r][c]){
                        // Swap the value
                        int temp=mat[i][j];
                        mat[i][j]=mat[r][c];
                        mat[r][c]=temp;
                    }
                }
            }
        }
        return mat;
    }

}
