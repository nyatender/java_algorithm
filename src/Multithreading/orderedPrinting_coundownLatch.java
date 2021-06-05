package Multithreading;

import java.util.concurrent.CountDownLatch;

class orderPrinting1 {
    private int i = 0;
    CountDownLatch l1;
    CountDownLatch l2;

    orderPrinting1(CountDownLatch l1, CountDownLatch l2) {
        this.l1 = l1;
        this.l2 = l2;
    }

    public void printFirst() throws InterruptedException {
        System.out.println(" First ");
        i++;
        l1.countDown();
    }

    public void printSecond() throws InterruptedException {
        l1.await();
        System.out.println(" Second ");
        i++;
        l2.countDown();
    }

    public void printThird() throws InterruptedException {
        l2.await();
        System.out.println(" Third ");
        i++;
    }
};

public class orderedPrinting_coundownLatch {
    public static void main(String[] args) {
        CountDownLatch l1 = new CountDownLatch(1);
        CountDownLatch l2 = new CountDownLatch(1);

        orderPrinting1 obj = new orderPrinting1(l1, l2);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.printFirst();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.printSecond();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.printThird();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
