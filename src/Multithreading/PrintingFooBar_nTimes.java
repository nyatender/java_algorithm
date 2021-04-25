import java.util.concurrent.Semaphore;

class PrintFooBar {
    int n;
    volatile boolean isPrint = false;
    private Semaphore sem1 = new Semaphore(1);
    private Semaphore sem2 = new Semaphore(1);
    PrintFooBar(int n) {
        this.n = n;
    }
    void printFoo() throws InterruptedException {
        for(int i = 0; i < n; i++) {
            //sem1.release();
            synchronized (this) {
                while(isPrint) {
                    this.wait();
                }
                System.out.println(" FOO ");
                isPrint = !isPrint;
                this.notifyAll();
                //sem2.release();
            }
        }
    }
    void printBar() throws InterruptedException {
        for(int i = 0; i < n; i++) {
//            sem2.acquire();
//            System.out.println(" BAR ");
//            sem1.release();
            synchronized (this) {
                while(!isPrint) {
                    this.wait();
                }
                System.out.println(" BOO ");
                isPrint = !isPrint;
                this.notifyAll();
                //sem2.release();
            }
        }
    }
}
enum threadType {
    FOO,
    BAR
}

class printFooBarInOrder extends Thread {
    PrintFooBar threadObj;
    threadType name;
    printFooBarInOrder(PrintFooBar obj, threadType name) {
        this.threadObj = obj;
        this.name = name;
    }
    public void run() {
        if(threadType.FOO == name) {
            try {
                threadObj.printFoo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if(threadType.BAR == name) {
            try {
                threadObj.printBar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class PrintingFooBar_nTimes {
    public static void main(String[] args) {
        PrintFooBar obj = new PrintFooBar(5);
        printFooBarInOrder fooThread = new printFooBarInOrder(obj, threadType.FOO);
        printFooBarInOrder barThread = new printFooBarInOrder(obj, threadType.BAR);

        fooThread.start();
        barThread.start();

    }
}
