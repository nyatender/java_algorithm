package NotesAndLinks.javaCodingExamples;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class test {
    private void show() {
        System.out.println(" i am private method");
    }
}
public class accessPrivatemethodUsingReflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
                                          IllegalAccessException, InstantiationException,
            InvocationTargetException {

        Class cls = Class.forName("NotesAndLinks.test");
        test t = (test)cls.newInstance();
        Method m = cls.getDeclaredMethod("show", null);
        m.setAccessible(true);
        m.invoke(t, null);
    }
}
