package algoexpert.veryHard;

import java.util.*;

public class apartmentHunting {

    public static void main(String[] args) {
        ArrayList<Map<String, Boolean>> list = new ArrayList<>();
        ArrayList<Boolean> values = new ArrayList<>(Arrays.asList(false, true, false, true, false,
                false, true, true,false, false,true, false,false,true,true));
        int j = 0;
        for(int i = 0; i < 5; i++) {
            Map<String, Boolean> mMap = new HashMap<>();
            mMap.put("gym", values.get(j));
            mMap.put("school", values.get(j+1));
            mMap.put("store", values.get(j+2));

            j += 3;
            list.add(mMap);
        }
        String[] reqs = {"gym","school", "store"};
        System.out.println(apartmentHunting(list, reqs));
    }

    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {

        // Write your code here.
        List<ArrayList<Integer>> list = new ArrayList<>();
        int[] results = new int[blocks.size()];
        Arrays.fill(results, Integer.MAX_VALUE);

        List<Set<String>> mymaps = new ArrayList<Set<String>>();
        for(int i = 0; i < blocks.size(); i++) {
            mymaps.add(new HashSet<>());
        }

        for(int i = 0; i < blocks.size(); i++) {
            for(int j = 0; j < blocks.size(); j++) {
                for(String str : reqs) {
                    if(!mymaps.get(i).contains(str) && blocks.get(j).get(str))
                        mymaps.get(i).add(str);
                }

                if(mymaps.get(i).size() == reqs.length) {
                    results[i] = Math.min(Math.abs(i-j), results[i]);
                    mymaps.get(i).clear();
                }
            }
        }

        int min = 0;
        for(int i = 1; i < results.length; i++) {
            if(results[min] > results[i])
                min = i;
        }

        return min;
    }
}