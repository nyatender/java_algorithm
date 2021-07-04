package walMartPreparation;

import java.util.*;

public class RottenTomatos2 {

//https://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/


    public static void main(String[] args) {
        int[][] arr1 = { {2, 1, 0, 2, 1},
                         {1, 0, 1, 2, 1},
                         {1, 0, 0, 2, 1}};

        int[][] arr2 = { {2, 1, 0, 2, 1},
                         {0, 0, 1, 2, 1},
                         {1, 0, 0, 2, 1}};
        System.out.println(canRotAllTomatos(arr1));
        System.out.println(canRotAllTomatos(arr2));
    }
    static boolean canRotAllTomatos(int[][] arr) {
        if(arr.length == 0)
            return false;

        int R = arr.length;
        int C = arr[0].length;

        HashMap<String, Integer[]> graph = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0)
                    continue;
                String key = getString(i, j);
                if (arr[i][j] == 2) {
                    queue.add(key);
                }
                graph.put(key, new Integer[]{i, j});
            }
        }
        int noOfDays = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String key = queue.poll();
                Integer[] parentCord = graph.get(key);
                for (int[] dir : directions) {
                    int xCord = parentCord[0] + dir[0];
                    int yCord = parentCord[1] + dir[1];
                    if (isValid(xCord, yCord, R, C) &&
                            arr[xCord][yCord] == 1) {
                        arr[xCord][yCord] = arr[parentCord[0]][parentCord[1]] + 1;
                        String neighbourNodes = getString(xCord, yCord);
                        queue.add(neighbourNodes);
                    }
                }
            }
            if (!queue.isEmpty())
                noOfDays++;
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(arr[i][j] == 1)
                    return false;
            }
        }
        System.out.println(" No Of Days : " + noOfDays);
        return true;
    }
    static int[][] directions = {{1,0}, {-1,0},{0,1},{0,-1}};

    static boolean isValid(int i, int j, int R, int C) {
        return i < R && i >= 0 && j >= 0 && j < C;
    }
    static String getString(int i, int j) {
        return Integer.toString(i) + "to" + Integer.toString(j);
    }
}
