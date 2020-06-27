package test;

public class DemonstrationDiamond {
    public static void main( String args[] ) {
       // (new MultiLingual()).sayHello();
     //  (new Trilingual1()).sayHello();
        SimpleClass<String> sc = new SimpleClass();
        sc.<Integer>genericMethod(Integer.valueOf(10));

        SimpleClass<Double> sc1 = new SimpleClass();
        sc1.<Integer>genericMethod(Integer.valueOf(10));

    }
}

interface Language {
    void sayHello();
}

interface Punjabi extends Language {

    String lang = "punjabi";

    default void sayHello() {
        System.out.println("O Kiddaan");
    }
}

interface Marathi extends Language {

    String lang = "Marathi";

    default void sayHello() {
        System.out.println("Namaskaar");
    }

}

//class MultiLingual implements Punjabi, Marathi {
//
//}

//2-Example===================================
class Bilingual extends Persian implements AlienLanguage {

    public void converse() {
        // invokes superclass method
        whatsUp();
        // invokes interface's default method
        AlienLanguage.super.whatsUp();
    }
}

class Persian {
    public void whatsUp() {
        System.out.println("che khabar?");
    }
}

interface AlienLanguage {
    default void whatsUp(){
        System.out.println("yada yadda, more yadda yaddda");
    }
}

//Examplae 3 ========================================================
interface Marathi1 {

    String lang = "marathi";

    default void sayHello() {
        System.out.println("Namaskaar");
    }

}

interface Punjabi1 {

    String lang = "punjabi";

    default void sayHello() {
        System.out.println("O Kiddaan");
    }

}

class Kashmiri1 {

    String lang = "kashmiri";

    public void sayHello() {
        System.out.println("aadaab");
    }
}

class Trilingual1 extends Kashmiri1 implements Punjabi1, Marathi1 {

    public int a;
    class abc
    {
        void fu() {
            a = 6;
        }
    }
    public void converse() {
        sayHello();
    }
}

//========================================================================

class SimpleClass<T> {

    <T> void genericMethod(T t) {
        System.out.println(t);
    }
}