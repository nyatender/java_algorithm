package problems.hakerank;

public class StriclyModify {
    public static void main(String[] args) {

    }

    static public boolean makeStriclyIncreasing(int[] arr) {

        int i = 1;
        while(i < arr.length) {
            if(arr[i] < arr[i-1]) {
                break;
            }
            if(arr[i] == arr[i-1])
                return false;
            i++;
        }

        if(i == arr.length)
            return true;

        int low = 0;
        int high = i;
        if(i >= 2)
            low = i - 2;

        if(low == 0) {
            if (arr[1] >= 1)
                return true;
            else
                return false;
        }
        if(arr[high] - arr[low] <= 1)
            return false;

//        int diff = arr[low] + 1;
//        while(diff > arr[high]) {
//            if(diff > arr[low] && diff < arr[high])
//                return true;
//            diff -= 1;
//        }
        return true;
    }
}
