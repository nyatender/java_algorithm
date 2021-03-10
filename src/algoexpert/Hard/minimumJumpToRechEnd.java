package algoexpert.Hard;

public class minimumJumpToRechEnd {
    public static void main(String[] args) {

    }

    int minJump(int[] array) {

        int jump = 0;
        if(array[0] == 0)
            return -1;

        int maxReach = array[0];
        int steps = array[0];

        if(maxReach >= array.length-1)
            return 1;

        for(int i = 0; i < array.length; i++ ) {

            if(i == array.length-1)
                return jump;
            maxReach = array[i];
            steps--;
            if(steps == 0) {
                jump++;

                if(maxReach <= i)
                    return -1;

                steps = maxReach - i;
            }
        }
        return -1;
    }
}
