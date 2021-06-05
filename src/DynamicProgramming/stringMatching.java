package DynamicProgramming;

public class stringMatching {
    public static void main(String[] args) {
        String a = "abcde";
        String b = "xbdez";

        System.out.println(commonStringMatching(a, b));

    }

    static String commonStringMatching(String a, String b) {

        int[][] table = new int[a.length()+1][b.length()+1];

        int i = 1;
        int j = 1;
        for(; i < a.length()+1; i++) {
            j = 1;
            for(; j < b.length()+1; j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                }
                else
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
            }
        }
        i--;
        j--;
        // traverse in matrix back to find the common string
        StringBuilder result = new StringBuilder();
        while(i > 0 && j > 0) {
            if(table[i][j] == table[i][j-1])
                j--;
            else if(table[i][j] == table[i-1][j])
                i--;
            else if(table[i][j] > table[i-1][j-1]) {
                result.append(Character.toString(a.charAt(i-1)));
                i--;
                j--;
            }
        }
        result = result.reverse();
        return result.toString();
    }
}
