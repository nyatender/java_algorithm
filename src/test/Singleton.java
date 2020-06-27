package test;

import java.util.Scanner;

public class Singleton {
    private Singleton() {}
    private static class SingltonHolder {
        private final static Singleton instance = new Singleton();
    }
    public static Singleton getInstance()
    {
        return SingltonHolder.instance;
    }
    public static void main(String[] args) throws InterruptedException {
       // Singleton instance = Singleton.getInstance();
        final PC pc = new PC();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.producer();
                }
                catch (InterruptedException  ex)
                {
                    ex.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    pc.consumer();
                }
                catch (InterruptedException  ex)
                {
                    ex.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

class PC {

    public void producer() throws InterruptedException
    {
        synchronized (this)  {
            System.out.println(" producer waiting ");
            wait();
            System.out.println(" resumed ");
        }
    }

    public void consumer() throws InterruptedException
    {
        Thread.sleep(1000);
        Scanner sc = new Scanner(System.in);
        synchronized (this)  {
            System.out.println(" waiting for return ");
            sc.nextLine();
            System.out.println(" returned ");
            notify();
        }
    }
}

