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
