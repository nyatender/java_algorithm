package MyUtils;

import javafx.util.Pair;

import java.util.ArrayList;

public class PairUtils {
    public static void main(String[] args) {
        PairInJava();
    }

    public static void PairInJava() {
        //==================================================================

        Pair p1 = new Pair(3, 4);
        Pair p2 = new Pair(3, 4);
        Pair p3 = new Pair(4, 4);

        System.out.println(p1.equals(p2) + " " + p2.equals(p3));
        //==================================================================

        //==================================================================
        ArrayList<Pair<String, Integer>> ArrOfPairs = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        // Pair to store the maximum marks of a
        // student with its name
        Pair<String, Integer> ans = new Pair<String, Integer>("", 0);

        // Using for each loop to iterate array of
        // Pair Objects
        for (Pair<String, Integer> temp : ArrOfPairs) {
            // Get the score of Student
            int val = temp.getValue();

            // Check if it is greater than the previous
            // maximum marks
            if (val > max) {
                max = val;  // update maximum
                ans = temp; // update the Pair
            }
        }
        //==================================================================
    }
}
