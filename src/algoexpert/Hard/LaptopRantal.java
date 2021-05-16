package algoexpert.Hard;
import java.util.*;

public class LaptopRantal {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> times = new ArrayList<>();
        times.add(new ArrayList<>(Arrays.asList(0, 2)));
        times.add(new ArrayList<>(Arrays.asList(1,4)));
        times.add(new ArrayList<>(Arrays.asList(4,6)));
        times.add(new ArrayList<>(Arrays.asList(0, 4)));
        times.add(new ArrayList<>(Arrays.asList(7, 8)));
        times.add(new ArrayList<>(Arrays.asList(9, 11)));
        times.add(new ArrayList<>(Arrays.asList(3, 10)));

        System.out.println(laptopRentals(times));
    }

    // O(nlog(n)) time | O(n) space - where n is the number of times
    static int laptopRentals(ArrayList<ArrayList<Integer>> times) {
        // Write your code here.
        if (times.size() == 0) {
            return 0;
        }

        Collections.sort(times, (a, b) -> Integer.compare(a.get(0), b.get(0)));
        PriorityQueue<ArrayList<Integer>> heap = new PriorityQueue<ArrayList<Integer>>(new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return (int) (o1.get(1) - o2.get(1));
            }
        });
        heap.add(times.get(0));
        for (int idx = 1; idx < times.size(); idx++) {
            ArrayList<Integer> currentInterval = times.get(idx);
            if (heap.peek().get(1) <= currentInterval.get(0)) {
                heap.remove();
            }
            heap.add(currentInterval);
        }
        return heap.size();
    }
}
