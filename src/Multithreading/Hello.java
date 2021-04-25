import javax.sql.rowset.serial.SerialException;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

class Singleton implements Serializable {
    private static volatile Singleton instance;
    private Singleton() {}

    public static Singleton getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null)
                    instance = new Singleton();
            }
        }

        return instance;
    }

/*    private Object readResolve() throws ObjectStreamException {
        return instance;
    }*/
}

interface ICar {
    void displayCar();
}

interface IEngine {
    void displayEngine();
}

class Hundai implements ICar {

    public void displayCar() {
        System.out.println(" i am Hundai car");
    }
}
class Tata implements ICar {
    public void displayCar() {
        System.out.println(" i am Tata car");
    }
}
class HundaiEngine implements IEngine{
    public void displayEngine() {
        System.out.println(" i am HundaiEngine");
    }
}
class TataEngine implements IEngine{
    public void displayEngine() {
        System.out.println(" i am TataEngine");
    }
}

class HundaiCarWithTataEngine extends abstractFactory {
    public ICar createCarFactory() {
        return new Hundai();
    }
    public IEngine createEngineFactory() {
        return new TataEngine();
    }
}

class TataCarWithHundaiEngine extends abstractFactory {
    public ICar createCarFactory() {
        return new Tata();
    }
    public IEngine createEngineFactory() {
        return new HundaiEngine();
    }
}

enum FACTORY_TYPE {
    HUDAI_CAR_WITH_TATA_ENGINE,
    TATA_CAR_WITH_HUNDAI_ENGINE
}

abstract class abstractFactory {
    private static final abstractFactory hundaiCarWithTataEngine = new HundaiCarWithTataEngine();
    private static final abstractFactory tataCarWithHundaiEngine = new TataCarWithHundaiEngine();

    public static abstractFactory getFactory(FACTORY_TYPE type) {
        abstractFactory rType = null;
        switch (type) {
            case HUDAI_CAR_WITH_TATA_ENGINE:
                rType = hundaiCarWithTataEngine;
                break;

            case TATA_CAR_WITH_HUNDAI_ENGINE:
                rType = tataCarWithHundaiEngine;
                break;
        }
        return rType;
    }
    public abstract ICar createCarFactory();
    public abstract IEngine createEngineFactory();
}

public class Hello {
    public static void main(String[] args) throws Exception {
        abstractFactory instance = abstractFactory.getFactory(FACTORY_TYPE.HUDAI_CAR_WITH_TATA_ENGINE);
        ICar carInstance = instance.createCarFactory();
        carInstance.displayCar();

        IEngine engineInstance = instance.createEngineFactory();
        engineInstance.displayEngine();

        abstractFactory instance2 = abstractFactory.getFactory(FACTORY_TYPE.TATA_CAR_WITH_HUNDAI_ENGINE);
        ICar carInstance1 = instance2.createCarFactory();
        carInstance1.displayCar();

        IEngine engineInstance2 = instance2.createEngineFactory();
        engineInstance2.displayEngine();

        Singleton instance1 = Singleton.getInstance();

        Class<Singleton> clazz = Singleton.class;
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        Constructor<Singleton> constructor = (Constructor<Singleton>)constructors[0];
        constructor.setAccessible(true);
        Singleton instance3 = constructor.newInstance();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try(ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(instance1);
            oos.flush();
        }
        byte[] byteArray = bos.toByteArray();

        Singleton[] instances = new Singleton[10];
        for(int i = 0; i < 10; i++) {
            ByteArrayInputStream bis = new ByteArrayInputStream(byteArray);
            try (ObjectInputStream ois = new ObjectInputStream(bis)) {
                instances[i] = (Singleton) ois.readObject();
            }
            catch(Exception ex) {

            }
        }
    }
}

