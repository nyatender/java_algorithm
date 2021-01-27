package SynechronAssignmentJava;

import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class FirstAssignment_2 {

    public static void main(String[] args) throws InterruptedException{
        int N = 10;
        AtomicInteger counter = new AtomicInteger(1);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N);
        ArrayList<Thread> list = new ArrayList<>();
        Object lock = new Object();

        for(int i = 1; i <= N; i++) {
            list.add( new ThreadStartAndFinishedDemo(counter, i, cyclicBarrier, lock));
        }
        list.forEach(item -> item.start());
    }
}

class ThreadStartAndFinishedDemo extends Thread {

    private AtomicInteger counter;
    private int id = 0;
    private CyclicBarrier cyclicBarrier;
    private Object lock;
    ThreadStartAndFinishedDemo(AtomicInteger counter, int id, CyclicBarrier cyclicBarrier, Object lock)
    {
        this.counter = counter;
        this.id = id;
        this.cyclicBarrier = cyclicBarrier;
        this.lock = lock;
    }

    @Override
    public void run()
    {
        System.out.println(" Thread -" + id + " Started ");
        try {
            cyclicBarrier.await();
            synchronized (lock) {
                while (counter.get() != id) {
                    try {
                        lock.wait();
                    } catch (InterruptedException io) {
                    }
                }
                counter.addAndGet(1);
                System.out.println(" Thread -" + id + " Finished ");
                lock.notifyAll();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (BrokenBarrierException ex) {
            ex.printStackTrace();
        }
    }
};
