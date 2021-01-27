package algoexpert;
import java.util.*;

public class threeNumSum {
    public static void main(String[] args) {
        int arr[] = new int[] {12,3,1,2,-6,5,-8,6};
        threeNumberSum(arr, 0);
    }
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        HashMap<Integer, ArrayList<Integer>>sumArray = new HashMap<>();
        Arrays.sort(array);
        List ls = Arrays.asList(array);
        System.out.println(ls);
        ArrayList<Integer[]> result = new ArrayList<Integer[]>();
        int last = array.length - 1;
        for(int i = 0; i < last-1; i++) {
            int S = i + 1;
            int L = last - 1;
            while(S < L) {
                if(array[i] < array[S] + array[L])
                    S++;
                else if(array[i] > array[S] + array[L])
                    L--;
                else {
                    Integer[] arr = {array[i], array[S], array[L]};
                    result.add(arr);
                    if(S < (last -1) && arr[S] == arr[S+1])
                        S++;
                    else if(L > (i + 1) && arr[L] == arr[L-1])
                        L--;
                    else {
                        S++;
                        L--;
                    }
                }
            }
        }
        return result;
    }
}