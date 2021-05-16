package test;

import java.util.Arrays;

public class graph {
    public static void main(String[] args) {
        int val = Integer.MAX_VALUE;
    }

    public static int getMinVal(int[] maxVal, boolean[] visited) {
        int minV = Integer.MAX_VALUE;
        int index = -1;
        int j = 0;
        for(int val : maxVal) {
            if(!visited[j] && minV > val) {
                minV = val;
                index = j;
            }
            j++;
        }
        return j;
    }
    public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        // Write your code here.

        int noOfVertices = edges.length;
        boolean[] visited = new boolean[noOfVertices];
        int[] maxVal = new int[noOfVertices];
        Arrays.fill(maxVal, Integer.MAX_VALUE);

        maxVal[start] = 0;

        for(int i = 0; i < noOfVertices; i++) {
            for(int j = 0; j < edges[0].length; j++) {
                int u = getMinVal(maxVal, visited);

                visited[u] = true;

                for(int v = 0; v < noOfVertices; v++) {

                    if(edges[i][j][0] != 0 && !visited[v]
                            && maxVal[v] != Integer.MAX_VALUE
                            && maxVal[v] + edges[i][j][1] < maxVal[v]) {
                        maxVal[v] = maxVal[u] + edges[i][j][1];
                    }
                }
            }
        }

        return new int[] {};
    }
}
