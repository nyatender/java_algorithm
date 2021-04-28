/*
package MyUtils;

import java.util.Arrays;
import java.util.*;

public class ArrayUtil {
    public static void main(String[] args) {
        abc b = new abc();
    }
    static class abc {
        {
            final Vector v;
            v = new Vector();
            System.out.println(" in block");
        }
        public abc() {
            System.out.println(" in const ");
        }
        public void codemethod() {
            //System.out.println(v.);
          //  JSONArray jar = new JSONArray(...);
        }
    }
    //https://www.techiedelight.com/declare-and-initialize-arrays-in-java/
    void arraysUtils() {
        int[] array = new int[]{45, 61, 71, 72, 73, 0, 1, 21, 33, 37};

        //default value pass
        int[] arr = new int[5];
        Arrays.fill(arr, 1);
        System.out.println(Arrays.toString(arr));    // [1, 1, 1, 1, 1]

        //================================================================

        int [][]ar = new int [3][4];

        // Fill each row with 10.
        for (int[] row : ar)
            Arrays.fill(row, 10);

        System.out.println(Arrays.deepToString(ar));
        //================================================================

        int[][][] ar1 = new int[3][4][5];

        // Fill each row with -1.
        for (int[][] row : ar1) {
            for (int[] rowColumn : row) {
                Arrays.fill(rowColumn, -1);
            }
        }

        System.out.println(Arrays.deepToString(ar));

        //=================================================================
        //https://stackoverflow.com/questions/15452429/java-arrays-sort-2d-array
        //Sort 2-D array
        int[][] points = new int[10][10];
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
    }

    void arrayList_To_array() {
        List<String> al = new ArrayList<String>();
        al.add("10");
        al.add("20");
        al.add("30");
        al.add("40");

        String[] arr = new String[al.size()];   //It is therefore recommended to create an array into which elements of
                                                // List need to be stored and pass it as an argument in toArray()
                                                // method to store elements if it is big enough
        arr = al.toArray(arr);

        // Printing array of objects
        for (Object obj : arr)
            System.out.print(obj + " ");
    }
}
*/
