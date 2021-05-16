package algoexpert.Hard;

public class minimumJumpToRechEnd {
    public static void main(String[] args) {
        int[] array = {3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3};

        System.out.println(minJump1(array));
        System.out.println(minJump2(array));
    }

    static int minJump1(int[] array) {

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

    public static int minJump2(int[] array) {

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
