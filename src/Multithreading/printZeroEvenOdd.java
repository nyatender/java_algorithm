package Multithreading;

class PrintNumberSeries {
    int n;
    int i = 1;
    boolean isOdd = true;
    boolean isZero = true;

    public PrintNumberSeries(int n) {
        this.n = n;
    }

    void PrintZero() throws InterruptedException {

        synchronized (this) {
            while(i < n) {
                while (!isZero) {
                    this.wait();
                }
                System.out.println(" 0 ");
                isZero = !isZero;
                this.notifyAll();
            }
        }
    }

    void PrintEven() throws InterruptedException {

        synchronized (this) {
            while(i < n) {
                while (isZero || isOdd == true ) {
                    this.wait();
                }
                System.out.println(" " + i + " ");
                isOdd = !isOdd;
                isZero = !isZero;
                i++;
                this.notifyAll();
            }
        }
    }

    void PrintOdd() throws InterruptedException {

        synchronized (this) {
            while(i < n) {
                while (isZero || isOdd == false ) {
                    this.wait();
                }
                System.out.println(" " + i + " ");
                isOdd = !isOdd;
                isZero = !isZero;
                i++;
                this.notifyAll();
            }
        }
    }
}

enum Type {
    ZERO,
    EVEN,
    ODD
}

class printZeroEvenOddThread extends Thread {
    PrintNumberSeries printNumberSeries;
    Type type;
    printZeroEvenOddThread(PrintNumberSeries printNumberSeries, Type type) {
        this.printNumberSeries = printNumberSeries;
        this.type = type;
    }

    public void run() {
        if(type.equals(Type.ZERO)) {
            try {
                printNumberSeries.PrintZero();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals(Type.EVEN)) {
            try {
                printNumberSeries.PrintEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals(Type.ODD)) {
            try {
                printNumberSeries.PrintOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class printZeroEvenOdd {
    public static void main(String[] args) {
        PrintNumberSeries printNumberSeries = new PrintNumberSeries(5);

        printZeroEvenOddThread t1 = new printZeroEvenOddThread(printNumberSeries, Type.ZERO);
        printZeroEvenOddThread t2 = new printZeroEvenOddThread(printNumberSeries, Type.EVEN);
        printZeroEvenOddThread t3 = new printZeroEvenOddThread(printNumberSeries, Type.ODD);

        t1.start();
        t2.start();
        t3.start();
    }
}
