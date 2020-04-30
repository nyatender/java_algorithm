package Grokking_java_interview.Multithreading;

public class WaitAndNotify {

    static boolean flag = false;
    public static void main( String args[] ) throws InterruptedException {
        Object lock = new Object();

        Thread thread = new Thread(() -> {

            synchronized (lock) {
                while (!flag) {
                    try {
                        System.out.println("thread 1 is about to wait");
                        lock.wait();
                        System.out.println("thread 1 woken up with flag set to " + flag);
                    } catch (InterruptedException ie) {
                        // swallow
                    }
                }
            }
        });

        thread.start();
        Thread.sleep(1000);
        Thread thread2 = new Thread(() -> {

            synchronized (lock) {
                while (!flag) {
                    lock.notify();
                    System.out.println("thread 2 just notified");
                    flag = true;
                }
            }

             try {
                 Thread.sleep(100);
             } catch (InterruptedException ie){
               // swallow
             }

            synchronized (lock) {
                flag = false;
                System.out.println("thread 2 changed flag back to false");
            }
        });

        thread2.start();
        thread2.join();
        thread.join();
        System.out.println("Both the thread finished");
    }
}