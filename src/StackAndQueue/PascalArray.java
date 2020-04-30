package StackAndQueue;

import java.util.Vector;

public class PascalArray {

    public static void buildPascalArrayRowRecUtils(int line, int row, int arr[][])
    {
        if(row < 0)
            return;
        buildPascalArrayRowRecUtils(line, row-1, arr);
        if(row == 0 || row == line)
        {
            arr[line][row] = 1;
            System.out.print(arr[line][row] + " ");
        }
        else if(row < line) {
            arr[line][row] = arr[line - 1][row - 1] + arr[line - 1][row];
            System.out.print(arr[line][row] + " ");
        }
    }
    public static void buildPascalArrayRecUtils(int line, int row, int arr[][])
    {
        if(line < 0 )
            return;

        buildPascalArrayRecUtils(line-1, row, arr);
        System.out.println();
        buildPascalArrayRowRecUtils(line, row, arr);
    }
    public static void buildPascalArrayRecursion(int n)
    {
        int arr[][] = new int[n][n];
        buildPascalArrayRecUtils(n-1, n-1, arr);
    }
    public static void buildPascalArray(int n)
    {
        int i = 0;
        int arr[][] = new int[n][n];
        while(i < n)
        {
            for(int j = 0 ; j <= i; j++)
            {
                if(j == 0 || j == i)
                    arr[i][j] = 1;
                else
                {
                    arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
            i++;
        }
    }
    public static void main(String[] args)
    {
        //buildPascalArray(5);
        buildPascalArrayRecursion(5);
    }
}
