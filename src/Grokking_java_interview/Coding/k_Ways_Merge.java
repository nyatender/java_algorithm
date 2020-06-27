package Grokking_java_interview.Coding;

import java.util.PriorityQueue;

public class k_Ways_Merge {
    public static ListNode merge(ListNode[] lists) {
        ListNode result = new ListNode(-1);
        // TODO: Write your code here
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((n1, n2)->n1.value - n2.value);
        for(ListNode root : lists)
            minHeap.offer(root);

        ListNode head = null, tail = null;
        while(!minHeap.isEmpty()) {
            ListNode temp = minHeap.poll();
            if(head == null)
                head = tail = temp;
            else {
                tail.next = temp;
                tail = temp;
            }
            if(temp.next != null)
                minHeap.offer(temp.next);
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);

        ListNode result = merge(new ListNode[] { l1, l2, l3 });
        System.out.print("Here are the elements form the merged list: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}

class ListNode {
    int value;
    ListNode next;

    ListNode(int val) {
        this.value = val;
    }
}