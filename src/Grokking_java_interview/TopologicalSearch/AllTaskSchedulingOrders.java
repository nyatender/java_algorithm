package Grokking_java_interview.TopologicalSearch;

import java.util.*;

/*
There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some prerequisite tasks which need to be completed
before it can be scheduled. Given the number of tasks and a list of prerequisite pairs, write a method to print all
 possible ordering of tasks meeting all prerequisites.
 Example:
 Input: Tasks=3, Prerequisites=[0, 1], [1, 2]
Output: [0, 1, 2]
Explanation: There is only possible ordering of the tasks.

Input: Tasks=4, Prerequisites=[3, 2], [3, 0], [2, 0], [2, 1]
Output:
1) [3, 2, 0, 1]
2) [3, 2, 1, 0]
Explanation: There are two possible orderings of the tasks meeting all prerequisites.
Input: Tasks=6, Prerequisites=[2, 5], [0, 5], [0, 4], [1, 4], [3, 2], [1, 3]
Output:
1) [0, 1, 4, 3, 2, 5]
2) [0, 1, 3, 4, 2, 5]
3) [0, 1, 3, 2, 4, 5]
4) [0, 1, 3, 2, 5, 4]
5) [1, 0, 3, 4, 2, 5]
6) [1, 0, 3, 2, 4, 5]
7) [1, 0, 3, 2, 5, 4]
8) [1, 0, 4, 3, 2, 5]
9) [1, 3, 0, 2, 4, 5]
10) [1, 3, 0, 2, 5, 4]
11) [1, 3, 0, 4, 2, 5]
12) [1, 3, 2, 0, 5, 4]
13) [1, 3, 2, 0, 4, 5]

 */
public class AllTaskSchedulingOrders {
    public static void printOrders(int tasks, int[][] prerequisites) {
        // TODO: Write your code here
        if(tasks <= 0)
            return;
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> graph =  new HashMap<>();

        // a. Initialize the graph
        for(int i = 0; i < tasks; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }
        // b. Build the graph
        for(int[] edges : prerequisites) {
            int parent = edges[0];
            int child = edges[1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }
        // c. Find all sources i.e., all vertices with 0 in-degrees
        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if(entry.getValue() == 0)
                queue.offer(entry.getKey());
        }
        ArrayList<Integer> sortedOrder = new ArrayList<>();
        findAllThePossibleSolutions(graph, inDegree, queue, sortedOrder);

    }
    static void findAllThePossibleSolutions(HashMap<Integer, ArrayList<Integer>> graph, HashMap<Integer, Integer> inDegree,
                                            Queue<Integer> queue, ArrayList<Integer> sortedOrder) {

        if(!queue.isEmpty()) {
            for(Integer vertex : queue) {
                sortedOrder.add(vertex);
                Queue<Integer> queueForNextCall = clone(queue);
                queueForNextCall.remove(vertex);
                ArrayList<Integer> child = graph.get(vertex);
                for (int children : child) {
                    inDegree.put(children, inDegree.get(children) - 1);
                    if (inDegree.get(children) == 0)
                        queueForNextCall.offer(children);
                }
                findAllThePossibleSolutions(graph, inDegree, queueForNextCall, sortedOrder);

                sortedOrder.remove(vertex);
                for (int children : child) {
                    inDegree.put(children, inDegree.get(children) + 1);
                }
            }
        }
        if(sortedOrder.size() == inDegree.size()) {
            System.out.println(sortedOrder);
        }

    }
    static Queue<Integer> clone(Queue<Integer> queue) {
        Queue<Integer> clonedQueue = new LinkedList<>();
        for(Integer item : queue) {
            clonedQueue.offer(item);
        }
        return clonedQueue;
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
