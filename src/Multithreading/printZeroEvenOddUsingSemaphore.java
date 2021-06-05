package Multithreading;

import java.util.concurrent.Semaphore;

class printEvenOddZeroSeries {
    private int n;
    private int i = 1;
    private boolean isEven = true;

    Semaphore semZero = new Semaphore(1);
    Semaphore semOdd = new Semaphore(0);
    Semaphore semEven = new Semaphore(0);

    printEvenOddZeroSeries(int n) {
        this.n = n;
    }

    void printZero() throws InterruptedException {
        while(i < n) {
            semZero.acquire();
            System.out.println(" 0 ");
            if(isEven)
                semOdd.release();
            else
                semEven.release();
            isEven = !isEven;
        }
    }

    void printEven() throws InterruptedException {
        while(i < n) {
            semEven.acquire();
            System.out.println(" " + i + " ");
            i++;
            semZero.release();
        }
    }
    void printOdd() throws InterruptedException {
        while(i < n) {
            semOdd.acquire();
            System.out.println(" " + i + " ");
            i++;
            semZero.release();
        }
    }
}
enum Types {
    ZERO,
    EVEN,
    ODD
}
class PrintInSeries extends Thread {
    printEvenOddZeroSeries obj;
    Types type;

    PrintInSeries(printEvenOddZeroSeries obj, Types type) {
        this.obj = obj;
        this.type = type;
    }

    public void run() {
        if(type.equals(Types.ZERO)) {
            try {
                obj.printZero();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals(Types.EVEN)) {
            try {
                obj.printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals(Types.ODD)) {
            try {
                obj.printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class printZeroEvenOddUsingSemaphore {
    public static void main(String[] args) {
        printEvenOddZeroSeries obj = new printEvenOddZeroSeries(5);

        PrintInSeries t1 = new PrintInSeries(obj, Types.ZERO);
        PrintInSeries t2 = new PrintInSeries(obj, Types.ODD);
        PrintInSeries t3 = new PrintInSeries(obj, Types.EVEN);

        t1.start();
        t2.start();
        t3.start();

    }
}

