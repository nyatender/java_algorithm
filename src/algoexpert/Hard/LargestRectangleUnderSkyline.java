package algoexpert.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
Largest Rectangle Under Skyline
Write a function that takes in an array of positive integers
representing the heights of adjacent buildings and returns
the area of the largest rectangle that can be created by any
number of adjacent buildings, including just one building.
Note that all buildings have the same width of 1 unit.
For example, given buildings = [2, 1, 2] , the area
of the largest rectangle that can be created is 3 , using all
three buildings. Since the minimum height of the three
buildings is 1 , you can create a rectangle that has a height
of 1 and a width of 3 (the number of buildings). You
could also create rectangles of area 2 by using only the
first building or the last building, but these clearly wouldn't
be the largest rectangles. Similarly, you could create
rectangles of area 2 by using the first and second building
or the second and third building.
To clarify, the width of a created rectangle is the number of
buildings used to create the rectangle, and its height is the
height of the smallest building used to create it.
Note that if no rectangles can be created, your function
should return 0 .
Sample Input
buildings = [1, 3, 3, 2, 4, 1, 5, 3, 2]
Sample Output
9
// Below is a visual representation of the sample
              5
          4   _
    3 3   _  | |3
    _ _ 2| | | |_ 2
  1| | |_| | | | |_
  _| | | | |_| | | |
 |_|_|_|_|_|_|_|_|_|

Run or submit code
when you're ready.
Tests
Custom Output Submit Code
N
 */
public class LargestRectangleUnderSkyline {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 3, 3, 2, 4, 1, 5, 3, 2));
        System.out.println(largestRectangleUnderSkyline(input));
    }
    // O(n) time | O(n) space - where n is the number of buildings
    public static int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
        Stack<Integer> pillarIndices = new Stack<Integer>();
        int maxArea = 0;
        ArrayList<Integer> extendedBuildings = new ArrayList<Integer>(buildings);
        extendedBuildings.add(0);
        for (int idx = 0; idx < extendedBuildings.size(); idx++) {
            int height = extendedBuildings.get(idx);
            while (!pillarIndices.isEmpty() && extendedBuildings.get(pillarIndices.peek()) >= height) {
                int pillarHeight = extendedBuildings.get(pillarIndices.pop());
                int width = (pillarIndices.isEmpty()) ? idx : idx - pillarIndices.peek() - 1;
                maxArea = Math.max(width * pillarHeight, maxArea);
            }
            pillarIndices.push(idx);
        }
        return maxArea;
    }
}
