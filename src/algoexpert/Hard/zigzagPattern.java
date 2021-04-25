package algoexpert.Hard;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class zigzagPattern {
    public static void main(String[] args) {
        List<List<Integer>> array = new ArrayList<>();
        array.add(Arrays.asList(1, 3, 4, 10));
        array.add(Arrays.asList(2, 5, 9, 11));
        array.add(Arrays.asList(6, 8, 12, 15));
        array.add(Arrays.asList(7, 13, 14, 16));
        zigzagTraverse(array).forEach(val -> System.out.print(val + " "));
    }
    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        // Write your code here.
        ArrayList<Integer[]> dir = new ArrayList<>() {
            {
                add(new Integer[]{-1,-1});
                add(new Integer[]{0,1});
                add(new Integer[]{1,1});
                add(new Integer[]{1,0});
            };
        };
        //System.out.println(array.size() + " " + array.get(0).size());
        int dIndex = 0;
        int i = 0;
        int j = 0;
        ArrayList<Integer>result = new ArrayList<>();
        //System.out.println(array.get(0).get(0));
        //while(i < array.size() && j < array.get(0).size()) {
        while(result.size() !=  array.size() * array.get(0).size()) {
          //  j = j + dir.get(dIndex).getValue();
            if(isSafe(i , j , array.size(), array.get(0).size())) {
              //  System.out.println(array.get(i).get(j));
                result.add(array.get(i).get(j));
                if(dIndex % 2 == 1) {
                    dIndex++;
                    dIndex %= dir.size();
                }
                if(isSafe(i + dir.get(dIndex)[0],
                        j + dir.get(dIndex)[1], array.size(), array.get(0).size())) {
                    i = i + dir.get(dIndex)[0];
                    j = j + dir.get(dIndex)[1];
                }
                else {
                    dIndex++;
                    dIndex %= dir.size();
                    i = i + dir.get(dIndex)[0];
                    j = j + dir.get(dIndex)[1];
                }
            }
            else {
                dIndex++;
                dIndex %= dir.size();
                i = i + dir.get(dIndex)[0];
                j = j + dir.get(dIndex)[1];
            }
        }
        return result;
    }
    static boolean isSafe(int r, int c, int R, int C) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}
