package walMartPreparation;
import java.util.*;

class Interval {
    int start = 0;
    int end = 0;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class IntervalNode {
    Interval interval;
    int index;
    IntervalNode(Interval interval, int index) {
        this.interval = interval;
        this.index = index;
    }
}

class MyComparator implements Comparator<IntervalNode> {
    public int compare(IntervalNode n1, IntervalNode n2) {
        return n1.interval.end - n2.interval.start;
    }
}
public class nextInterval {
    public static int[] findNextInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        PriorityQueue<IntervalNode>queue = new PriorityQueue<IntervalNode>(new MyComparator());
        // TODO: Write your code here
        int i = 0;
        for(Interval intv : intervals) {
            queue.offer(new IntervalNode(intv, i));
            i++;
        }
        while(!queue.isEmpty()) {
            IntervalNode item = queue.poll();

            if(!queue.isEmpty())
                result[item.index] = queue.peek().index;
            else
                result[item.index] = -1;

        }
        return result;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[] { new Interval(2, 3), new Interval(3, 4), new Interval(5, 6) };
        int[] result = nextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
        System.out.println();

        intervals = new Interval[] { new Interval(3, 4), new Interval(1, 5), new Interval(4, 6) };
        result = nextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
    }
}