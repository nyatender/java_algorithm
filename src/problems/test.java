package problems;

public class test {


    public static void main(String[] args)
    {
        base1 obj = new b();
        obj.fun();
//        Animal obj = new Dog();
//        obj.bark();

//        abc a = new abc(2);
//        abc b = new abc(3);
//        System.out.println(" Before swap ");
//        System.out.println(a.a + " " + b.a);
//        Swap(a, b);
//        System.out.println(" After swap ");
//        System.out.println(a.a + " " + b.a);
    }

}

interface base1{
    default void fun()
    {
        System.out.println("in base1");
    }
}
interface base2 {
//    default void fun()
//    {
//        System.out.println("in base2");
//    }
}

class b implements base1, base2 {
//    public void fun()
//    {
//        System.out.println("in b");
//    }
}
