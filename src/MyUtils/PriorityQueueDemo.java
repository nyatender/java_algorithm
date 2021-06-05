package MyUtils;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueDemo {
    public static void main(String[] args) {
//        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
//            public int compare(Integer o1, Integer o2) {
//                return (int) (o1 - o2);
//            }
//        });
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(( o1,  o2) -> (o1 - o2));

        for(int i = 0 ; i < 5; i++) {
            Random rand = new Random();
            int num = rand.nextInt(100);
            System.out.println(num + " added ");
            queue.add(num);
        }

        System.out.println(" \nprint Queue");
        queue.forEach(i -> System.out.print(i + " "));

        System.out.println(" \n\nQueue popped values");
        for(int i = 0 ; i < 5; i++) {
            System.out.print(queue.peek() + " ");
            queue.poll();
        }

    }
}
