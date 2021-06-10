package algoexpert.veryHard;
import java.util.*;

/*
Rectangle Mania
Write a function that takes in a list of Cartesian coordinates (i.e., (x, y) coordinates) and
returns the number of rectangles formed by these coordinates.
A rectangle must have its four corners amongst the coordinates in order to be counted,
and we only care about rectangles with sides parallel to the x and y axes (i.e., with
horizontal and vertical sides--no diagonal sides).
You can also assume that no coordinate will be farther than 100 units from the origin.

Sample Input
coords = [
 [0, 0], [0, 1], [1, 1], [1, 0],
 [2, 1], [2, 0], [3, 1], [3, 0],
]

Sample Output
6

 */

public class RectangleMania {
    public static void main(String[] args) {
        List<Integer[]> input = new ArrayList<>(Arrays.asList(
                new Integer[]{0, 0},
                new Integer[]{0, 1},
                new Integer[]{1, 1},
                new Integer[]{1, 0},
                new Integer[]{2, 1},
                new Integer[]{2, 0},
                new Integer[]{3, 1},
                new Integer[]{3, 0}));

        System.out.println(rectangleMania(input));
    }

    static String UP = "up";
    static String RIGHT = "right";
    static String DOWN = "down";
    static String LEFT = "left";

    // O(n^2) time | O(n^2) space - where n is the number of coordinates
    public static int rectangleMania(List<Integer[]> coords) {
        Map<String, Map<String, List<Integer[]>>> coordsTable = getCoordsTable(coords);
        return getRectangleCount(coords, coordsTable);
    }

    public static Map<String, Map<String, List<Integer[]>>> getCoordsTable(List<Integer[]> coords) {

     Map<String, Map<String, List<Integer[]>>> coordsTable = new HashMap<String, Map<String, List<Integer[]>>>();

     for (Integer[] coord1 : coords) {
        Map<String, List<Integer[]>> coord1Directions = new HashMap<String, List<Integer[]>>();
        coord1Directions.put(UP, new ArrayList<Integer[]>());
        coord1Directions.put(RIGHT, new ArrayList<Integer[]>());
        coord1Directions.put(DOWN, new ArrayList<Integer[]>());
        coord1Directions.put(LEFT, new ArrayList<Integer[]>());
        for (Integer[] coord2 : coords) {
            String coord2Direction = getCoordDirection(coord1, coord2);
            if (coord1Directions.containsKey(coord2Direction))
                coord1Directions.get(coord2Direction).add(coord2);
        }
        String coord1String = coordToString(coord1);
        coordsTable.put(coord1String, coord1Directions);
    }
    return coordsTable;
}
    public static String getCoordDirection(Integer[] coord1, Integer[] coord2) {
        if (coord2[1] == coord1[1]) {
            if (coord2[0] > coord1[0]) {
                return RIGHT;
            } else if (coord2[0] < coord1[0]) {
                return LEFT;
            }
        } else if (coord2[0] == coord1[0]) {
            if (coord2[1] > coord1[1]) {
                return UP;
            } else if (coord2[1] < coord1[1]) {
                return DOWN;
            }
        }
        return "";
    }
    public static int getRectangleCount(List<Integer[]> coords, Map<String, Map<String, List<Integer[]>>> coordsTable) {
        int rectangleCount = 0;
        for (Integer[] coord : coords) {
            rectangleCount += clockwiseCountRectangles(coord, coordsTable, UP, coord);
        }
        return rectangleCount;
    }

    public static int clockwiseCountRectangles(Integer[] coord,Map<String, Map<String,
                                               List<Integer[]>>> coordsTable, String direction, Integer[] origin) {
        String coordString = coordToString(coord);
        if (direction == LEFT) {
            boolean rectangleFound = coordsTable.get(coordString).get(LEFT).contains(origin);
            return rectangleFound ? 1 : 0;
        } else {
            int rectangleCount = 0;
            String nextDirection = getNextClockwiseDirection(direction);
            for (Integer[] nextCoord : coordsTable.get(coordString).get(direction)) {
                rectangleCount += clockwiseCountRectangles(nextCoord, coordsTable, nextDirection, origin);
            }
            return rectangleCount;
        }
    }
    public static String getNextClockwiseDirection(String direction) {
        if (direction == UP) return RIGHT;
        if (direction == RIGHT) return DOWN;
        if (direction == DOWN) return LEFT;
        return "";
    }
    public static String coordToString(Integer[] coord) {
        return Integer.toString(coord[0]) + "-" + Integer.toString(coord[1]);
    }

}