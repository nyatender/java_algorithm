package algoexpert.veryHard;

public class LinkedListPalimdrome {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
    void printList(LinkedList root) {
        for(LinkedList i = root; i != null; i = i.next)
            System.out.print(" " + i.value);
        System.out.println();
    }

    public boolean linkedListPalindrome(LinkedList head) {
        // Write your code here.
        if(head == null)
            return false;
        if(head.next == null)
            return true;

        if(head.next.next == null) {
            if(head.value == head.next.value)
                return true;
            else
                return false;
        }

        LinkedList fast = head;
        LinkedList slow = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        LinkedList toReverse = slow.next;
        toReverse = reverseList(toReverse);
        System.out.println("after reverse ");
        printList(toReverse);
        LinkedList temp = head;

        while(toReverse != null) {
            if(temp.value == toReverse.value) {

                temp = temp.next;
                toReverse = toReverse.next;
                continue;
            }
            else
                return false;
        }

        return true;
    }

    LinkedList reverseList(LinkedList root) {
        LinkedList currNode = root;
        LinkedList nextNode = root.next;

        currNode.next = null;
        while(nextNode != null) {
            LinkedList nextOfNext = nextNode.next;
            nextNode.next = currNode;

            currNode = nextNode;
            nextNode = nextOfNext;
        }
        root = currNode;
        return root;
    }
}