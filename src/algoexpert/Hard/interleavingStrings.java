package algoexpert.Hard;

public class interleavingStrings {
    public static void main(String[] args) {
//       String one = "algoexpert";
//        String two = "your-dream-job";
//        String three = "your-algodream-expertjob";

        String one = "aabcc";
        String two = "dbbca";
        String three = "aadbbcbcac";
        System.out.println(interleave(one, two, three));
    }

    public static boolean interleave(String one, String two, String three) {
        // Write your code here.
        if(one.length() + two.length() != three.length())
            return false;

        return interleaveUtils(one, two, three, 0,0);
    }
    public static boolean interleaveUtils(String one, String two, String three, int i, int j) {
        // Write your code here.
        int k = i + j;
        if(k == three.length())
            return true;

        if(i < one.length() && k < three.length() && one.charAt(i) == three.charAt(k)) {
            if(interleaveUtils(one, two, three, i+1, j))
                return true;
        }
        if(j < two.length() && k < three.length() && two.charAt(j) == three.charAt(k)) {
            return interleaveUtils(one, two, three, i, j+1);
        }

        return false;
    }
}
