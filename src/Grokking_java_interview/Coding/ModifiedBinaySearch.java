package Grokking_java_interview.Coding;

public class ModifiedBinaySearch {

    public static void main(String[] args) {
        /*
        {
            System.out.println(search(new int[]{4, 6, 10}, 10));
            System.out.println(search(new int[]{1, 2, 3, 4, 5, 6, 7}, 5));
            System.out.println(search(new int[]{10, 6, 4}, 10));
            System.out.println(search(new int[]{10, 6, 4}, 4));
        }
        */

//        {
//            int[] result = findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
//            System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
//            result = findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
//            System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
//            result = findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
//            System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
//        }
    }

    public static int search(int[] arr, int key) {
        int low = 0;
        int high = arr.length-1;
        int index = -1;
        int mid = -1;
        while(low <= high)
        {
            mid = low+(high-low)/2;
            if(arr[mid] == key)
            {
                return mid;
            }
            else if(arr[low] <= arr[mid] )
            {
                if(key < arr[mid])
                    high = mid-1;
                else
                    low = mid+1;
            }
            else {
                if(key > arr[mid])
                    high = mid-1;
                else
                    low = mid+1;
            }
        }

        return index;
    }

}

