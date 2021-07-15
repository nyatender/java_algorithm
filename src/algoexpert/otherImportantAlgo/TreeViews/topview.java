package algoexpert.otherImportantAlgo.TreeViews;

import java.util.Map;
import java.util.TreeMap;

//https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
public class topview {
    public static void main(String[] args) {
        Node root = new Node(10);
        findBottomView(root);
    }
    static public void findBottomView(Node root) {
        Map<Integer, Integer> map = new TreeMap<>();
        findBottomViewUtils(root, map, 0);
    }
    static public void findBottomViewUtils(Node root,  Map<Integer, Integer> map, int horizontalDis) {
        if(root == null)
            return;

        if(!map.containsKey(horizontalDis)) {
            map.put(horizontalDis, root.data);
        }

        findBottomViewUtils(root.left, map,  horizontalDis-1);
        findBottomViewUtils(root.right, map, horizontalDis+1);
    }
}