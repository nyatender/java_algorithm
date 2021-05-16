package test;

public class minimumNoOfJump {
    public static void main(String[] args) {
        int[] array = {3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3};

        System.out.println(minJump(array));
    }

    public static int minJump(int[] array) {

        if(array.length == 1)
            return 0;
        int jumps = 0;
        int maxReach = array[0];
        int steps = array[0];

        if(steps == 0)
            return 0;

        for(int i = 1; i < array.length-1; i++) {

            maxReach = Math.max(maxReach, i + array[i]);

            steps--;

            if(steps == 0) {
                jumps++;

                if(maxReach <= 0)
                    return -1;

                steps = maxReach - i;
            }
        }

        return jumps+1;
    }
}
//4 // 3 --> (4 or 2) --> (2 or 3) --> 7 --> 3