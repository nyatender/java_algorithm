package Grokking_java_interview.lambdas;

public class Demo {
    public static void main(String[] args)
    {
        MyWork mMyWork = () -> {
            System.out.println("in lambdas");
        };
        mMyWork.run();
    }

}

interface MyWork
{
    void run();
}
