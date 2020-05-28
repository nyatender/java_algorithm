package MyUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;

//https://www.geeksforgeeks.org/queue-interface-java/
//https://stackoverflow.com/questions/2703984/what-is-the-difference-between-the-add-and-offer-methods-in-a-queue-in-java
public class QueueImp {
    public static void main(String args[])
    {

    }
    public void QueueFunctionality()
    {
        Queue<Integer> q = new LinkedList<Integer>();

        // Adds elements {0, 1, 2, 3, 4} to queue
        for (int i=0; i<5; i++)
            q.add(i);

        // Display contents of the queue.
        System.out.println("Elements of queue-"+q);

        // To remove the head of queue.
        int removedele = q.remove();
        System.out.println("removed element-" + removedele);

        System.out.println(q);

        // To view the head of queue
        int head = q.peek();
        System.out.println("head of queue-" + head);

        // Rest all methods of collection interface,
        // Like size and contains can be used with this
        // implementation.
        int size = q.size();
        System.out.println("Size of queue-" + size);
    }
    public void priorityQueueFunc()
    {
        // Creating an empty PriorityQueue
        PriorityQueue<String> queue = new PriorityQueue<String>();

        // Use add() method to add elements into the Queue
        queue.add("Welcome");
        queue.add("To");
        queue.add("Geeks");
        queue.add("4");
        queue.add("Geeks");

        // Displaying the PriorityQueue
        System.out.println("Initial PriorityQueue: " + queue);

        // Inserting using offer()
        queue.offer("The");
        queue.offer("Priority");
        queue.offer("Class");

        // Displaying th final Queue
        System.out.println("Priority queue after Insertion: " + queue);
    }
}
