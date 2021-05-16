package algoexpert.Medium;

public class SingleCycleCheck {

    public static boolean hasSingleCycle(int[] array) {
        int numElementsVisited = 0;
        int currentIdx = 0;
        while (numElementsVisited < array.length) {
            if (numElementsVisited > 0 && currentIdx == 0)
                return false;
            numElementsVisited++;
            currentIdx = getNextIdx(currentIdx, array);
        }
        return currentIdx == 0;
    }
    public static int getNextIdx(int currentIdx, int[] array) {
        int jump = array[currentIdx];
        int nextIdx = (currentIdx + jump) % array.length;
        return nextIdx >= 0 ? nextIdx : nextIdx + array.length;
    }

    public static boolean hasSingleCycle_2ndSolution(int[] array) {
        // Write your code here.
        boolean[] visited = new boolean[array.length];
        for(int i = 0; i < array.length; i++)
            System.out.print(visited[i] + " ");
        for(int i = 0; i < array.length; i++) {
            int index = (i + array[i])%array.length;
            index = index < 0 ? array.length + index : index;
            System.out.print(index + " ");
            if(visited[index] == true)
                return false;
            else {
                visited[index] = true;
            }
        }
        int arr[];

        return true;
    }
}