package problems;

public class findFirstCapitalAndSmallLetterOccurence {
    public static char getFirstCapitalAndSmall(String input) {

        final int size = 52;
        int[] arr = new int[size];
        int capitalLetterIndex = 0;
        int smallLetterIndex = 0;
        char result = '\0';
        int resultIndex = 0;
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
                smallLetterIndex = input.charAt(i) - 'a';
                capitalLetterIndex = 26 + smallLetterIndex;

                if(arr[capitalLetterIndex] > 0) {
                    resultIndex = capitalLetterIndex;
                    result = (char)('A' + smallLetterIndex);
                    break;
                }
                arr[smallLetterIndex]++;
            }
            else {
                if(input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
                    smallLetterIndex = input.charAt(i) - 'A';
                    capitalLetterIndex = 26 + smallLetterIndex;

                    if(arr[smallLetterIndex] > 0) {
                        resultIndex = capitalLetterIndex;
                        result = (char)('a' + smallLetterIndex);
                        break;
                    }
                    arr[capitalLetterIndex]++;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String input = new String("aaBccaaC"); // c have the first occurence of both small and capital letter
        System.out.println(getFirstCapitalAndSmall(input));
    }
}
