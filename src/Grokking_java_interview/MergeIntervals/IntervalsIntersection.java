package Grokking_java_interview.MergeIntervals;

import java.util.*;


class IntervalsIntersection {

    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> intervalsIntersection = new ArrayList<Interval>();
        // TODO: Write your code here
        Arrays.sort(arr1, (i, j) -> (i.start - j.start));
        Arrays.sort(arr2, (i, j) -> (i.start - j.start));

        int i = 0;
        int j = 0;
        for(; i < Math.min(arr1.length, arr2.length) ; i++ ) {
            if(arr1[i].start <= arr2[j].start && arr1[i].start < arr2[j].end) {
                intervalsIntersection.add(new Interval(Math.max(arr1[i].start,
                            arr2[j].start), Math.min(arr1[i].end, arr2[j].end)));
                i++;
            }
            else if(arr1[i].end < arr2[j].start)
                j++;
            else
                i++;
        }

        return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
    }

    public static void main(String[] args) {
        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
        Interval[] result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
        input2 = new Interval[] { new Interval(5, 10) };
        result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
    }
}
