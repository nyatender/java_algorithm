package test;

public class Print_0_1_2 {
    public Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        Print_0_1 objPrint = new Print_0_1();
        Print_0_1_ obj = new Print_0_1_(objPrint.lock, 12);
        obj.printEvenOdd();
    }
}

class Print_0_1_ {
    private Object lock = new Object();
    int flag = 0;
    int n = 5;
    int count = 1;
    Print_0_1_(Object mlock, int n)
    {
        lock = mlock;
        this.n = n;
    }
    public void printEvenOdd() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(count < n) {
                    synchronized (lock) {
                        while (flag == 1 || flag == 2) {
                            try {
                                lock.wait();
                            } catch (Exception ex) {

                            }
                        }
                        flag = 1;
                        if(count <= n)
                            System.out.println(count++);
                        lock.notifyAll();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(count < n) {
                    synchronized (lock) {
                        while (flag == 0 || flag == 2) {
                            try {
                                lock.wait();
                            } catch (Exception ex) {
                            }
                        }
                        flag = 2;
                        if(count <= n)
                            System.out.println(count++);
                        lock.notifyAll();
                    }
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(count < n) {
                    synchronized (lock) {
                        while (flag == 0 || flag == 1) {
                            try {
                                lock.wait();
                            } catch (Exception ex) {
                            }
                        }
                        flag = 0;
                        if(count <= n)
                            System.out.println(count++);
                        lock.notifyAll();
                    }
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

    }
}
