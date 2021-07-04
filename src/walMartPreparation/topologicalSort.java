package walMartPreparation;

import java.util.*;

public class topologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        // TODO: Write your code here

        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();

        for (int i = 0; i < vertices; i++) {
            graph.put(i, new ArrayList<>());
            inDegree.put(i, 0);
        }

        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0)
                queue.add(entry.getKey());
        }

        while (!queue.isEmpty()) {
            Integer poped = queue.poll();
            sortedOrder.add(poped);
            ArrayList<Integer> children = graph.get(poped);
            for (Integer i : children) {
                inDegree.put(i, inDegree.get(i) - 1);
                if (inDegree.get(i) == 0)
                    queue.add(i);
            }
        }

        if(sortedOrder.size() != vertices)
            return new ArrayList<>();

        return sortedOrder;
    }

    public static void main(String[] args) {
        List<Integer> result = topologicalSort.sort(4,
                new int[][]{new int[]{3, 2}, new int[]{3, 0}, new int[]{2, 0}, new int[]{2, 1}});
        System.out.println(result);

        result = topologicalSort.sort(5, new int[][]{new int[]{4, 2}, new int[]{4, 3}, new int[]{2, 0},
                new int[]{2, 1}, new int[]{3, 1}});
        System.out.println(result);

        result = topologicalSort.sort(7, new int[][]{new int[]{6, 4}, new int[]{6, 2}, new int[]{5, 3},
                new int[]{5, 4}, new int[]{3, 0}, new int[]{3, 1}, new int[]{3, 2}, new int[]{4, 1}});
        System.out.println(result);
    }
}

