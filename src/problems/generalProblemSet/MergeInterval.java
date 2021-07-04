package problems.generalProblemSet;

import java.util.*;

public class MergeInterval {

    public static void main(String[] args) {


    }
    List<Interval> merge(ArrayList<Interval>list)
    {
        List<Interval>res = new ArrayList<>();
        if(list.size() == 0)
            return res;
        Iterator it = list.iterator();
        Interval intval = (Interval)it.next();
        res.add(new Interval(intval.start, intval.end));

        while(it.hasNext())
        {
            Interval intvalNext = (Interval)it.next();
            Interval intvalPre = res.get(0);
            int start = intvalNext.start;
            int end = intvalNext.end;
            if(intvalPre.start <= intvalNext.start )
            {
                start = intvalNext.start;
            }
            if(intvalPre.end > intvalNext.end)
            {
                end = intvalNext.end;
            }
        }

        return res;
    }
    void mergeInterval(ArrayList<int[]>Pair)
    {
        Iterator it = Pair.iterator();
        while(it.hasNext()) {
            int[] indexes = (int[])it.next();
            int i = indexes[0];
            int j = indexes[1];
        }
    }
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new LinkedList<Interval>();
        // TODO: Write your code here
        if(intervals.size() == 0 || intervals.size() < 2 )
            return intervals;
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        Iterator<Interval> it = intervals.iterator();
        Interval intval = it.next();
        int start = intval.start;
        int end = intval.end;
        while(it.hasNext())
        {
            intval = it.next();
            if(end >= intval.start) {
                end = Math.max(end, intval.end);
            }
            else
            {
                mergedIntervals.add(new Interval(start, end));
                start = intval.start;
                end = intval.end;
            }
            mergedIntervals.add(new Interval(start, end));
        }
        return mergedIntervals;
    }
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> mergedIntervals = new ArrayList<>();
        //TODO: Write your code here
        Iterator<Interval> it = intervals.iterator();
        while(it.hasNext()) {
            Interval intval = it.next();
            int start = intval.start;
            int end = intval.end;
            if(newInterval.start < end)
            {
                start = Math.min(newInterval.start, start);
                end = Math.max(newInterval.end, end);
            }
        }
        return mergedIntervals;
    }
}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}



