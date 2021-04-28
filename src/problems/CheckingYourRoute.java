/*
package problems;

import javafx.util.Pair;

import java.util.*;

*/
/*
A ride hailing company sometimes travels between the cities. To avoid delay a driver first check the shortest
routes. Given a map of the cities and their bidirectional road represented by a graph of the nodes and along any
shortest path. return an array of strings, one for each road in order, where the value is YES if the road is along a shortest
path or NO if it is not. The roads or edges are named using their 1-based index within the input arrays.

Example:
 given a map of g_nodes = 5 nodes, the starting nodes, ending nodes and road lengths are:
  road:         from/to/weight
   1            {1,2,1}
   2            {2,3,1}
   3            {3,4,1}
   4            {4,5,1}
   5            {5,1,3}
   6            {1,3,2}
   7            {5,3,1}

   O/P : ["YES","YES","NO","NO","YES","YES","YES"]
   description there are duplicate paths and given input order sequence contain in output.
   1->5, 1->2->3->5, and 1->3->5
 *//*

public class CheckingYourRoute {

    public static void main(String args[]) {
        int g_nodes = 5;
        ArrayList<Integer> g_from = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 1, 5));
        ArrayList<Integer> g_to = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 1, 3, 3));
        ArrayList<Integer> g_weight = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 3, 2, 1));

        ArrayList<String> res = classifyEdges(g_nodes, g_from, g_to, g_weight);
        res.forEach(item-> System.out.println(item));
    }

    public static void printGrapgh(int graph[][])
    {
        for(int i = 0; i < graph.length; i++)
        {
            for(int j = 0; j < graph[0].length; j++)
            {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void dfsUtils(int graph[][], int u, boolean visited[],
                         Set<Pair<Integer, Integer>>sourceToDest,
                        int sumSoFar, Map<Integer, Set<Pair<Integer, Integer>>>result)
    {
        visited[u] = true;
        for(int v = u; v < graph.length; v++)
        {
//            System.out.println( " graph" +"[" + u + "]" + "[" + v + "]" + "=" + graph[u][v]);
//            System.out.println(  " visited"+"[" + v + "]" + "="  + visited[v]);
            if(graph[u][v] != 0 && !visited[v])
            {
                int sum = sumSoFar + graph[u][v];
                Set<Pair<Integer, Integer>>sourDest = new HashSet<>(sourceToDest);
                sourDest.add(new Pair(u+1, v+1));
                if(v == graph.length - 1)
                {
                    Set<Pair<Integer, Integer>>s = result.get(sum);
                    if(s != null) {
                        s.addAll(sourDest);
                        result.put(sum, s);
                    }
                    else
                        result.put(sum, sourDest);
                    return;
                }
                dfsUtils(graph, v, visited.clone(), sourDest,sum, result);
            }
        }
    }
    public static ArrayList<String> classifyEdges( int g_nodes,  ArrayList<Integer> g_from,  ArrayList<Integer> g_to,
                                      ArrayList<Integer> g_weight)
    {
       ArrayList<String> res = new ArrayList<>();
       int[][] graph = new int[g_nodes][g_nodes];
       for(int i = 0; i < g_from.size(); i++)
       {
           graph[g_from.get(i) -1][g_to.get(i)-1] = g_weight.get(i);
           graph[g_to.get(i)-1][g_from.get(i)-1] = g_weight.get(i);
       }
      //  System.out.println(" graph.length = " + graph.length);
       printGrapgh(graph);
       int sumSoFar = 0;
       boolean[] visited = new boolean[g_nodes];
       Set<Pair<Integer, Integer>>sourceToDest = new HashSet<Pair<Integer, Integer>>();
       Map<Integer, Set<Pair<Integer, Integer>>>result = new TreeMap<Integer, Set<Pair<Integer, Integer>>>();

        dfsUtils(graph, 0, visited, sourceToDest,sumSoFar, result);
        if(!result.isEmpty()) {
            Map.Entry<Integer, Set<Pair<Integer, Integer>>> entry = result.entrySet().iterator().next();
            Set<Pair<Integer, Integer>> val = entry.getValue();
            for (int i = 0; i < g_from.size(); i++) {
                if (val.contains(new Pair(g_from.get(i), g_to.get(i))) ||
                    val.contains(new Pair(g_to.get(i), g_from.get(i)))) {
                    res.add("YES");
                } else {
                    res.add("NO");
                }
            }
        }
       return res;
    }
}
*/
