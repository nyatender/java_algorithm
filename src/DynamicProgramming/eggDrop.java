package DynamicProgramming;

public class eggDrop {
    public static void main(String[] args) {
        int eggs = 2;
        int floors = 10;
    }
    public static int eggDropRecursive(int eggs, int floors)
    {
        if(eggs <= 0)
            return 0;

        if(floors == 1 || floors == 0)
            return floors;

        if(eggs == 1)
            return floors;

        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= floors; i++) {
            int maxVal = Math.max(eggDropRecursive(eggs-1, i-1),
                                  eggDropRecursive(eggs, floors-i));
            ans = Math.min(maxVal, ans);
        }

        return ans + 1;
    }
};