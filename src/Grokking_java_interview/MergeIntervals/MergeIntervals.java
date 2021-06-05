package Grokking_java_interview.MergeIntervals;

import java.util.*;
/*
Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.
 */
class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

class MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new LinkedList<Interval>();
        if(intervals.size() <= 1)
            return intervals;

        Collections.sort(intervals, (a, b) -> a.start - b.start);

        int sizeOfList = intervals.size();
        int s = 0;
        mergedIntervals.add(intervals.get(0));
        for(int i = 1; i < sizeOfList; i++) {
            Interval second = intervals.get(i);
            if (mergedIntervals.get(s).end > second.start) {
                if (mergedIntervals.get(s).end < second.end)
                    mergedIntervals.get(s).end = second.end;
                continue;
            }
            mergedIntervals.add(second);
            s++;
        }

        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(7, 9));
        input.add(new Interval(2, 5));

        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
