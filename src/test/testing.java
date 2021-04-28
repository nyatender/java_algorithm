package test;

public class testing {
    public static void main(String[] args) {
       // (new SpecialPerson()).print();
        try {
            (new IntegerSwap()).run();
        }
        catch (Exception ex)
        {
            System.out.println(" in  Catch ");
        }
        finally {
            System.out.println(" in  finally ");
        }
    }
}


class SpecialPerson  {

    String fullName = init();
    String name = "batman";

    public SpecialPerson () {
        name = "superMan";
    }
    private String init() {
        return name;
    }

    public void print() {
        System.out.println(fullName);
    }
}
class myInt {
    public int val;
    public myInt(int a)
    {
        val = a;
    }
    public String toString()
    {
        return String.valueOf(val);
    }
}
class IntegerSwap {
    public void run() throws InterruptedException {
        myInt x = new myInt(5);
        myInt y = new myInt(9);
        System.out.println("Before Swap x: " + x + " y: " + y);
        swap(x, y);
        System.out.println("After Swap x: " + x + " y: " + y);
       throw  new InterruptedException();
    }

    private void swap(myInt a, myInt b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}

class MySingleton {
    static private MySingleton instance;
    private MySingleton() {}
    public static MySingleton getInstance() {
        if (instance == null) {
            synchronized (MySingleton.class) {
                if (instance == null) {
                    instance = new MySingleton();
                }
            }
        }
        return instance;
    }
}
class MySingletonEnum {
    enum instance{
        INSTANCE
    }
    static private MySingletonEnum instance;
    public MySingletonEnum getInstance() {
            synchronized (instance.class) {
                instance = new MySingletonEnum();
            }
        return instance;
    }
}