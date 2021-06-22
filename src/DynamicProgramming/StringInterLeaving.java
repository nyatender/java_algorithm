package DynamicProgramming;

public class StringInterLeaving {
    public static void main(String[] args) {
        StringInterLeaving si = new StringInterLeaving();
        System.out.println(si.findSI("abd", "cef", "abcdef"));
        System.out.println(si.findSI("abd", "cef", "adcbef"));
        System.out.println(si.findSI("abc", "def", "abdccf"));
        System.out.println(si.findSI("abcdef", "mnop", "mnaobcdepf"));
    }
    public boolean findSI(String m, String n, String p) {
        // TODO: Write your code here
        return findSIUtils(m, n, p, 0, 0);
    }
    public boolean findSIUtils(String m, String n, String p, int i, int j) {
        int k = i + j;

        if(k >= p.length())
            return true;

        if(i < m.length() && m.charAt(i) == p.charAt(k)) {
            if(findSIUtils(m, n, p, i+1, j))
                return true;
        }
        if(j < n.length() && n.charAt(j) == p.charAt(k)) {
            return findSIUtils(m, n, p, i, j+1);
        }

        return false;
    }
}
