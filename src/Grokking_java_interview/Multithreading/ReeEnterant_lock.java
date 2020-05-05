package Grokking_java_interview.Multithreading;

import java.util.concurrent.locks.ReentrantLock;

/*
The following runnable snippet shows how an IllegalMonitorStateException is raised when a reentrant lock
 is attempted to be locked and unlocked by two different threads.
 */
public class ReeEnterant_lock {
    public static void main( String args[] ) throws InterruptedException {
        MisuseOfReentrantLock misuse = new MisuseOfReentrantLock();

        try {
            Thread thread1 = new Thread(() -> misuse.method1());
            Thread.sleep(100);
            Thread thread2 = new Thread(() -> misuse.method2());
            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();
        }
        catch(InterruptedException io)
        {

        }


    }
}

class MisuseOfReentrantLock {
    private Boolean flag = true;
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Object lock = new Object();

    public void method1() {

       // synchronized (lock) {
            reentrantLock.lock();
            while (flag) {
                try {
                    Thread.sleep(1000);
                    flag = false;
                } catch (InterruptedException ie) {
                    // Don't ignore in production
                }
            }
           // reentrantLock.unlock();
            System.out.println("Thread 1 finishes successfully");
       // }
    }

    public void method2() {

       // synchronized (lock) {
            //if(reentrantLock.isLocked())
                reentrantLock.unlock();

            // Never gets printed
            System.out.println("Thread 2 finishes successfully");
       // }
    }
}