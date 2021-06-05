package algoexpert.Hard;

public class interleavingStrings {
    public static void main(String[] args) {
       String one = "algoexpert";
        String two = "your-dream-job";
        String three = "your-algodream-expertjob";

        System.out.println(interleavingDP(one, two, three));

//        String one = "aabcc";
//        String two = "dbbca";
//        String three = "aadbbcbcac";
 //       System.out.println(interleave(one, two, three));
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

    public static boolean interleavingDP(String one, String two, String three) {
        if (three.length() != one.length() + two.length()) {
            return false;
        }
        Boolean[][] cache = new Boolean[one.length() + 1][two.length() + 1];
        return areInterwoven(one, two, three, 0, 0, cache);
    }

    public static boolean areInterwoven(
            String one, String two, String three, int i, int j, Boolean[][] cache) {
        if (cache[i][j] != null) return cache[i][j];
        int k = i + j;
        if (k == three.length()) {
            return true;
        }
        if (i < one.length() && one.charAt(i) == three.charAt(k)) {
            cache[i][j] = areInterwoven(one, two, three, i + 1, j, cache);
            if (cache[i][j]) return true;
        }
        if (j < two.length() && two.charAt(j) == three.charAt(k)) {
            var result = areInterwoven(one, two, three, i, j + 1, cache);
            cache[i][j] = result;
            return result;
        }
        cache[i][j] = false;
        return false;
    }

    public static boolean areInterwovenByTushar(String one, String two, String three) {

        if(one.length() + two.length() != three.length()){
            return false;
        }
        int row = one.length() + 1;
        int col = two.length() + 1;

        boolean[][] dp = new boolean[row][col];
        for(int i = 0; i < row; i++)
            dp[i][0] = true;
        for(int i = 0; i < col; i++)
            dp[0][i] = true;

        int k = 0;
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < row; j++) {
                k = i+j-1;
                if(one.charAt(i-1) == three.charAt(k-1) && dp[i-1][j]) {
                    dp[i][j] = true;
                }
                else if(two.charAt(j-1) == three.charAt(k-1) && dp[i][j-1]) {
                    dp[i][j] = true;
                }
                else
                    dp[i][j] = false;
            }
        }

        return dp[one.length()][two.length()];

    }
}
