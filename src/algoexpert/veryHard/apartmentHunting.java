package algoexpert.veryHard;

import java.util.*;
/*
You're looking to move into a new apartment on specific street, and you're given a list of
contiguous blocks on that street where each block contains an apartment that you could move
into.
You also have a list of requirements: a list of buildings that are important to you. For instance,
you might value having a school and a gym near your apartment. The list of blocks that you have
contains information at every block about all of the buildings that are present and absent at the
block in question. For instance, for every block, you might know whether a school, a pool, an
office, and a gym are present.
In order to optimize your life, you want to pick an apartment block such that you minimize the
farthest distance you'd have to walk from your apartment to reach any of your required
buildings.
Write a function that takes in a list of contiguous blocks on a specific street and a list of your
required buildings and that returns the location (the index) of the block that's most optimal for
you.
If there are multiple most optimal blocks, your function can return the index of any one of them.
blocks = [
 {
 "gym": false,
 "school": true,
 "store": false,
 },
 {
 "gym": true,
 "school": false,
 "store": false,
 },
 {
 "gym": true,
 "school": true,
 "store": false,
 },
 {
 "gym": false,
 "school": true,
Prompt
6/8/2021 AlgoExpert | Ace the Coding Interviews
https://www.algoexpert.io/questions/Apartment Hunting 2/2
 "store": false,
 },
 {
 "gym": false,
 "school": true,
 "store": true,
 },
]
reqs = ["gym", "school", "store"]
Sample Output
3 // at index 3, the farthest you'd have to walk to reach a gym, a school, or a
 */
public class apartmentHunting {

    public static void main(String[] args) {
        ArrayList<Map<String, Boolean>> list = new ArrayList<>();
        ArrayList<Boolean> values = new ArrayList<>(Arrays.asList(false, true, false, true, false,
                false, true, true, false, false, true, false, false, true, true));
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

// Copyright © 2021 AlgoExpert LLC. All rights reserved.
        // O(b^2*r) time | O(b) space - where b is the number of blocks and r is the num
        // requirements
        public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
         int[] maxDistancesAtBlocks = new int[blocks.size()];
         Arrays.fill(maxDistancesAtBlocks, Integer.MIN_VALUE);
         for (int i = 0; i < blocks.size(); i++) {
                    for (String req : reqs) {
                        int closestReqDistance = Integer.MAX_VALUE;
                        for (int j = 0; j < blocks.size(); j++) {
                            if (blocks.get(j).get(req)) {
                                closestReqDistance = Math.min(closestReqDistance, distanceBetween(i, j));
                            }
                        }
                        maxDistancesAtBlocks[i] = Math.max(maxDistancesAtBlocks[i], closestReqDistance);
                    }
                }
         return getIdxAtMinValue(maxDistancesAtBlocks);
    }
    public static int getIdxAtMinValue(int[] array) {
        int idxAtMinValue = 0;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            int currentValue = array[i];
            if (currentValue < minValue) {
                minValue = currentValue;
                idxAtMinValue = i;
            }
        }
        return idxAtMinValue;
    }
    public static int distanceBetween(int a, int b) {
        return Math.abs(a - b);
    }
}

