package Grokking_java_interview.Coding;

import java.util.PriorityQueue;

public class TwoHeap {
}

class MedianOfAStream {

    public void insertNum(int num) {
        // TODO: Write your code here
    }

    public double findMedian() {
        // TODO: Write your code here
        return -1;
    }

    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        // TODO: Write your code here
        int i = 0;
        double sum = 0;
        while(i < k)
            sum += nums[i++];
        while(i < nums.length)
        {
            result[i-k] = sum/k;
            sum -= nums[i-k];
            sum += nums[i++];
        }
        result[i-k] = sum/k;
        return result;
    }
    public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
        int n = capital.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(n, (a, b) -> capital[a] - capital[b] );
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(n, (a, b) -> profits[b] - profits[a] );

        int i = 0;
        while(i < n)
        {
            minHeap.add(capital[i++]);
        }
        i = 0;
        int avalibaleCapital = initialCapital;
        while(i < numberOfProjects)
        {
            while(!minHeap.isEmpty() && capital[minHeap.peek()] <= avalibaleCapital)
                maxHeap.offer(minHeap.poll());

            if(maxHeap.isEmpty())
                return -1;

            avalibaleCapital += maxHeap.poll();
            i++;
        }

        return avalibaleCapital;
    }

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}