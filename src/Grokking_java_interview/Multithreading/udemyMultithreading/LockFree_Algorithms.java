package Grokking_java_interview.Multithreading.udemyMultithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class LockFree_Algorithms {
}

class IntegerAtomicity {

    static public void getIncrement() {
        int initialVal = 0;
        AtomicInteger atomicInt = new AtomicInteger(initialVal);
        int delta = 5;
        atomicInt.addAndGet(delta);
        atomicInt.getAndAdd(delta);
        atomicInt.decrementAndGet();

    }

    public static void main(String[] args) throws InterruptedException {
        AtomicOperations obj = new AtomicOperations();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 1000; i++)
                    obj.increment();
            }
        });
        //t1.setDaemon(true);
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 1000; i++)
                    obj.decrement();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(obj.getVal());
    }

}

class AtomicOperations {
    private AtomicInteger item = new AtomicInteger(0);
    public void increment() {
        item.getAndIncrement();
    }
    public void decrement() {
        item.getAndDecrement();
    }
    public int getVal() {
        return item.get();
    }
}
