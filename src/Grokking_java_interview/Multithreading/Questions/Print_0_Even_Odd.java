package Grokking_java_interview.Multithreading.Questions;

import java.util.concurrent.Semaphore;

public class Print_0_Even_Odd {
    public static  void main(String args[])
    {
        PrintFooAndBar funObj = new PrintFooAndBar(10);

        ThreadForPrintingFooAndBar thread1 = new ThreadForPrintingFooAndBar(funObj, "Even");
        ThreadForPrintingFooAndBar thread2 = new ThreadForPrintingFooAndBar(funObj, "Odd");
        ThreadForPrintingFooAndBar thread3 = new ThreadForPrintingFooAndBar(funObj, "One");

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println(" finished ");
    }
}

class ThreadForPrintingFooAndBar extends Thread {

    PrintFooAndBar obj;
    private String Method;
    ThreadForPrintingFooAndBar(PrintFooAndBar funObj, String Method)
    {
        this.Method = Method;
        this.obj = funObj;
    }

    @Override
    public void run()
    {
        if("Even".equals(Method))
        {
            obj.Even();
        }
        else if("Odd".equals(Method))
        {
            obj.Odd();
        }else if("One".equals(Method))
        {
            obj.One();
        }
    }

};

class PrintFooAndBar {

    private int flag = 0;
    private int count = 0;
    private int num = 1;
    private Semaphore OddSem = new Semaphore(0);
    private Semaphore EvenSem = new Semaphore(0);
    private Semaphore ZeroSem = new Semaphore(1);

    PrintFooAndBar(int n)
    {
        count = n;
    }
    public void Even()
    {
       for(int i = 2; i <= count; i += 2)
        {
            try {
                EvenSem.acquire();
            }
            catch (InterruptedException io)
            {
            }
            System.out.println(i);
            ZeroSem.release();
        }
    }
    public void Odd()
    {
        for(int i = 1; i <= count; i += 2)
        {
            try {
                OddSem.acquire();
            }
            catch (InterruptedException io)
            {
            }
            System.out.println(i);
            ZeroSem.release();
        }
    }

    public void One()
    {
        for(int i = 1; i <= count; i++)
        {
            try {
                ZeroSem.acquire();
            }
            catch (InterruptedException io)
            {
            }
            System.out.println("0");
            (i%2 == 0 ? EvenSem : OddSem).release();
        }
    }
}
