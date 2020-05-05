package Grokking_java_interview.Multithreading;

public class FooBarNtimePrint {
    public static  void main(String args[])
    {
        PrintFooAndBar funObj = new PrintFooAndBar(5);
        ThreadForPrintingFooAndBar thread1 = new ThreadForPrintingFooAndBar(funObj, "Foo");
        ThreadForPrintingFooAndBar thread2 = new ThreadForPrintingFooAndBar(funObj, "Bar");

        thread1.start();
        thread2.start();

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
        if("Foo".equals(Method))
        {
            obj.Foo();
        }
        else if("Bar".equals(Method))
        {
           obj.Bar();
        }
    }

};

class PrintFooAndBar {

    private int flag = 0;
    private int count = 0;

    PrintFooAndBar(int n)
    {
        count = n;
    }
    public void Foo()
    {
        for(int i = 0; i < count; i++)
        {
            synchronized (this) {
                while (flag == 1) {
                    try {
                        this.wait();
                    } catch (InterruptedException io) {

                    }
                }
                flag = 1;
                this.notifyAll();
                System.out.println(" Foo ");
            }
        }
    }
    public void Bar()
    {
        for(int i = 0; i < count; i++)
        {
            synchronized (this) {
                while (flag == 0) {
                    try {
                        this.wait();
                    } catch (InterruptedException io) {

                    }
                }
                flag = 0;
                this.notifyAll();
                System.out.println(" Bar ");
            }
        }
    }
}
