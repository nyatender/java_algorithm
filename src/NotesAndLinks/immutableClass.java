package NotesAndLinks;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class immutableClass {
    public static void main(String[] args) {
        ArrayList<Integer> val = new ArrayList<>();
        val.add(100);
        val.add(200);
        Map<String, String > mMap = new HashMap<>();
        mMap.put("key1", "val1");
        mMap.put("key2", "val2");
        Date d = new Date();
        immutableClass obj = new immutableClass(10, "yaten", d, val, mMap);
    }

    /**
     * Integer and String classes are immutable whereas Date class is mutable
     */
    private final Integer immutableInteger;
    private final String immutableString;
    private final Date mutableDate;
    private final ArrayList<Integer>  mutableArrayList;
    private final Map<String, String> metadata;

    public immutableClass(Integer i, String s, Date d, ArrayList<Integer> array, Map<String, String> mapMetadata) {
        this.immutableInteger = i;
        this.immutableString = s;
        this.mutableDate = new Date(d.getTime());
        //this.mutableArrayList = new ArrayList<>(array);

        ArrayList<Integer> arr = new ArrayList<>();
        for (Integer entry : array) {
            arr.add(entry);
        }
        this.mutableArrayList = arr;

        Map<String, String> tempMap = new HashMap<>();
        for (Map.Entry<String, String> entry : mapMetadata.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        this.metadata = tempMap;
    }

    public String getImmutableString() {
        return immutableString;
    }

    public Integer getImmutableInteger() {
        return immutableInteger;
    }

    public Date getMutableDate() {
        return new Date(mutableDate.getTime());
    }

    public ArrayList<Integer> getMutableArrayList() {
        return new ArrayList<Integer>(mutableArrayList);
    }
    public Map<String, String> getMetadata()
    {
        Map<String, String> tempMap = new HashMap<>();
        for (Map.Entry<String, String> entry : this.metadata.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        return tempMap;
    }

    @Override
    public String toString() {
        return immutableInteger + ", " + immutableString + ", " + mutableDate;
    }
}
