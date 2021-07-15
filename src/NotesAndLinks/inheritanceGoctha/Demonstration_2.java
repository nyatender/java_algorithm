package NotesAndLinks.inheritanceGoctha;


 class Language {

    static String lang = "base language";

    static protected void printLanguage() {
        System.out.println(lang);
    }

    protected Language sayHello() {
        System.out.println("----");
        return this;
    }
}

 class Spanish extends Language {

    static String lang = "Spanish";

    static protected void printLanguage() {
        System.out.println(lang);
    }

    protected Language sayHello() {
        System.out.println("Ola!");
        return this;
    }
}

public class Demonstration_2 {
    public static void main(String[] args) {
        (new Spanish()).sayHello();
        Language obj = new Spanish();
        obj.sayHello();

        //if remove printLanguage() spanish class
        obj.printLanguage(); //print base language

    }
}