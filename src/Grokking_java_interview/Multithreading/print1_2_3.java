package Grokking_java_interview.Multithreading;

import java.util.concurrent.locks.Condition;

public class print1_2_3 {
    static private int i = 1;
    static private Object lock = new Object();
    static private Object lock1 = new Object();
    static private Object lock2 = new Object();
    static  private Boolean flag = Boolean.TRUE;
    public static  void main(String[] args) throws InterruptedException
    {
        Thread t1 = new Thread(() -> {
//            while(i < 20 && i % 2 == 0)
//            {
            while (flag) {
                try {
                    lock1.wait();
                    print();
                    lock2.notify();
                } catch (InterruptedException io) {

                }
            }
           // }
        });
        Thread t2 = new Thread(() -> {
//            while(i < 20 && i % 2 != 0)
//            {
            while (flag) {
                try {
                    lock2.wait();
                    print();
                    lock1.notify();
                } catch (InterruptedException io) {
                }
            }
            //}
        });
        t1.start();
        t2.start();

        lock1.notify();
        t1.join();
        t2.join();
        System.out.println("finished");
    }
    static public void print()
    {
        synchronized (lock) {
            System.out.println(i);
            i++;
        }
        if(i > 20)
            flag = false;
    }
}
