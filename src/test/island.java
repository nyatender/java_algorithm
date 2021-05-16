package test;

import java.util.ArrayList;

public class island {

    public static void main(String[] args) {

        int[][] input = {{1, 0, 1, 0, 1},
                        {1, 1, 0, 0, 1},
                        {0, 0, 1, 0, 0},
                        {1, 0, 0, 0, 0},
                        {1, 0, 0, 1, 1}
        };
        int n = noOfIsland(input);
        System.out.println(n);
    }

    static public int noOfIsland(int[][] input) {
        boolean[][] visited = new boolean[input.length][input[0].length];

        int result = 0;
        for(int i = 0; i < input.length; i++) {
            for(int j = 0; j < input[0].length; j++) {
                if((input[i][j] == 1) && !visited[i][j]) {
                    bfsTravalsal(input, visited, i, j);
                    result += 1;
                }
            }
        }

        return result;
    }

    static void bfsTravalsal(int[][] arr, boolean[][] visited, int i, int j) {
        if(isSafe(arr, i, j) && !visited[i][j] && arr[i][j] == 1) {
            visited[i][j] = true;
            bfsTravalsal(arr, visited, i+1, j);
            bfsTravalsal(arr, visited, i, j-1);
            bfsTravalsal(arr, visited, i-1, j);
            bfsTravalsal(arr, visited, i, j+1);
        }
    }
    static boolean isSafe(int[][] arr, int i, int j) {
        return (i < arr.length && i >= 0 && j < arr[0].length && j >= 0);
    }

    class SubSet {
        int rank;
        int parent;
    }
    static int find(SubSet[] subset, int x) {
        if(!subset[x].equals(x))
            return find(subset, subset[x].parent);

        return x;
    }
    static void union(SubSet[] subset, int x, int y) {
        if(subset[x].rank < subset[y].rank) {
            subset[x].parent = y;
        }
        else if(subset[x].rank > subset[y].rank) {
            subset[y].parent = x;
        }
        else {
            subset[x].rank++;
            subset[y].parent = x;
        }
    }
    static boolean findtheCycle(ArrayList<ArrayList<Integer>> graph) {

        SubSet[] subset = new SubSet[graph.size()];
        int i = 0;
        for(SubSet s : subset) {
            s.parent = i;
            s.rank = 1;
        }
        boolean result = false;
        int indexX = 0;
        for(ArrayList<Integer> key : graph) {
            int x_Root = find(subset, indexX);
            int indexY = 0;

            for(Integer k : key) {
                int y_Root = find(subset, indexX);

                if(x_Root != y_Root)
                    union(subset, indexX, indexY);
                else {
                    result = true;
                    break;
                }

                indexY++;
            }
            indexX++;
        }

        return result;
    }
}
