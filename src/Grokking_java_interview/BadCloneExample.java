package Grokking_java_interview;

import java.util.ArrayList;
import java.util.List;

public class BadCloneExample {

    public List<Integer> seen = new ArrayList<>();
    public int current = -1;

    public void add(int newCurrent) {
        seen.add(current);
        current = newCurrent;
    }

    public void clearHistory() {
        seen.clear();
    }

    public BadCloneExample clone() {
        BadCloneExample clone = new BadCloneExample();
        clone.current = current;
        clone.seen = seen;
        return clone;
    }

    public static void main(String[] args)
    {
        BadCloneExample bce = new BadCloneExample();
        bce.add(5);
        bce.add(6);
        BadCloneExample prev = bce.clone();
        // will print [-1, 5]
        System.out.println(prev.seen);
        // clears out the list field
        bce.clearHistory();
        // user sees [] but expects [-1,5]
        System.out.println(prev.seen);
    }
}