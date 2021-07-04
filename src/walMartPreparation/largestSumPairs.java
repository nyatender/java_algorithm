package walMartPreparation;
import java.util.*;


public class largestSumPairs {

    static class Node {
        int first;
        int second;
        int sum;
        public Node(int first, int second, int sum) {
            this.first = first;
            this.second = second;
            this.sum = sum;
        }
    }
    public static List<int[]> findKLargestPairs(int[] nums1, int[] nums2, int k) {
        if(k > nums1.length || k > nums2.length)
            return new ArrayList<>();

        List<int[]> result = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((n1, n2) -> (n1[0] + n1[1]) - (n2[0] + n2[1]));

        for(int i = 0; i < nums1.length && i < k; i++) {
            for(int j = 0; j < nums2.length && j < k; j++) {
                if(minHeap.size() < k) {
                    minHeap.add(new int[]{nums1[i], nums2[j]});
                }
                else {
                    int[] peek = minHeap.peek();
                    if((nums1[i] + nums2[j]) < peek[0] + peek[1])
                        break;
                    else {
                        minHeap.poll();
                        minHeap.add(new int[]{nums1[i], nums2[j]});
                    }
                }
            }
        }
        result.addAll(minHeap);

        return result;
    }

    public static void main(String[] args) {
        int[] l1 = new int[] { 9, 8, 2 };
        int[] l2 = new int[] { 6, 3, 1 };
        List<int[]> result = largestSumPairs.findKLargestPairs(l1, l2, 3);
        System.out.print("Pairs with largest sum are: ");
        for (int[] pair : result)
            System.out.print("[" + pair[0] + ", " + pair[1] + "] ");
    }
}
