package algoexpert.otherImportantAlgo;

import problems.Graph.Graph;

import java.util.Arrays;

//https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
public class DjKastra {

    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        //Shortestdist t = new Shortestdist();
        int[] result = shortestdist(graph, 0);
        printSolution(result, graph.length);
    }

    static int[] shortestdist(int[][] graph, int source) {
        int V = graph.length;
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);

        boolean[] visited = new boolean[graph.length];

        dist[source] = 0;

        for(int vertex = 0; vertex < V-1; vertex++) {
            int minValIndex = getMiniMumdist(dist, visited);
            visited[minValIndex] = true;
            for(int v = 0; v < graph[0].length; v++) {
                if(!visited[v] && graph[minValIndex][v] != 0 &&
                        dist[minValIndex] != Integer.MAX_VALUE &&
                        dist[minValIndex] + graph[minValIndex][v] < dist[v]) {
                    dist[v] =  dist[minValIndex] + graph[minValIndex][v];
                }
            }
        }
        return dist;
    }
    static void printSolution(int dist[], int V)
    {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }
    static int getMiniMumdist(int[] dist, boolean[] visisted) {
        int minVal = Integer.MAX_VALUE;
        int index = -1;
        for(int i =0 ; i < dist.length; i++) {
            if(!visisted[i] && minVal > dist[i] ) {
                minVal = dist[i];
                index = i;
            }
        }

        return index;
    }

}
