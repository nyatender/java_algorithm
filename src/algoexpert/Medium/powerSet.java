package algoexpert.Medium;

import java.util.ArrayList;
import java.util.List;

public class powerSet {
    public void powerSet(List<Integer> arr, List<List<Integer>> result) {
        if(arr.size() == 0)
            return;

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.size(); i++) {
            list.add(arr.get(i));
            result.add(0, list);
            powerSet(arr.subList(i, arr.size()), result);
        }

        //return new ArrayList<>();
    }
}
