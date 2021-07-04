package walMartPreparation;

import java.util.*;

public class AllTaskSchedulingOrders {

    public static void printOrders(int tasks, int[][] prerequisites) {
        // TODO: Write your code here
        ArrayList<Integer> allorder = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();

        for (int i = 0; i < tasks; i++) {
            graph.put(i, new ArrayList<>());
            inDegree.put(i, 0);
        }

        for (int[] edge : prerequisites) {
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

        allSortedOrder(queue, graph, inDegree, allorder);
    }
    public static void allSortedOrder(Queue<Integer> queue,
                                      HashMap<Integer, ArrayList<Integer>> graph,
                                      HashMap<Integer, Integer> inDegree,
                                      ArrayList<Integer> allOrder) {

        if(!queue.isEmpty()) {
            for(Integer item : queue) {
                //Integer item = queue.peek();
                allOrder.add(item);
                Queue<Integer> clonedQueue = getClonedQueue(queue);
                clonedQueue.remove(item);
                ArrayList<Integer> childers = graph.get(item);
                for(Integer child : childers) {
                    inDegree.put(child, inDegree.get(child)-1);
                    if (inDegree.get(child) == 0)
                        clonedQueue.add(child);
                }
                allSortedOrder(clonedQueue, graph, inDegree, allOrder);

                allOrder.remove(item);
                for(Integer child : childers) {
                    inDegree.put(child, inDegree.get(child)+1);
                }
            }
        }

        if(allOrder.size() == inDegree.size())
            result.add(allOrder);
    }
    static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    static Queue<Integer> getClonedQueue(Queue<Integer> q) {
        Queue<Integer> qDup = new LinkedList<>();
        for(Integer i : q)
           qDup.add(i);

        return qDup;
    }
    public static void main(String[] args) {
        AllTaskSchedulingOrders.printOrders(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println();

        AllTaskSchedulingOrders.printOrders(4,
                new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println();

        AllTaskSchedulingOrders.printOrders(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
                new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println();
    }
}