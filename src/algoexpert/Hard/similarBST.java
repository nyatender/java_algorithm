package algoexpert.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class similarBST {
    public static void main(String[] args) {

    }
    static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if(arrayOne.size() == 0 && arrayTwo.size() == 0)
            return true;
        if(arrayOne.get(0) != arrayTwo.get(0))
            return false;
        if(arrayOne.size() != arrayTwo.size())
            return false;

        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < arrayOne.size(); i++ ) {
            List<Integer> t = map.getOrDefault(arrayOne.get(i), new ArrayList<Integer>());
            t.add(i);
            map.put(arrayOne.get(i), t);
        }
        for(int i = 0; i < arrayOne.size(); i++) {
            List<Integer> t = map.getOrDefault(arrayOne.get(i), new ArrayList<Integer>());
            t.add(i);
            map.put(arrayOne.get(i), t);
        }
        if(map.size() > arrayOne.size() || map.size() > arrayTwo.size())
            return false;
         for(List<Integer> key : map.values()) {
           if(!isNextGreaterAndNextSmallerIsSame( arrayOne, arrayTwo, key.get(0), key.get(1))) {
                return false;
            }
        };
        return true;
    }

    static boolean isNextGreaterAndNextSmallerIsSame(List<Integer> arrayOne, List<Integer> arrayTwo, int i, int j) {
        if(i >= arrayOne.size() && j >= arrayTwo.size()) {
            return false;
        }
        int nextAGreater=Integer.MIN_VALUE;
        int nextASmaller=Integer.MAX_VALUE;
        for(int m = i; i < arrayOne.size(); i++) {
            if(nextAGreater < arrayOne.get(m))
                nextAGreater = arrayOne.get(m);
            if(nextAGreater > arrayOne.get(m))
                nextAGreater = arrayOne.get(m);
        }
        int nextBGreater= Integer.MIN_VALUE;
        int nextBSmaller= Integer.MAX_VALUE;
        for(int m = j; i < arrayTwo.size(); j++) {
            if(nextBGreater < arrayTwo.get(m))
                nextBGreater = arrayTwo.get(m);
            if(nextBSmaller > arrayTwo.get(m))
                nextBSmaller = arrayTwo.get(m);
        }

        return (nextAGreater == nextBGreater && nextASmaller == nextBSmaller);
    }
}
