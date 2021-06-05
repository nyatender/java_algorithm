package NotesAndLinks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SortHashMapByValues {

    public static void main(String[] args) {
        HashMap<Integer, Integer> hMap = new HashMap<>();
        ArrayList<Map.Entry<Integer, Integer>> Arr = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : hMap.entrySet()) {
            Arr.add(entry);
        }

        Collections.sort(Arr, (i, j) -> i.getValue().compareTo(j.getValue()));
        LinkedHashMap<Integer, Integer> result = new LinkedHashMap<>();
        for(int i = 0; i < Arr.size(); i++) {
            result.put(Arr.get(i).getKey(), Arr.get(i).getValue());
        }
    }
}