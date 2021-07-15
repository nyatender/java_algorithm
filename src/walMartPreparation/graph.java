package walMartPreparation;

import java.util.*;

public class graph {
    public static void main(String[] args) {

       String[] words = {"ba", "bc", "ac", "cab"};
       findInAlienDictionary(words);

    }
    static public String findInAlienDictionary(String[] words) {

        HashMap<Character, ArrayList<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> inDegree = new HashMap<>();

        for(String string : words) {
           for(int i = 0; i < string.length(); i++) {
               graph.put(string.charAt(i), new ArrayList<>());
               inDegree.put(string.charAt(i), 0);
           }
        }

       for (int i = 1; i < words.length; i++) {
            String s1 = words[i-1];
           String s2 = words[i];
            for(int j = 0; j < Math.min(s1.length(), s2.length()); j++) {
                Character parent = s1.charAt(j);
                Character child = s2.charAt(j);
                if (parent != child) {
                    graph.get(parent).add(child);
                    inDegree.put(child, inDegree.get(child)+1);
                    break;
                }
            }
        }

       Queue<Character> queue = new LinkedList<>();
       for(Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
           if(entry.getValue() == 0) {
               queue.add(entry.getKey());
           }
       }

       if(queue.isEmpty())
           return new String();

       StringBuilder result = new StringBuilder();
       while(!queue.isEmpty()) {
           Character parent = queue.poll();
           result.append(parent);
           ArrayList<Character> children = graph.get((parent));
           for (Character child : children) {
               inDegree.put(child, inDegree.get(child) - 1);
               if (inDegree.get(child) == 0)
                   queue.add(child);
           }
       }

       if(result.length() != graph.size())
           return new String();

       return result.toString();
    }
    static public ArrayList<ArrayList<Integer>> AllTaskScheduling(int tasks, int[][] prerequisites) {

        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();

        //initialise
        for(int i = 0; i < tasks; i++) {
            graph.put(i, new ArrayList<>());
            inDegree.put(i, 0);
        }

        for(int i = 0; i < tasks; i++) {
            int parent = prerequisites[i][0];
            int child = prerequisites[i][1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child)+1);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if(entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();
        AllTaskSchedulingUtils(queue, graph, inDegree, result, finalResult);

        return finalResult;
    }

    static void AllTaskSchedulingUtils(Queue<Integer> queue, HashMap<Integer, ArrayList<Integer>> graph,
                                HashMap<Integer, Integer> inDegree, ArrayList<Integer> result, ArrayList<ArrayList<Integer>> finalResult) {

        if(!queue.isEmpty()) {
            for(Integer item : queue) {
                Queue<Integer> newQueue = getCloned(queue);
                result.add(item);
                newQueue.remove(item);
                ArrayList<Integer> childrens = graph.get(item);
                for (Integer child : childrens) {
                    inDegree.put(child, inDegree.get(child) - 1);
                    if (inDegree.get(child) == 0)
                        newQueue.add(child);
                }
                AllTaskSchedulingUtils(newQueue, graph, inDegree, result, finalResult);

                result.remove(item);
                for (Integer child : childrens) {
                    inDegree.put(child, inDegree.get(child) + 1);
                }
            }
        }

        if(result.size() == graph.size())
            finalResult.add(result);

    }
    static Queue getCloned(Queue<Integer> queue) {
        Queue<Integer> clonedQueue = new LinkedList<>();
        for(Integer it : queue)
            clonedQueue.add(it);

        return clonedQueue;
    }

}
