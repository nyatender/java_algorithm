package test;

import java.util.concurrent.Semaphore;

public class Print_0_1_using_semaphre {
    public Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        SharedPrint sp = new SharedPrint(5);
        Thread t1 = new Thread(new printEven(sp, 5));
        Thread t2 = new Thread(new printOdd(sp, 5));
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

class SharedPrint {
    int n = 5;
    int count = 0;
    Semaphore evenSem = new Semaphore(1);
    Semaphore oddSem = new Semaphore(0);
    SharedPrint(int n)
    {
        this.n = n;
    }
    public void printOdd() throws InterruptedException {
        oddSem.acquire();
        if(count <= n)
            System.out.println(" odd " + count++);
        evenSem.release();
    }
    public void printEven() throws InterruptedException {
        evenSem.acquire();
        if(count <= n)
            System.out.println(" even " + count++);
        Thread.sleep(1000);
        oddSem.release();
    }
}
    class printEven implements Runnable{
    private SharedPrint sp;
    private  int n;
    printEven(SharedPrint sp, int n)
    {
        this.sp = sp;
        this.n = n;
    }
    @Override
    public void run() {
        for (int i = 0; i < n; i++)
        {
            try {
                sp.printEven();
            }
            catch (Exception ex) {
            }
        }
    }
    }
class printOdd implements Runnable{
    private SharedPrint sp;
    int n;
    printOdd(SharedPrint sp, int n)
    {
        this.sp = sp;
        this.n = n;
    }
    @Override
    public void run() {
        for (int i = 0; i < n; i++)
        {
            try {
                sp.printOdd();
            }
            catch (Exception ex) {
            }
        }
    }
}
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(count < n) {
//                    synchronized (lock) {
//                        while (flag == 1 || flag == 2) {
//                            try {
//                                lock.wait();
//                            } catch (Exception ex) {
//
//                            }
//                        }
//                        flag = 1;
//                        if(count <= n)
//                            System.out.println(count++);
//                        lock.notifyAll();
//                    }
//                }
//            }
//        });
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(count < n) {
//                    synchronized (lock) {
//                        while (flag == 0 || flag == 2) {
//                            try {
//                                lock.wait();
//                            } catch (Exception ex) {
//                            }
//                        }
//                        flag = 2;
//                        if(count <= n)
//                            System.out.println(count++);
//                        lock.notifyAll();
//                    }
//                }
//            }
//        });
//        Thread t3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(count < n) {
//                    synchronized (lock) {
//                        while (flag == 0 || flag == 1) {
//                            try {
//                                lock.wait();
//                            } catch (Exception ex) {
//                            }
//                        }
//                        flag = 0;
//                        if(count <= n)
//                            System.out.println(count++);
//                        lock.notifyAll();
//                    }
//                }
//            }
//        });
//
//        t1.start();
//        t2.start();
//        t3.start();
//
//        t1.join();
//        t2.join();
//        t3.join();
