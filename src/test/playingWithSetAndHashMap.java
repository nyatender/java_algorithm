package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class playingWithSetAndHashMap {
    public static void main(String[] args) {
            fun1();
    }

    static void fun() {

        // int val = Integer.MAX_VALUE;

        Set<Long> keys = new HashSet<Long>();
        Long[] val1 = {12L, 11L, 12L, 11L, 14L};
        Map<Long, Set<Long>> mMap = new HashMap<>();
        for (int i = 0; i < val1.length; i++) {
            if (!mMap.containsKey(val1[i])) {
                Set<Long> val = new HashSet<Long>();
                val.add(val1[i]);
                mMap.put(val1[i], val);
            } else {
                mMap.get(val1[i]).add(val1[i] + 10);
//                Set<Long> v = mMap.get(val1[i])
//                v.add(val1[i]);
            }
        }
        mMap.forEach((k, v) -> System.out.println(k + " " + v));
    }

    //ifAbsent
    static void fun1() {

        Long[] val1 = {12L, 11L, 12L, 11L, 14L};

        Map<Long, Set<Long>> mMap = new HashMap<>();

        for (int i = 0; i < val1.length; i++) {
            Set<Long> val = new HashSet<Long>();
            val.add(val1[i]);
            Set<Long> res = mMap.putIfAbsent(val1[i], val);
            if(res != null) {
                mMap.get(val1[i]).add(val1[i]+10);
            }
        }

        mMap.forEach((k, v) -> System.out.println(k + " " + v));
    }
}