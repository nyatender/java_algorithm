package Grokking_java_interview.Multithreading;
import java.util.concurrent.CountDownLatch;

public class DeadlockDemonstration {

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        try {
            deadLock.runtest();
        } catch (InterruptedException io) {
        }
    }
}

class DeadLock
{
    private int count = 0;
    private Object lock1 = new Object();
    private Object lock2 = new Object();
    private CountDownLatch latch = new CountDownLatch(2);

    Runnable Increment = new Runnable() {
        @Override
        public void run()  {
            try {
                for (int i = 0; i < 10; i++) {
                    IncrementCounter();
                    System.out.println(" decrement" + i);
                }
            }
            catch (InterruptedException io)
            {
            }
        }
    };
    Runnable Decrement = new Runnable() {
        @Override
        public void run() {
            for(int i = 0; i < 10; i++)
            {
                DecrementCounter();
                System.out.println(" increment" + i);
            }
        }
    };

    void IncrementCounter() throws InterruptedException
    {
        synchronized (lock1) {
            latch.countDown();
            System.out.println(" acquire lock1");
            //latch.await();
            synchronized (lock2) {
                count++;
            }
        }
    }
    void DecrementCounter()
    {
        synchronized (lock2) {
            System.out.println("acquire lock2");
            latch.countDown();
            synchronized (lock1) {
                System.out.println(" lock2 acquired");
            }
        }
    }
    void runtest() throws InterruptedException
    {
        Thread t1 = new Thread(Increment);
        Thread.sleep(1000);
        Thread t2 = new Thread(Decrement);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        latch.await();
    }
}
