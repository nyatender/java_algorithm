package algoexpert.Easy;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class runLengthEncoding {
    public static void main(String[] args) {
        String input = "AAAAAAAAAAAAABBCCCCDD";
        System.out.println(runLengthEncoding(input));
    }

    static public String runLengthEncoding(String string) {
        // Write your code here.
        if(string.length() < 1)
            return string;
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int i = 1;
        int offset = 0;
        for(; i < string.length(); i++) {
            offset = i-start;
            if(string.charAt(i) == string.charAt(i-1) && offset < 9)
                continue;
            sb.append(Integer.toString(offset));
            sb.append(string.charAt(i-1));
            start = i;
        }
        offset =  string.length() - start;
        sb.append(Integer.toString(offset));
        sb.append(string.charAt(string.length() - 1));

        return sb.toString();
    }
}
