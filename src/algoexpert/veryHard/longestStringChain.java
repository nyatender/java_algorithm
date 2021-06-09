package algoexpert.veryHard;

import java.util.*;

/*
Longest String Chain
Given a list of strings, write a function that returns the longest string chain that can be built from
those strings.
A string chain is defined as follows: let string A be a string in the initial array; if removing any
single character from string A yields a new string B that's contained in the initial array of
strings, then strings A and B form a string chain of length 2. Similarly, if removing any single
character from string B yields a new string C that's contained in the initial array of strings, then
strings A , B , and C form a string chain of length 3.
The function should return the string chain in descending order (i.e., from the longest string to the
shortest one). Note that string chains of length 1 don't exist; if the list of strings doesn't contain
any string chain formed by two or more strings, the function should return an empty array.
You can assume that there will only be one longest string chain.
Sample Input
strings = ["abde", "abc", "abd", "abcde", "ade", "ae", "1abde", "abcdef"]
Sample Output
["abcdef", "abcde", "abde", "ade", "ae"]

 */

public class longestStringChain {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(Arrays.asList("abde", "abc", "abd", "abcde", "ade", "ae", "1abde", "abcdef"));

        List<String> result = longestStringChain(strings);
        result.forEach(i -> System.out.print(i + " "));
    }
    public static List<String> longestStringChain(List<String> strings) {
        // Write your code here.
        Collections.sort(strings, (a, b) -> (b.length() - a.length()));
        Map<Integer, HashSet<String>> lookup = new TreeMap<Integer, HashSet<String>>(Collections.reverseOrder());
        for(String item : strings) {
            HashSet<String> val = lookup.getOrDefault(item.length(), new HashSet<>());
            val.add(item);
            lookup.put(item.length(), val);
        }

        ArrayList<String > results = new ArrayList<String>();
        for(String strItem : strings) {
            if(!lookup.containsKey(strItem.length()-1))
                continue;

            String newString;
            for(int i = 0; i < strItem.length(); i++) {
                newString = strItem.substring(0, i) + strItem.substring(i+1);
                if(lookup.get(newString.length()).contains(newString)) {
                    ArrayList<String > tempResult = new ArrayList<String>();
                    tempResult.add(strItem);
                    tempResult.addAll(getCount(lookup, newString));
                    if(tempResult.size() > results.size())
                    {
                        results = tempResult;
                    }
                }
            }
        }
        return results;
    }

    static ArrayList<String> getCount(Map<Integer, HashSet<String>> lookup, String strItem) {
        if(!lookup.containsKey(strItem.length()))
            return new ArrayList<String>();

        ArrayList<String > results = new ArrayList<String>();
        results.add(strItem);

        String newString;
        ArrayList<String > tempResult = new ArrayList<String>();
        if(lookup.containsKey(strItem.length() - 1)) {
            for (int i = 0; i < strItem.length(); i++) {
                newString = strItem.substring(0, i) + strItem.substring(i+1);
                if (lookup.get(newString.length()).contains(newString)) {
                    ArrayList<String> preResult = getCount(lookup, newString);
                    if(preResult.size() > tempResult.size())
                    {
                        tempResult = preResult;
                    }
                }
            }
        }
        results.addAll(tempResult);
        return results;
    }
}