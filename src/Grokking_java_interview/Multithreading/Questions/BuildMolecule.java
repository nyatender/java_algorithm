package Grokking_java_interview.Multithreading.Questions;

import java.util.concurrent.Semaphore;

public class BuildMolecule {
    public static  void main(String args[])
    {
        BuildMolecules funObj = new BuildMolecules(10);

        ThreadForPrinting thread1 = new ThreadForPrinting(funObj, "Hydrogen");
        ThreadForPrinting thread2 = new ThreadForPrinting(funObj, "Oxygen");

        thread1.start();
        thread2.start();

        System.out.println(" finished ");
    }
}

class ThreadForPrinting extends Thread {

    BuildMolecules obj;
    private String Method;
    ThreadForPrinting(BuildMolecules funObj, String Method)
    {
        this.Method = Method;
        this.obj = funObj;
    }

    @Override
    public void run()
    {
        if("Hydrogen".equals(Method))
        {
            obj.Hydrogen();
        }
        else if("Oxygen".equals(Method))
        {
            obj.Oxygen();
        }
    }

};

class BuildMolecules {

    private int flag = 0;
    private int count = 0;
    private int num = 1;
    private Semaphore HydrogenSem = new Semaphore(2);
    private Semaphore OxygenSem = new Semaphore(1);

    BuildMolecules(int n)
    {
        count = n;
    }
    public void Hydrogen()
    {
        for(int i = 2; i <= count; i += 2)
        {
            try {
                HydrogenSem.acquire();
                HydrogenSem.acquire();
                synchronized (this) {
                    while (flag == 1) {
                        this.wait();
                    }
                }
            }
            catch (InterruptedException io)
            {
            }
            flag = 0;
            System.out.println(i);
            OxygenSem.release();
        }
    }
    public void Oxygen()
    {
        for(int i = 1; i <= count; i += 2)
        {
            try {
                OxygenSem.acquire();
                synchronized (this) {
                    while (flag == 0) {
                        this.wait();
                    }
                }
                flag = 1;
                HydrogenSem.release();
                HydrogenSem.release();
                
            }
            catch (InterruptedException io)
            {
            }
            System.out.println(i);
            OxygenSem.release();
        }
    }
}