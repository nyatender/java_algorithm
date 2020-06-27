package test;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerCunsumer {

    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> Qu = new LinkedList<>();
        Producer t3 = new Producer(Qu, 5);
        Thread th = new Thread(t3);
        Thread t1 = new Thread(new Producer(Qu, 5));
        Thread t2 = new Thread(new Consumer(Qu));
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

class Producer implements Runnable {
    private final Queue<Integer> Qu;
    private  int num;
    Producer(Queue<Integer> Qu, int n)
    {
        this.Qu = Qu;
        this.num = n;
    }
    @Override
    public void run()
    {
        for(int i = 0 ;i < num; i++)
        {
            synchronized (Qu) {
                while(!Qu.isEmpty())
                {
                    try {
                        Qu.wait();
                    }
                    catch (Exception ex)
                    {

                    }
                }
                Qu.offer(i);
                Qu.notifyAll();
                System.out.println("produce " + i);
            }
        }
    }
}

class Consumer implements Runnable {
    private final Queue<Integer> Qu;
    Consumer(Queue<Integer> Qu)
    {
        this.Qu = Qu;
    }
    @Override
    public void run()
    {
        while(true)
        {
            synchronized (Qu) {
                while(Qu.isEmpty())
                {
                    try {
                        Qu.wait();
                    }
                    catch (Exception ex)
                    {

                    }
                }
                int i = Qu.poll();
                Qu.notifyAll();
                System.out.println("Consumed " + i);
            }
        }
    }
}
