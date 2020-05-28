package problems;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class removeDuplicate {
    public static void main(String[] args) {

        int [] arr = new int [] { 2,3,3,6,9,9};
        //int res = removeDuplicate.removeDup(arr);
        ArrayList<ArrayList<Integer>> res1 =
                removeDuplicate.getListOfArraysSumLessThanTarget(new int[]{2, 5, 3, 10}, 30);
        res1.forEach(item -> System.out.println(Arrays.toString(item.toArray())) );
       // System.out.println(res1);
    }

    public static int removeDup(int [] arr)
    {
        int res = 1;
        for(int i = 1; i < arr.length; i++)
        {
            if(arr[res-1] != arr[i]) {
                arr[res] = arr[i];
                res++;
            }
            System.out.print(Arrays.toString(arr));
            System.out.println(res);
        }

        return res;
    }
    public int removeArrDupWithGivenKey(int[]arr, int key)
    {
        //[3, 2, 3, 6, 3, 10, 9, 3]
        int index = 0;
        for(int i = 0 ; i < arr.length; i++)
        {
            if(arr[index] != key) {
                arr[index] = arr[i];
                index++;
            }
        }
        return index+1;
    }
    public static ArrayList<ArrayList<Integer>> getListOfArraysSumLessThanTarget(int[] arr, int target)
    {
        //int index = 0;
        //2, 5, 3, 10   => 30
        ArrayList<ArrayList<Integer>>res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer>resTemp = new ArrayList<>();
        int product = arr[0];
        int startIndex = 0;
        if(product < target) {
            resTemp.add(arr[0]);
            res.add(new ArrayList<Integer>(arr[0]));
        }
        for(int endIndex = 1; endIndex < arr.length; endIndex++)
        {
            product *= arr[endIndex];
            if(arr[endIndex] < target) {
                res.add(new ArrayList<Integer>(arr[endIndex]));
            }

            if(product < target) {
                resTemp.add(arr[endIndex]);
            }
            else
            {

               // if(resTemp.size() > 0) {
                ArrayList<Integer>resTemp1 = new ArrayList<>();
               // resTemp1 = resTemp.clone();
                res.add(resTemp);
                //resTemp = new ArrayList<>();
                resTemp = resTemp1;
               // resTemp.setDob()
                resTemp.add(arr[endIndex]);
                //}
                int j = 0;
                while(resTemp.size() > 0 && product > target )
                {
                    product /= resTemp.get(j);
                    resTemp.remove(j);
                    j++;
                }
               // product = arr[endIndex];
            }
        }
        return res;
    }
    public static void DutchFlag(int[] arr)
    {
        int low = 0, high = arr.length -1;
        for(int i = 0; i<high;)
        {
            if(arr[i] == 0)
            {
                swap(arr, low, i);
                low++;
                i++;
            }
            else if(arr[i] == 1)
            {
                i++;
            }
            else
            {
                swap(arr, low, high);
                high--;
            }
        }
    }
    static void swap(int[] arr, int i, int j)
    {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
