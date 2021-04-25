
import java.util.concurrent.Semaphore;

class orderPrinting2 {

    Semaphore s1 = new Semaphore(1);
    Semaphore s2 = new Semaphore(0);
    Semaphore s3 = new Semaphore(0);

    orderPrinting2() {

    }

    public void printFirst() throws InterruptedException {
        s1.acquire();
        System.out.println(" First ");
        s2.release();
    }

    public void printSecond() throws InterruptedException {
        s2.acquire();
        System.out.println(" Second ");
        s3.release();
    }

    public void printThird() throws InterruptedException {
        s3.acquire();
        System.out.println(" Third ");
        s1.release();
    }
};

public class OrderedPrintingUsingSemaphore {
    public static void main(String[] args) {

        orderPrinting2 obj = new orderPrinting2();

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
