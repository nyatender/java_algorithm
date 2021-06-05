package algoexpert.Hard;
import java.util.PriorityQueue;


// All test cases passed

public class continiousMedian {
    static class median {
        private PriorityQueue<Integer> pMin = new PriorityQueue<>((i, j) -> (i - j));
        private PriorityQueue<Integer> pMax = new PriorityQueue<>((i, j) -> (j - i));

        public void insert(int number) {

            //add in min heap if empty
            if(pMin.size() == 0) {
                pMin.add(number);
                return;
            }

            // add in max heap if number is less than min heap peek
            // else add in max heap
            if (pMin.peek() >= number) {
                pMax.add(number);
            }
            else {
                pMin.add(number);
            }

            //balance the heap
            if(pMax.size() > pMin.size()) {
                int item = pMax.poll();
                pMin.add(item);
            }
            else if(pMin.size() - 1 > pMax.size()) {
                int item = pMin.poll();
                pMax.add(item);
            }
        }
        public double getMedian() {
            double median =  0;
            if(pMin.size() == 0)
                return median;
            if(pMax.size() == pMin.size()) {
                median = ((double)pMin.peek() + (double) pMax.peek())/2;
            }
            else {
                median = pMin.peek();
            }

            return median;
        }
    }
    public static void main(String[] args) {
        int[] arr = { 5, 10, 100, 200, 6, 13 };
        median obj = new median();

        for(int i : arr) {
            obj.insert(i);
            System.out.println(i + " inserted ");
            System.out.println(" Median : " + obj.getMedian());
        }

    }


}
