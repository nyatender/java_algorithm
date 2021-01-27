package DesignPatterns;

public class Singleton {
    private static Singleton instance;

    public  void main(String[] args)
    {
        Singleton ins = Singleton.getInstance();

    }
    public static Singleton getInstance()
    {
        if(instance == null)
        {
            synchronized(Singleton.class)
            {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

class SingletonThreadSafe {
    private SingletonThreadSafe() {}

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

//Eager Initialization
class Superman {
    private static Superman superman;

    static {
        try {
            superman = new Superman();
        } catch (Exception e) {
            // Handle exception here
        }
    }

    private Superman() {
    }

    public static Superman getInstance() {
        return superman;
    }
}

class Superman1 {
    private static Superman1 superman = new Superman1();

    private Superman1() {
    }

    public static Superman1 getInstance() {
        return superman;
    }

    public void fly() {
        System.out.println("I am flyyyyinggggg ...");
    }
}
