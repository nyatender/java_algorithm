package test;

public class Print_0_1 {
    public Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        Print_0_1 objPrint = new Print_0_1();
        sync obj = new sync(objPrint.lock);
        obj.printEvenOdd();
    }
}

class sync {
    private Object lock = new Object();
    int flag = 0;
    int n = 5;
    int count = 0;
    sync(Object mlock)
    {
        lock = mlock;
    }
    public void printEvenOdd() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < n; i++) {
                    synchronized (lock) {
                        while (flag == 0) {
                            try {
                                lock.wait();
                            } catch (Exception ex) {

                            }
                        }
                        flag = 0;
                        System.out.println("0");
                        lock.notifyAll();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < n; i++) {
                    synchronized (lock) {
                        while (flag == 1) {
                            try {
                                lock.wait();
                            } catch (Exception ex) {
                            }
                        }
                        flag = 1;
                        System.out.println("1");
                        lock.notifyAll();
                    }
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
