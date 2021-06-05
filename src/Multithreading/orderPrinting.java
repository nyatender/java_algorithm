package Multithreading;


public class orderPrinting {
    private int i = 0;
    private Object lock; // = new Object();
    orderPrinting(Object lock) {
        this.lock = lock;
    }
    public void printFirst() throws InterruptedException {
        synchronized (lock) {
            while (i != 0) {
                lock.wait();
            }
            System.out.println(" First ");
            i++;
            lock.notifyAll();
        }

    }
    public void printSecond() throws InterruptedException {
        synchronized (lock) {
            while (i != 1) {
                lock.wait();
            }
            System.out.println(" Second ");
            i++;
            lock.notifyAll();
        }
    }
    public void printThird() throws InterruptedException {
        synchronized (lock) {
            while (i != 2) {
                lock.wait();
            }
            System.out.println(" Third ");
            i++;
            lock.notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        orderPrinting obj = new orderPrinting(lock);
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    obj.printFirst();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    obj.printSecond();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t3 = new Thread() {
            @Override
            public void run() {
                try {
                    obj.printThird();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(" main exist");
    }
}

