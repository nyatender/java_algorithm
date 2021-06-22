package CompanyAskQuestions.KLA;

import java.util.*;

/*
1: https://www.geeksforgeeks.org/maximum-of-minimum-difference-of-all-pairs-from-subsequences-of-given-size/
2: Connected Sum
Given a number of the node and a list of connected pairs, determine the weights of each isolated set of nodes
assuming each node weights 1 unit, then for each weight calculated, sum the ceiling of its square root and return
the final sum.
graph_nodes = 10
graph_from = [1,1,2,3,7]
graph_To = [2,3,4,5,8]

             1          6       7       9   10
            / \                 |
           2   3                8
           |   |
           4   5
  size of [1,2,3,4,5] = 5 so sqrt of 5 => 2.236 => ceil(2.23) => 3
  size of [7,8] = 2 so sqrt of 2 => 1.414 => ceil(1.414) => 2
  size of [1] => 1 => ceil of 1 = 1
  so total sum = 3 + 2 + 3*1 = 8

 */

public class KLATencor {
    public static void main(String[] args) {
        //connectedGraph
        KLATencor obj = new KLATencor();
        List<Integer> graphFrom = new ArrayList<>(Arrays.asList(1,1,2,3,7));
        List<Integer> graphTo = new ArrayList<>(Arrays.asList(2,3,4,5,8));
        int res = obj.connectedGraph(10, graphFrom, graphTo);
        System.out.println(res);
    }
    int connectedGraph(int gnodes, List<Integer> graphFrom, List<Integer>graphTo) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        for(int i = 1; i <= 10; i++) {
            graph.put(i, new ArrayList<>());
            inDegree.put(i, 0);
        }
        for(int i = 0; i < graphFrom.size(); i++) {
            Integer parent = graphFrom.get(i);
            Integer child = graphTo.get(i);

            if(!graph.containsKey(parent)) {
                ArrayList<Integer> item = new ArrayList<>();
                item.add(child);
                graph.put(parent, item);
            }
            else {
                graph.get(parent).add(child);
            }
        }
        int sum = 0;
        HashSet<Integer> visisted = new HashSet<>();
        int preSize = 0;
        for(Map.Entry<Integer, ArrayList<Integer>> entry : graph.entrySet()) {
            findTheVisitedNode(graph, entry.getKey(), visisted);
            int diff = visisted.size() - preSize;
            sum += Math.ceil(Math.sqrt(diff));
            preSize = visisted.size();
        }

        return sum;
    }
    void findTheVisitedNode(HashMap<Integer, ArrayList<Integer>> graph, Integer k,  HashSet<Integer> visisted ) {
        visisted.add(k);
        for(int i = 0; i < graph.get(k).size(); i++) {
            int index = graph.get(k).get(i);
            if(!visisted.contains(index)) {
                findTheVisitedNode(graph, index, visisted);
            }
        }
    }
}
