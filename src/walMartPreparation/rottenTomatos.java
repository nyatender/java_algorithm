package walMartPreparation;

//https://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/

import java.util.*;

public class rottenTomatos {
    public static void main(String[] args) {
//        int[][] arr = { {2, 1, 0, 2, 1},
//                        {1, 0, 1, 2, 1},
//                        {1, 0, 0, 2, 1}};
        int[][] arr = { {2, 1, 0, 2, 1},
                        {0, 0, 1, 2, 1},
                        {1, 0, 0, 2, 1}};
        System.out.println(canRotAllTomatos(arr));
    }
    static HashMap<String, Integer> inDegree = new HashMap<>();
    static HashMap<String, ArrayList<Integer[]>> graph = new HashMap<>();
    static boolean canRotAllTomatos(int[][] arr) {

        HashSet<String> visited = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 0)
                    continue;
                String key = getString(i, j);
                graph.put(key, new ArrayList<>());
                inDegree.put(key, arr[i][j]);
            }
        }
        int emptyCells = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                String key = getString(i,j);
                if(!visited.contains(key)) {
                    if(arr[i][j] == 2) {
                        fillGraph(arr, visited, i, j, arr.length, arr[0].length);
                    }
                    else if(arr[i][j] == 0)
                        emptyCells++;
                }
            }
        }
        System.out.println("emptyCells size = " + emptyCells);
        Queue<String> queue = new LinkedList<>();
        for(Map.Entry<String, Integer> entry : inDegree.entrySet()) {
            if(entry.getValue() == 2)
                queue.add(entry.getKey());
        }
        System.out.println("graph size = " + graph.size());
        System.out.println("queue size = " + queue.size());
        int count = 0;
        /*
                int[][] arr = { {2, 1, 0, 2, 1},
                                {1, 0, 1, 2, 1},
                                {1, 0, 0, 2, 1}};
         */
        int noOfDays = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            noOfDays++;
            for(int i = 0; i < size; i++) {
                count++;
                String key = queue.poll();
                ArrayList<Integer[]> values = graph.get(key);
                for (Integer[] val : values) {
                    String newKey = getString(val[0], val[1]);
                    if (inDegree.get(newKey) == 2)
                        continue;

                    inDegree.put(newKey, inDegree.get(newKey) + 1);
                    if (inDegree.get(newKey) == 2) {
                        queue.add(newKey);
                        fillGraph(arr, visited, val[0], val[1], arr.length, arr[0].length);
                    }
                }
            }
        }
        System.out.println(" No Of Days : " + noOfDays);
        System.out.println("count size = " + count);
        System.out.println("emptyCells size = " + emptyCells);
        if(count + emptyCells != arr.length*arr[0].length)
            return false;


        return true;
    }
    static int[][] direstions = {{1,0}, {-1,0},{0,1},{0,-1}};
    static void fillGraph(int[][] arr, HashSet<String> visited, int i, int j, int R, int C) {

        String parent = getString(i, j);
        visited.add(parent);
        for(int[] dir : direstions) {
            int xCord = i + dir[0];
            int yCord = j + dir[1];
            if (isValid(xCord, yCord, R, C) &&
                    arr[xCord][yCord] != 0 &&
                    arr[xCord][yCord] != 2 ) {
                String child = getString(xCord, yCord);
                if(!visited.contains(child)) {
                    graph.get(parent).add(new Integer[]{xCord, yCord});
                    visited.add(child);
                }
            }
        }
    }
    static boolean isValid(int i, int j, int R, int C) {
       return i < R && i >= 0 && j >= 0 && j < C;
    }
    static String getString(int i, int j) {
        return Integer.toString(i) + "to" + Integer.toString(j);
    }
}
