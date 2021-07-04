package problems.generalProblemSet;

public class findMinElementInsortedAndRotatedArray {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4};
        int res = findMin(arr, 0, arr.length-1);
        System.out.println(res);
    }
    static int findMin(int[] arr, int low, int high) {
        if(low > high)
            return arr[0];

        if(arr[low] == arr[high])
            return arr[low];

        int mid = low + (high-low) /2;

        if(mid < high && arr[mid] > arr[mid+1]) {
            return arr[mid+1];
        }
        if(mid > low && arr[mid] < arr[mid-1]) {
            return arr[mid];
        }
        if(arr[mid] < arr[high]) {
            return findMin(arr, low, mid-1);
        }
        else {
            return findMin(arr, mid+1, high);
        }
    }
}
