package algoexpert.Hard;

public class subarraySort {
    public static void main(String[] args) {

    }
    public static int[] subarraySort(int[] array) {
        // Write your code here.
        int beginIndex = -1;
        int endIndex = -1;
        int i = 1;
        for(; i < array.length; i++) {
            if(array[i] > array[i-1])
                continue;
            else
                break;
        }
        if(i == array.length)
            return new int[] {beginIndex, endIndex};
        int j = i-1;
        for(; j >= 0; j--) {
            if(array[j] >= array[i])
                continue;
            else
                break;
        }
        beginIndex = j+1;

        i = array.length - 1;
        for(; i >= 0; i--) {
            if(array[i] > array[i-1])
                continue;
            else
                break;
        }

        j = i+1;
        for(; j < array.length - 1; j++) {
            if(array[j] < array[i])
                continue;
            else
                break;
        }
        endIndex = j;

        return new int[] {beginIndex, endIndex};
    }
}
