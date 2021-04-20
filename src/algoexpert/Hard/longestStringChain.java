package algoexpert.Hard;

import java.util.*;

public class longestStringChain {
    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>() {
            {
                add("abcdef");
                add("abcde");
                add("abde");
                add("1abde");
                add("abd");
                add("abc");
                add("ade");
                add("ae");
            }
        };
        System.out.println(longestStringChain(input));
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

            for(int i = 0; i < strItem.length(); i++) {
                String newString = strItem.substring(0, i) + strItem.substring(i+1);
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

        ArrayList<String > tempResult = new ArrayList<String>();
        if(lookup.containsKey(strItem.length() - 1)) {
            for (int i = 0; i < strItem.length(); i++) {
                String newString = strItem.substring(0, i) + strItem.substring(i+1);
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
