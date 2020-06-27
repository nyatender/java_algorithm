package test;

abstract class MethodHiding {
    public void Func()
    {
        System.out.println("in MethodHiding");
    }
    abstract void newMethod();
}

class Animal {
    public static void testClassMethod() {
        System.out.println("Class" + " method in Animal.");
    }
    public void testInstanceMethod() {
        System.out.println("Instance " + " method in Animal.");
    }
}

class Cat extends Animal {
    public static void testClassMethod() {
        System.out.println("The class method" + " in Cat.");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method" + " in Cat.");
    }
}

class Derived extends MethodHiding {
    public void Func()
    {
        System.out.println("in Derived");
    }
    @Override
    void newMethod()
    {
        System.out.println(" newMethod ");
    }
    public static void main(String[] args) {
        /*MethodHiding obj = new Derived();
        obj.Func();*/

        Cat myCat = new Cat();
        Animal myAnimal = myCat;
        Animal.testClassMethod();
        myAnimal.testInstanceMethod();
    }
}



