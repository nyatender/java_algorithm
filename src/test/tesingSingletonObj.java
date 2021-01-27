package test;

import java.io.*;

public class tesingSingletonObj {
}

class SerializableCalled {
    public void getSerilizableSingleton() {
       // Singletone instance = Singletone.getInstance();
        single instance = single.SINGLE_INSTANCE;

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try(ObjectOutput out = new ObjectOutputStream(bos)) {
            out.writeObject(instance);
            out.flush();
        }
        catch(Exception ex) {
        }
        byte[] byteArray = bos.toByteArray();
        ByteArrayInputStream bis = new ByteArrayInputStream(byteArray);
        Singletone[] byteInstanceArray = new Singletone[10];
        for(int i = 0; i < byteInstanceArray.length; i++) {
            try(ObjectInput ist = new ObjectInputStream(bis)) {
                byteInstanceArray[i] = (Singletone) ist.readObject();
            }
            catch (Exception ex) {
            }
        }
    }
}
class ExploitUsingReflection {
    public void usingReflection() {
       /* Class<Superman> clazz = Superman.class;
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        @SuppressWarnings("unchecked") // we knows its a Superman instance
                Constructor<Superman> constructor = (Constructor<Superman>) constructors[0];
        constructor.setAccessible(true);
        Superman[] supermen = new Superman[10];
        for (int i = 0; i < 10; i++) {

            supermen[i] = constructor.newInstance();
        }

        for (int i = 0; i < 10; i++) {
            supermen[i].fly();
        }

        System.out.println(supermen[0] == supermen[9]);
        */
    }
}
enum single {
    SINGLE_INSTANCE;
    private final String name = " Singleton ";

    public void fun() {

        System.out.println(" In  Single ");
    }
}
class Singletone implements Serializable {
    private static volatile Singletone instance;
    private Singletone() {}
    public static Singletone getInstance() {
        if(instance == null) {
            synchronized (Singletone.class) {
                if(instance == null)
                    instance = new Singletone();
            }
        }
        return instance;
    }
    private Object readResolve() {
        return instance;
    }
}