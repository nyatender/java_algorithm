package walMartPreparation;

import java.util.HashMap;

public class maxUniqueString {
    public static void main(String[] args) {
        String input = "abcacfceg";
    }
    static String maxUniqueString(String input) {

        HashMap<Character, Integer> visited = new HashMap<>();
        char[] arr = input.toCharArray();
        int maxLength = 0;
        int preIndex = 0;
        int[] indexRange = new int[]{0,0};
        for(int i = 0; i < arr.length; i++) {
            if(visited.containsKey(arr[i])) {
                maxLength = Math.max(maxLength, i-preIndex);
                indexRange[0] = preIndex;
                indexRange[1] = i;
                if(visited.get(arr[i]) > preIndex)
                    preIndex = visited.get(arr[i])+1;
            }
            else {
               if(maxLength < i-preIndex+1) {
                   maxLength = i-preIndex+1;
                   indexRange[0] = preIndex;
                   indexRange[1] = i;
               }
            }
            visited.put(arr[i], i);
        }
        return input.substring(indexRange[0], indexRange[1]+1);
    }

}
