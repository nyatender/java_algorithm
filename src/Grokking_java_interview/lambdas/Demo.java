package Grokking_java_interview.lambdas;

//https://www.journaldev.com/2389/java-8-features-with-examples
public class Demo {
    public static void main(String[] args)
    {
        MyWork mMyWork = (count) -> {
            System.out.println("in lambdas");
            return count;
        };
        mMyWork.run(10);

        MyWork mMyWork1 = new MyWork()
        {   // anonymous inner class
            @Override
            public int run(int count) {
                System.out.println("in lambdas");
                return count;
            }
        };
        mMyWork1.run(20);
    }

}

interface MyWork
{
    int run(int count);
}
