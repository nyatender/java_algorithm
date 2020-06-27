package MyUtils;

public class IntefaceAndAbstractClass {
   // MyAbstractClass obj = new MyAbstractClass();
}


interface MyInterface
{
    default void fun() {}
    void method();
}

abstract class MyAbstractClass {
    public MyAbstractClass(){}
    public void Method() {}
    public abstract void method2();
    static void getFactory() {}
}