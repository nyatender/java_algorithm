import java.util.ArrayList;
import java.util.List;

public class spiralTravalsal {

    public static List<Integer> spiralTraverse(int[][] array) {
        ArrayList<Integer> result = new ArrayList<>();

        var R = array.length;
        var C = array[0].length;
        var rStart = 0;
        var rEnd = R - 1;
        var cStart = 0;
        var cEnd = C-1;
        while(rStart <= rEnd && cStart <= cEnd) {
            for(int c = cStart; c < cEnd; c++) {
                result.add(array[rStart][c]);
            }
            for(int r = rStart + 1; r < rEnd; r++) {
                result.add(array[r][cEnd]);
            }
            for(int c = cEnd - 1; c >= cStart; c--) {
                if(rStart == rEnd)
                    break;
                result.add(array[rEnd][c]);
            }
            for(int r = rEnd - 1; r > rStart; r--) {
                if(cStart == cEnd)
                    break;
                result.add(array[r][cStart]);
            }
            rStart++;
            rEnd--;
            cStart++;
            cEnd--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2,  3,  4, 101},
                {5, 6,  7,  8, 102},
                {9,10, 11, 12, 103},
                {13,14,15, 16, 104}
        };
        List<Integer> result = spiralTraverse(arr);
        for(int i = 0; i < result.size(); i++)
            System.out.print(result.get(i) + " ");
        //result.forEach(item -> System.out::println(item));
    }
}
