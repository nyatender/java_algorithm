package algoexpert.otherImportantAlgo.TreeViews;

import java.util.Map;
import java.util.TreeMap;

//https://www.geeksforgeeks.org/bottom-view-binary-tree/
class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references

    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}
public class bottomVeiw {
    public static void main(String[] args) {
        Node root = new Node(10);
        findBottomView(root);
    }
    static public void findBottomView(Node root) {
        Map<Integer, Integer[]> map = new TreeMap<>();
        findBottomViewUtils(root, map, 0, 0);
    }
    static public void findBottomViewUtils(Node root,  Map<Integer, Integer[]> map, int level, int horizontalDis) {
        if(root == null)
            return;

        if(!map.containsKey(horizontalDis)) {
            map.put(horizontalDis, new Integer[]{root.data, level});
        }
        else {
            Integer[] val = map.get(horizontalDis);
            if(val[1] <= level) {
                val[0] = root.data;
                val[1] = level;
            }
            map.put(horizontalDis, val);
        }

        findBottomViewUtils(root.left, map, level+1, horizontalDis-1);
        findBottomViewUtils(root.right, map, level+1, horizontalDis+1);
    }
}
