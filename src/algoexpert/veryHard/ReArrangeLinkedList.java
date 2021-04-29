package algoexpert.veryHard;

public class ReArrangeLinkedList {
    public static void main(String[] args) {
        //  12 -> 13 -> 15 -> 4 -> 9 -> 5 -> 3
        //  4 -> 12 -> 13 -> 15 -> 9 -> 5 -> 3

        // input :
        // 3 -> 0 -> 5 -> 2 -> 1 -> 4    k = 3
        // O/P :
        // 0 -> 2 -> 1 -> 3 -> 5 -> 4

        // test1 case input
        // 3 -> 0 -> 5 -> 2 -> 1 -> 4    k = 3
        // O/P :
        // 0 -> 2 -> 1 -> 3 -> 5 -> 4

        // test2 case input
        //0 -> 3 ->  1 -> 4 -> 5 -> 3 -> -1 -> -2 -> 3 -> 6 -> 7 -> 3 -> 2 -> -9000 and k = 2
        //O/P
        // 0 -> 1 -> -1 -> -2 -> -9000 -> 2 -> 2 -> 3 -> 4 -> 5 -> 3 -> 3 -> 6 -> 7 -> 3
        LinkedList head = new LinkedList(3);
        head.next = new LinkedList(0);
        head.next.next = new LinkedList(5);
        head.next.next.next = new LinkedList(2);
        head.next.next.next.next = new LinkedList(1);
        head.next.next.next.next.next = new LinkedList(4);
        printList(head);
        head = rearrangeLinkedList(head, 3);
        printList(head);
    }
    static public void printList(LinkedList head) {
        System.out.println(" print ");
        for(LinkedList i = head; i != null; i = i.next)
            System.out.print(i.value + " ");
        System.out.println();
    }
    public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
        // Write your code here.
        LinkedList curr = head;
        LinkedList preFromPivot = null;

        for(; curr != null; curr = curr.next) {
            if(curr.value >= k) {
                break;
            }
            preFromPivot = curr;
        }

        LinkedList pre = curr;
        curr = curr.next;
        for(; curr != null; ) {
            if(curr.value <= k) {
                LinkedList nextNode = curr.next;
                detachCurrentNode(pre);
                if(preFromPivot == null) {

                    curr.next = head;
                    head = curr;

                    preFromPivot = head;
                    curr = nextNode;

                    continue;
                }
                else {
                    //preFromPivot = addBeforePivotNode(preFromPivot, curr);
                    LinkedList temp = preFromPivot.next;
                    preFromPivot.next = curr;
                    curr.next = temp;

                    if(curr.value != k)
                        preFromPivot = curr;
                }
                curr = nextNode;
                continue;
            }
            pre = curr;
            curr = curr.next;
        }

        return head;
    }
    static void detachCurrentNode(LinkedList preFromPivot) {
        if(preFromPivot != null) {
            preFromPivot.next = preFromPivot.next.next;
        }
    }
    static LinkedList addBeforePivotNode(LinkedList preFromPivot, LinkedList tobeAdd) {
        LinkedList temp = preFromPivot.next;
        preFromPivot.next = tobeAdd;
        tobeAdd.next = temp;

        return tobeAdd;
    }


    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }
}