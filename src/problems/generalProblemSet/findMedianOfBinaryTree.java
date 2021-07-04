package problems.generalProblemSet;
//https://www.geeksforgeeks.org/find-median-bst-time-o1-space/
class Node {
    public int val;
    public Node left;
    public Node right;

    Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}
public class findMedianOfBinaryTree {
    static Node insert(Node node, int key)
    {
        /* If the tree is empty, return a new node */
        if (node == null)
            return new Node(key);

        /* Otherwise, recur down the tree */
        if (key < node.val)
            node.left = insert(node.left, key);
        else if (key > node.val)
            node.right = insert(node.right, key);

        /* return the (unchanged) node pointer */
        return node;
    }
    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 50);
        insert(root, 30);
        insert(root, 20);
        insert(root, 40);
        insert(root, 70);
        insert(root, 60);
        insert(root, 80);

        System.out.println(findMedian(root));
    }
    static int countNode(Node root) {
        int count = 0;
        while(root != null) {
            if(root.left == null) {
                count++;
                root = root.right;
            }
            else {
                Node leftRoot = root.left;
                while(leftRoot.right != null && leftRoot.right != root)
                    leftRoot = leftRoot.right;
                if(leftRoot.right == null) {
                    leftRoot.right = root;
                    root = root.left;
                }
                else {
                    leftRoot.right = null;
                    count++;
                    root = root.right;
                }
            }
        }

        return count;
    }

    static double findMedian(Node curr ) {
        Node root = curr;
        int count = countNode(root);
        if(count == 0)
            return 0;
        int countNodes = 0;
        Node previous = root;
        Node leftRoot = null;
        while(root != null) {
            if(root.left == null) {
                countNodes++;
                //even
                if(count % 2 == 0 && countNodes == (count/2)+1)
                    return (previous.val + root.val)/2;
                else if(count % 2 != 0 && countNodes == (count+1)/2)
                    return previous.val;
                previous = root;
                root = root.right;
            }
            else {
                leftRoot = root.left;
                while(leftRoot.right != null && leftRoot.right != root)
                    leftRoot = leftRoot.right;
                if(leftRoot.right == null) {
                    leftRoot.right = root;
                    root = root.left;
                }
                else {
                    leftRoot.right = null;
                    previous = leftRoot;
                    countNodes++;
                    if(count % 2 == 0 && countNodes == (count/2)+1)
                        return (previous.val + root.val)/2;
                    else if(count % 2 != 0 && countNodes == (count+1)/2)
                        return root.val;
                    previous = root;
                    root = root.right;
                }
            }
        }
        return root.val;
    }
}


