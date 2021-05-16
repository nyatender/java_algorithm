package algoexpert.Medium;

import java.util.*;

// passed all test case

public class groupAnagram {
    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<String>(
                Arrays.asList("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"));

        anagramGroup(input).forEach(System.out::println);
    }

    static List<List<String>> anagramGroup(List<String> words) {

        HashMap<String, ArrayList<Integer>> mapping = new HashMap<>();

        int indexInWords = 0;
        for(String input : words) {
            char[] charArr = input.toCharArray();
            Arrays.sort(charArr);
            String key = new String(charArr);
            ArrayList<Integer> values = mapping.getOrDefault(key, new ArrayList<Integer>());
            values.add(indexInWords);
            indexInWords++;

            mapping.put(key, values);
        }

        List<List<String>> result = new ArrayList<List<String>>();
        for(Map.Entry<String, ArrayList<Integer>> entry : mapping.entrySet()) {
            ArrayList<String> interResult = new ArrayList<>();

            for(Integer index : entry.getValue())
                interResult.add(words.get(index));
            result.add(interResult);
        }

        return result;
    }
}
