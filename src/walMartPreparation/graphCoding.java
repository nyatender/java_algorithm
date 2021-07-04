package walMartPreparation;

import javax.security.auth.callback.CallbackHandler;
import java.util.*;

public class graphCoding {
    public static void main(String[] args) {
        String[] words = {"cab", "aaa", "aab"};
        findTheOrder(words).forEach(i -> System.out.println(i));
    }
    static ArrayList<Character> findTheOrder(String[] words) {

        HashMap<Character, ArrayList<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> InDergee = new HashMap<>();
        for (String word : words) {
            for (char character : word.toCharArray()) {
                InDergee.put(character, 0);
                graph.put(character, new ArrayList<Character>());
            }
        }
        for(int i = 1; i < words.length; i++) {
            String s1 = words[i-1];
            String s2 = words[i];
            int index = 0;
            while(index < Math.min(s1.length(), s2.length())) {
                Character parent = s1.charAt(index);
                Character child = s2.charAt(index);
                if(parent != child) {
                    graph.get(parent).add(child);
                    InDergee.put(child,InDergee.get(child) + 1);
                    break;
                }
                index++;
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for(Map.Entry<Character, Integer> entry : InDergee.entrySet()) {
            if(entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }
        if(queue.size() == 0)
            return new ArrayList<>();

        ArrayList<Character> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            Character item = queue.poll();
            res.add(item);
            ArrayList<Character> values = graph.get(item);
            for(Character ch : values) {
                InDergee.put(ch, InDergee.get(ch) - 1);
                if(InDergee.get(ch) == 0)
                    queue.add(ch);
            }
        }
        if(res.size() != InDergee.size())
            return new ArrayList<>();

        return res;
    }
    public static void getDFS() {
        int[][] edges = {{0,1},{1,3},{1,2},{3,4}};
        int vertices = 5;
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int i = 0; i < vertices; i++)
            graph.put(i, new ArrayList<>());
        for(int[] v : edges) {
            int parent = v[0];
            int child = v[1];
            //if(graph.containsKey(parent))
            graph.get(parent).add(child);
        }
        DFS(graph, 0);


    }
   static void DFS(HashMap<Integer,  ArrayList<Integer>> graph, int i) {
        HashSet<Integer> visited = new HashSet<>();

        for(Integer entry : graph.keySet())
            DFSUtils(entry, graph, visited);

    }
    static void DFSUtils(int v, HashMap<Integer, ArrayList<Integer> > graph, HashSet<Integer> visited) {
        visited.add(v);
        System.out.println(v);
        for(Integer i : graph.get(v)) {
            if(!visited.contains(v))
                DFSUtils(i, graph, visited);
        }
    }
}
