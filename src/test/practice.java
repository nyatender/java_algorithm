package test;

import javax.swing.*;
import java.util.*;

public class practice {
    public static void main(String[] args) {
       // String input = "aabcaa";
        String bigString = "abcdefghijklmnopqrstuvwxyz";
        String smallString[] = {"abc", "mnopqr", "wyz", "no", "e", "tuuv"};
      //  multiStringSearch(bigString, smallString).forEach(item -> System.out.println(item));
        //int[][] matrix = {{1,    2,   3,    4, 5}};
//        int[][] matrix = {{1,    2,   3,    4, 5},
//                          {16,  17,  18,   19, 6},
//                          {15,  24,  25,   20, 7},
//                          {14,  23,  22,   21, 8},
//                          {13,  12,  11,   10, 9}};
        int[][] matrix = {{1, 3, 4,  10},
                          {2, 5, 9,  11},
                          {6, 8, 12, 15},
                          {7, 13, 14,16}};
        //ArrayList<Integer> result = spiralTraversal(matrix);
        ArrayList<Integer> result = zigzagTraversal(matrix);
        result.forEach(i -> System.out.print(i + " "));
    }

    public static ArrayList<Integer> zigzagTraversal(int[][] matrix) {

        ArrayList<Integer> output = new ArrayList<>();

        int row = 0;
        int col = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length -1;
        boolean isDown = true;
        while(row <= endRow && col <= endCol) {
            output.add(matrix[row][col]);
            if(isDown == true) {
                if(col == 0 || row == endRow) {
                    isDown = false;
                    if(col == 0) {
                        row++;
                    }
                    else
                        col++;
                }
                else {
                    row++;
                    col--;
                }
            }
            else {
                if(col == endCol || row == 0) {
                    isDown = true;
                    if(col == endCol) {
                        row++;
                    }
                    else
                        col++;
                }
                else {
                    row--;
                    col++;
                }
            }
        }
        return output;
    }
    public static ArrayList<Integer> spiralTraversal(int[][] matrix) {

        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;
        ArrayList<Integer> output = new ArrayList<>();
        int startRow = 0;
        int startCol = 0;

        while(startRow <= endRow && startCol <= endCol) {
            for(int c = startCol; c <= endCol; c++) {
                output.add(matrix[startRow][c]);
            }
            for(int r = startRow+1; r <= endRow; r++) {
                output.add(matrix[r][endCol]);
            }
            for(int c = endCol-1; c >= startCol; c--) {
                if(startRow == endRow)
                    break;
                output.add(matrix[endRow][c]);
            }
            for(int r = endRow-1; r > startRow; r--) {
                if(startCol == endCol)
                    break;
                output.add(matrix[r][startCol]);
            }
            startRow++;
            startCol++;
            endCol--;
            endRow--;
        }
        return output;
    }

    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
        Boolean[] result = new Boolean[smallStrings.length];
        Arrays.fill(result, false);
        Trie root = new Trie();
        int i = 0;
        for(String str : smallStrings) {
            root.insert(str, i);
            i++;
        }
        for(int j = 1; j < bigString.length(); j++) {
            for (int k = 0; k < j; k++) {
                int index = root.find(bigString.substring(k, j));
                if(index != -1)
                    result[index] = true;
            }
        }
        return new ArrayList<Boolean>(Arrays.asList(result));
    }
    static class Trie {
        HashMap<Character, Trie> children;
        String string = null;
        int index = -1;
        Trie() {
            children = new HashMap<>();
        }
        void insert(String str, int index) {
            Trie temp = this;
            for(int i = 0 ; i < str.length(); i++) {
                char key = str.charAt(i);
                if(!temp.children.containsKey(key)) {
                    temp.children.put(key, new Trie());
                    temp = temp.children.get(key);
                }
                else {
                    temp = temp.children.get(key);
                }
            }
            temp.string = str;
            temp.index = index;
        }
        int find(String str) {
            Trie temp = this;
            for(int i = 0 ; i < str.length(); i++) {
                char key = str.charAt(i);
                if(!temp.children.containsKey(key)) {
                    return -1;
                }
                else {
                    temp = temp.children.get(key);
                }
            }
            return temp.index;
        }
    }
}
