package problems;

public class searchInSortedAndRotated {

    public static void main(String[] args) {
        int[] arr = new int[] { 5,6,7,1,2,3,4};
        int index = SearchElement(arr, 0, arr.length-1, 5);
        System.out.println(index);
    }
    // 4 5 1 2 3
    public static int SearchElement(int[] arr, int low, int high, int key)
    {
        if(low >= high || low < 0 || high >= arr.length)
            return -1;
        int mid = low + (high - low) /2;
        if(key == arr[mid])
            return mid;
        if(arr[low] < arr[mid])
        {
            if(key < arr[mid] && key >= arr[low])
            {
                return SearchElement(arr, low, mid, key);
            }
            else
            {
                return SearchElement(arr, mid+1, high, key);
            }
        }
        else {
            if(key > arr[mid] && key <= arr[high])
            {
                return SearchElement(arr, mid+1, high, key);
            }
            else
            {
                return SearchElement(arr, low, mid, key);
            }
        }
    }
}
