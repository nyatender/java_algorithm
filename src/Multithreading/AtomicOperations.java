package Multithreading;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicOperations {

    static class Counter {
        private AtomicInteger c = new AtomicInteger(0);
        private AtomicBoolean b = new AtomicBoolean(false);
        private AtomicLong l = new AtomicLong(0l);

        public void increment() {
            c.getAndIncrement();
        }

        public int value() {
            return c.get();
        }
    }

    public static void main(final String[] arguments) throws InterruptedException {
        final Counter counter = new Counter();

        //1000 threads
        for(int i = 0; i < 1000 ; i++) {

            new Thread(new Runnable() {
                public void run() {
                    counter.increment();
                }
            }).start();
        }
        Thread.sleep(6000);
        System.out.println("Final number (should be 1000): " + counter.value());
    }
}