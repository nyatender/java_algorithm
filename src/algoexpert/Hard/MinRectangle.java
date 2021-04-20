package algoexpert.Hard;

import java.util.*;

public class MinRectangle {

    public static void main(String[] args) {
//        int[][] points = new int[][] {
//                {1,5},
//                {5,1},
//                {4,2},
//                {2,4},
//                {2,2},
//                {1,2},
//                {4,5},
//                {2,5},
//                {-1,-2}
//        };
//        int[][] points = new int[][] {
//                {-4,4},
//                {4,4},
//                {4,-2},
//                {-4,-2},
//                {0,-2},
//                {4,2},
//                {0,2}
//        };
//        int[][] points = new int[][] {
//                {0, 0},
//                {4,4},
//                {8,8},
//                {0,8},
//                {0,4},
//                {6,0},
//                {6,4}
//        };
        int[][] points = new int[][] {
                {0, 0},
                {1,1},
                {2,2},
                {-1,-1},
                {-2,-2},
                {-1,1},
                {-2,2},
                {1,-1},
                {2,-2}
        };
        System.out.println(minimumAreaRectangle(points));
    }
    static int minimumAreaRectangle(int[][] points) {
        // Write your code here.
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int minVal = Integer.MAX_VALUE;
        int currMax = 0;
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        for(int[] point : points){
           ArrayList<Integer> list = map.getOrDefault(point[0], new ArrayList<>());
           list.add(point[1]);
           map.put(point[0], list);
        }
        ArrayList<Integer> columns = new ArrayList<>(map.keySet());
        for(int i = 0; i < columns.size(); i++) {
            for(int j = i+1; j < columns.size(); j++) {
                if(!(map.get(columns.get(i)).size() >= 2 && map.get(columns.get(j)).size() >= 2))
                    continue;;
                currMax = getArea(columns.get(i),columns.get(j), map);
                if(minVal > currMax)
                    minVal = currMax;
            }
        }
        return minVal == Integer.MAX_VALUE ? 0 : minVal;
    }
    static private ArrayList<Integer[]> list = new ArrayList<Integer[]>();
    static int getArea(Integer a, Integer b, Map<Integer, ArrayList<Integer>> map) {
        ArrayList<Integer> aList = map.get(a);
        ArrayList<Integer> bList = map.get(b);
        int val = Integer.MAX_VALUE;
        if(!(aList.size() >= 2 && bList.size() >= 2))
            return val;
        Collections.sort(aList);
        Collections.sort(bList);
        boolean isFirst = false;
        int start = Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;
        for(int i = 0, j = 0; i < aList.size() && j < bList.size();) {
            int v = Math.abs(aList.get(i)) - Math.abs(bList.get(j));
            if(v > 0)
                j++;
            else if(v < 0)
                i++;
            else {
                if(isFirst == false){
                    isFirst = true;
                    start = aList.get(i);
                }
                else {
                    end = aList.get(i);
                }
                i++;
                j++;
            }
        }
        if(start != Integer.MIN_VALUE && end != Integer.MIN_VALUE) {
            val = (end - start) * (b-a);
            list.add(new Integer[]{start, end});
        }
        return val;
    }
}
/*
[
        {
        "arguments": [5],
        "method": "push",
        "output": null
        },
        {
        "arguments": [],
        "method": "getMin",
        "output": 5
        },
        {
        "arguments": [],
        "method": "getMax",
        "output": 5
        },
        {
        "arguments": [],
        "method": "peek",
        "output": 5
        },
        {
        "arguments": [7],
        "method": "push",
        "output": null
        },
        {
        "arguments": [],
        "method": "getMin",
        "output": 5
        },
        {
        "arguments": [],
        "method": "getMax",
        "output": 7
        },
        {
        "arguments": [],
        "method": "peek",
        "output": 7
        },
        {
        "arguments": [2],
        "method": "push",
        "output": null
        },
        {
        "arguments": [],
        "method": "getMin",
        "output": 2
        },
        {
        "arguments": [],
        "method": "getMax",
        "output": 7
        },
        {
        "arguments": [],
        "method": "peek",
        "output": 2
        },
        {
        "arguments": [],
        "method": "pop",
        "output": -1
        },
        {
        "arguments": [],
        "method": "pop",
        "output": 9
        },
        {

 */