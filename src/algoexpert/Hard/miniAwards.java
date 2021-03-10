package algoexpert.Hard;

public class miniAwards {
    public static void main(String[] args) {

    }
    public static int minRewards(int[] scores) {
        // Write your code here.
        int minVal = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0 ; i < scores.length; i++) {
            if(scores[i] < minVal) {
                minVal = scores[i];
                minIndex = i;
            }
        }
//        for(int i = minIndex ; i < scores.length; i) {
//
//        }
        int total = scores.length;
        int count = 1;
        int nextMax = 1;
        int index = minIndex;
        while(--total > 0) {
            if(index > 0) {
                if(scores[index-1] > scores[index])
                    nextMax++;
                else
                    nextMax = 1;
            }
            count += nextMax;
        }
        return -1;
    }
}
