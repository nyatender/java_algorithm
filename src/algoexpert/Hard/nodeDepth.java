package algoexpert.Hard;

import java.util.HashMap;
import java.util.Map;

public class nodeDepth {
    public static int allKindsOfNodeDepths(BinaryTree root) {
        // Write your code here.
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = allKindsOfNodeDepthsUtils(map, root.left, 2);
        int right = allKindsOfNodeDepthsUtils(map, root.right, 3);
        int sum = 0;
        /*for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // map.forEach((k,v) -> {sum += sum + v;});
        }*/
        for(Integer entry : map.values()) {
            sum += entry;
        }
        return sum;
    }
    static int allKindsOfNodeDepthsUtils(HashMap<Integer, Integer> map, BinaryTree root, int level) {

        if(root == null)
            return 0;

        int left = allKindsOfNodeDepthsUtils(map, root, (level-1)*2);
        int right = allKindsOfNodeDepthsUtils(map, root, (level*2) + 1);

        if(left+right > 0)
            map.put(level, (left+right));

        return left+right;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
