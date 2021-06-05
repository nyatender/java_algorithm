package test;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class graph {
    public static void main(String[] args) {

       // int val = Integer.MAX_VALUE;

        Set<Long> keys = new HashSet<Long>();
        Long[] val1 = {12L,11L,12L,11L,14L};
        Map<Long, Set<Long>> mMap = new HashMap<>();
        for(int i = 0; i < val1.length; i++) {
            if(!mMap.containsKey(val1[i])) {
                Set<Long> val = new HashSet<Long>();
                val.add(val1[i]);
                mMap.put(val1[i], val);
            }
            else {
                mMap.get(val1[i]).add(val1[i]+10);
//                Set<Long> v = mMap.get(val1[i])
//                v.add(val1[i]);
            }
        }
        mMap.forEach((k, v) -> System.out.println(k + " " + v));
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
