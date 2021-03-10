package backToback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class word_subsets {
    public static void main(String[] args) {

       ArrayList<String> A = new ArrayList<String>() {
           {
               add("orange");
               add("room");
               add("more");
           }
       };
        ArrayList<String> B = new ArrayList<String>() {
            {
                add("rm");
                add("oo");
            }
        };
        Map<Character, ArrayList<Integer>> mp = new HashMap<>();
        int i = 0;
        for(String a : A) {
            mp = getCount(a, i++);
        }

    }
    static Map<Character,  ArrayList<Integer>> getCount(String a, int i) {
        Map<Character, ArrayList<Integer>> mp = new HashMap<>();
        Integer[] count = new Integer[]{0, i};
        for(char ch : a.toCharArray()) {
            Integer tempCount = (mp.get(ch)).get(0) + 1;
           // mp.put(ch, new  ArrayList<Integer>{tempCount, i});
        }

        return mp;
    }
}
