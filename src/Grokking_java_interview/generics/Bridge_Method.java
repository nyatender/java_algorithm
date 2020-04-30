package Grokking_java_interview.generics;
import java.lang.reflect.Method;

public class Bridge_Method {
    public static void main( String args[] ) {
        for (Method m : PurposelessClass.class.getMethods())
            if (m.getName().equals("print"))
                System.out.println(m.toGenericString());
    }
}

interface UselessInterface<T> {

    public void print(T o);
}

class PurposelessClass implements UselessInterface<Integer> {

    @Override
    public void print(Integer o) {
    }

    // BRIDGE METHOD
    // Synthetic method inserted by compiler
    //public void print(Object t) {
    //     print((Integer)t); // <--- the method casts the received Object to Integer and calls the intended overridden method.
    //}
}

