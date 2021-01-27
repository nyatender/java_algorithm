package DesignPatterns;
import java.io.*;
import java.lang.reflect.Constructor;

public class SerializeSingleton {
    public static void main( String args[] ) throws Exception {
        SingletonInstance superman = SingletonInstance.getInstance();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try (ObjectOutput out = new ObjectOutputStream(bos)) {
            out.writeObject(superman);
            out.flush();
        } catch (Exception e) {
            // Ignore exception, not to be done in production
        }
        byte[] supermanInBytes = bos.toByteArray();
        SingletonInstance[] supermen = new SingletonInstance[10];

        for (int i = 0; i < 10; i++) {
            ByteArrayInputStream bis = new ByteArrayInputStream(supermanInBytes);
            try (ObjectInput in = new ObjectInputStream(bis)) {
                supermen[i] = (SingletonInstance) in.readObject();

            } catch (Exception e) {
                // Ignore exception, not to be done in production
            }
        }

        for (int i = 0; i < 10; i++) {
            supermen[i].fly();
        }

        System.out.println(supermen[0] == supermen[9]);
    }
}

class SerializationAttack {
    public void makeSingletonCopies() {
        SingletonInstance singleObj = SingletonInstance.getInstance();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try( ObjectOutput out = new ObjectOutputStream(bos)) {
            out.writeObject(singleObj);
            out.flush();
        }
        catch (Exception ex) {
            //log exception
        }
        byte[] byteStreamArray = bos.toByteArray();
        SingletonInstance[] newInst = new SingletonInstance[10];

        ByteArrayInputStream bis = new ByteArrayInputStream(byteStreamArray);
        for(int i = 0; i < newInst.length; i++) {
            try (ObjectInput ist = new ObjectInputStream(bis)) {
                newInst[i] = (SingletonInstance) ist.readObject();
                System.out.println(" ");
            } catch (Exception ex) {
            }
        }
        SingletonInstance tempObj = newInst[0];
        for(int i = 1; i < newInst.length; i++) {
            System.out.println(" newInst[" + (i-1) +"] = "  + "newInst[" + i +"]" + " : " + (tempObj == newInst[i]));
        }
    }
}

class SingletonInstance implements Serializable {
    private static volatile SingletonInstance superman;

    private SingletonInstance() {
    }

    public static SingletonInstance getInstance() {

        if (superman == null) {
            synchronized (Superman.class) {
                if (superman == null) {
                    superman = new SingletonInstance();
                }
            }
        }
        return superman;
    }

    public void fly() {
        System.out.println("I am flyyyyinggggg ...");
    }

    private Object readResolve() throws ObjectStreamException {
        return superman;
    }
}

class UsingReflection {
    public void getMultipleInstanceOfSingleton() throws Exception {
        Class<SingletonInstance> clazz = SingletonInstance.class;
        Constructor<?>[] constructores = clazz.getDeclaredConstructors();
        @SuppressWarnings("unchecked")
        Constructor<SingletonInstance> constructor = (Constructor<SingletonInstance>)constructores[0];
        constructor.setAccessible(true);

        SingletonInstance[] objects = new SingletonInstance[10];
        for(int i = 0; i < objects.length; i++) {
            objects[i] = constructor.newInstance();
        }
        for(int i = 0; i < objects.length; i++) {
            objects[i].fly();
        }
    }
}