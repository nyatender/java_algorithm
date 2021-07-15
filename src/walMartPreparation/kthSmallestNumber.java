package walMartPreparation;

public class kthSmallestNumber {
    public static void main(String[] args) {
        //findKthSmallestNumber();
    }


    public static int findKthSmallestNumber(int[] nums, int k) {
        return findKthSmallestNumberRec(nums, k, 0, nums.length - 1);
    }

    static int findKthSmallestNumberRec(int[] nums, int k, int start, int end) {

        int partition = findPartition(nums, start, end);

        int smallestKIndex = k-1;

        if(k-1 < partition)
            return findKthSmallestNumberRec(nums, k, start, partition-1);

        return findKthSmallestNumberRec(nums, k, partition+1, end);
    }
    static int findPartition(int[] nums, int start, int end) {

        if(start == end)
            return start;

        int pivot = nums[end];

        for(int i = start; i < end; i++ ) {
            if(nums[i] < pivot) {
                swap(nums, start++, i);
            }
        }
        swap(nums, start, end);
        return start;
    }
    static void swap(int[] nums, int s, int e) {
        int temp = nums[s];
        nums[s] = nums[e];
        nums[e] = temp;
    }
}