package Grokking_java_interview.TopologicalSearch;

/*
There is a dictionary containing words from an alien language for which we don’t know the ordering of the alphabets.
Write a method to find the correct order of the alphabets in the alien language.
It is given that the input is a valid dictionary and there exists an ordering among its alphabets.

Input: Words: ["ba", "bc", "ac", "cab"]
Output: bac
Explanation: Given that the words are sorted lexicographically by the rules of the alien language, so
from the given words we can conclude the following ordering among its characters:

1. From "ba" and "bc", we can conclude that 'a' comes before 'c'.
2. From "bc" and "ac", we can conclude that 'b' comes before 'a'

From the above two points, we can conclude that the correct character order is: "bac"

Input: Words: ["cab", "aaa", "aab"]
Output: cab
Explanation: From the given words we can conclude the following ordering among its characters:

1. From "cab" and "aaa", we can conclude that 'c' comes before 'a'.
2. From "aaa" and "aab", we can conclude that 'a' comes before 'b'

From the above two points, we can conclude that the correct character order is: "cab"

Input: Words: ["ywx", "wz", "xww", "xz", "zyy", "zwz"]
Output: ywxz
Explanation: From the given words we can conclude the following ordering among its characters:

1. From "ywx" and "wz", we can conclude that 'y' comes before 'w'.
2. From "wz" and "xww", we can conclude that 'w' comes before 'x'.
3. From "xww" and "xz", we can conclude that 'w' comes before 'z'
4. From "xz" and "zyy", we can conclude that 'x' comes before 'z'
5. From "zyy" and "zwz", we can conclude that 'y' comes before 'w'

From the above five points, we can conclude that the correct character order is: "ywxz"
 */

import java.util.*;

class AlienDictionary {
    public static String findOrder(String[] words) {
        // TODO: Write your code here
        if(words == null || words.length == 0)
            return "";

        HashMap<Character, ArrayList<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> inDegree = new HashMap<>();

        for(String word : words) {
            char[] charArray = word.toCharArray();
            for(int i = 0; i< charArray.length; i++) {
                graph.put(charArray[i], new ArrayList<>());
                inDegree.put(charArray[i], 0);
            }
        }

        for(int i = 1 ; i < words.length; i++) {
            String x = words[i-1];
            String y = words[i];
            for(int j = 0; j < Math.min(x.length(),y.length()); j++) {
                Character parent = x.charAt(j);
                Character child = y.charAt(j);
                if(parent != child) {
                    graph.get(parent).add(child); // put the child into it's parent's list
                    inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for(Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if(entry.getValue() == 0)
                queue.add(entry.getKey());
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            Character vertex = queue.poll();
            ArrayList<Character> children = graph.get(vertex);
            sb.append(vertex);
            for(Character child : children) {
                inDegree.put(child, inDegree.get(child)-1);
                if(inDegree.get(child) == 0)
                    queue.add(child);
            }
        }

        return (sb.length() != inDegree.size() ? " " : sb.toString());
    }

    public static String findOrderOriginalSolution(String[] words) {
        if (words == null || words.length == 0)
            return "";

        // a. Initialize the graph
        HashMap<Character, Integer> inDegree = new HashMap<>(); // count of incoming edges for every vertex
        HashMap<Character, List<Character>> graph = new HashMap<>(); // adjacency list graph
        for (String word : words) {
            for (char character : word.toCharArray()) {
                inDegree.put(character, 0);
                graph.put(character, new ArrayList<Character>());
            }
        }

        // b. Build the graph
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1]; // find ordering of characters from adjacent words
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char parent = w1.charAt(j), child = w2.charAt(j);
                if (parent != child) { // if the two characters are different
                    graph.get(parent).add(child); // put the child into it's parent's list
                    inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
                    break; // only the first different character between the two words will help us find the order
                }
            }
        }

        // c. Find all sources i.e., all vertices with 0 in-degrees
        Queue<Character> sources = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0)
                sources.add(entry.getKey());
        }

        // d. For each source, add it to the sortedOrder and subtract one from all of its children's in-degrees
        // if a child's in-degree becomes zero, add it to the sources queue
        StringBuilder sortedOrder = new StringBuilder();
        while (!sources.isEmpty()) {
            Character vertex = sources.poll();
            sortedOrder.append(vertex);
            List<Character> children = graph.get(vertex); // get the node's children to decrement their in-degrees
            for (Character child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0)
                    sources.add(child);
            }
        }

        // if sortedOrder doesn't contain all characters, there is a cyclic dependency between characters, therefore, we
        // will not be able to find the correct ordering of the characters
        if (sortedOrder.length() != inDegree.size())
            return "";

        return sortedOrder.toString();
    }
    public static void main(String[] args) {
        String result = AlienDictionary.findOrder(new String[] { "ba", "bc", "ac", "cab" });
        System.out.println("Character order: " + result);

        result = AlienDictionary.findOrder(new String[] { "cab", "aaa", "aab" });
        System.out.println("Character order: " + result);

        result = AlienDictionary.findOrder(new String[] { "ywx", "wz", "xww", "xz", "zyy", "zwz" });
        System.out.println("Character order: " + result);
    }
}
