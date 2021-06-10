package algoexpert.veryHard;
/*
Node Swap
Write a function that takes in the head of a Singly Linked List, swaps every pair of
adjacent nodes in place (i.e., doesn't create a brand new list), and returns its new head.
If the input Linked List has an odd number of nodes, its final node should remain the
same.
Each LinkedList node has an integer value as well as a next node pointing to
the next node in the list or to None / null if it's the tail of the list.
You can assume that the input Linked List will always have at least one node; in other
words, the head will never be None / null .
Sample Input
head = 0 -> 1 -> 2 -> 3 -> 4 -> 5 // the head node with value 0
Sample Output
1 -> 0 -> 3 -> 2 -> 5 -> 4 // the new head node with value 1
 */
public class nodeSwap {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList nodeSwap(LinkedList head) {
        // Write your code here.
        if(head == null || head.next == null)
            return head;

        LinkedList first = head;
        LinkedList second = head.next;
        while(first != null && second != null) {
            swap(first, second);
            first = first.next;

            if(first != null)
                first = first.next;

            second = second.next;
            if(second != null)
                second = second.next;
        }
        return head;
    }
    void swap(LinkedList p1, LinkedList p2) {
        int val = p1.value;
        p1.value = p2.value;
        p2.value = val;
    }
}