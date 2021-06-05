package Grokking_java_interview.TopologicalSearch;

import java.util.*;

/*
Topological Sort of a directed graph (a graph with unidirectional edges) is a linear ordering of its vertices such that
for every directed edge (U, V) from vertex U to vertex V, U comes before V in the ordering.
Given a directed graph, find the topological ordering of its vertices.
Input: Vertices=4, Edges=[3, 2], [3, 0], [2, 0], [2, 1]
Output: Following are the two valid topological sorts for the given graph:
1) 3, 2, 0, 1
2) 3, 2, 1, 0

Input: Vertices=5, Edges=[4, 2], [4, 3], [2, 0], [2, 1], [3, 1]
Output: Following are all valid topological sorts for the given graph:
1) 4, 2, 3, 0, 1
2) 4, 3, 2, 0, 1
3) 4, 3, 2, 1, 0
4) 4, 2, 3, 1, 0
5) 4, 2, 0, 3, 1

 */

class TopologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        if(vertices < 0) {
            return sortedOrder;
        }
        // TODO: Write your code here
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for(int i = 0; i < vertices; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        for(int[] item : edges) {
            int parent = item[0];
            int child = item[1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer, Integer> map : inDegree.entrySet()) {
            if(map.getValue() == 0)
                queue.add(map.getKey());
        }

        while(!queue.isEmpty()) {
            int item = queue.poll();
            sortedOrder.add(item);
            for(int i = 0; i < graph.get(item).size(); i++) {
                int child = graph.get(item).get(i);
                inDegree.put(child, inDegree.get(child) - 1);
                if(inDegree.get(child) == 0)
                    queue.add(child);
            }
        }

        return sortedOrder;
    }

    public static List<Integer> usingDFS(int vertices, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> sortedOrder = new Stack<Integer>();
        if(vertices < 0) {
            return sortedOrder;
        }
        // TODO: Write your code here
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for(int i = 0; i < vertices; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] item : edges) {
            int parent = item[0];
            int child = item[1];
            graph.get(parent).add(child);
        }
        Boolean[] visited = new Boolean[vertices];
        for(int i = 0; i < vertices; i++) {
            visited[i] = false;
           // System.out.println(visited[i]);

        }
        //for(Map.Entry<Integer, ArrayList<Integer>> map : graph.entrySet()) {
        for(int i = 0; i < vertices; i++) {
            if (!visited[i] && graph.containsKey(i))
                DfsUtils(graph, i, visited, sortedOrder);
        }

        while (sortedOrder.empty() == false)
            result.add(sortedOrder.pop());
        return result;
    }

    static void DfsUtils(HashMap<Integer, ArrayList<Integer>> graph, int v, Boolean[] visited, Stack<Integer> stack) {

        visited[v] = true;

        for(int i = 0 ; i < graph.get(v).size(); i++) {
            int child = graph.get(v).get(i);
            if(visited[child] == false) {
                DfsUtils(graph, child, visited, stack);
            }
        }
        stack.add(new Integer(v));
    }

    public static void main(String[] args) {
        List<Integer> result = TopologicalSort.usingDFS(4,
                new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println(result);

        result = TopologicalSort.usingDFS(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
                new int[] { 2, 1 }, new int[] { 3, 1 } });
        System.out.println(result);

        result = TopologicalSort.usingDFS(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
                new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
        System.out.println(result);
    }
}
