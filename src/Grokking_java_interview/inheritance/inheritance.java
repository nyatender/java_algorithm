package Grokking_java_interview.inheritance;

public class inheritance {
    //variable arguments
    public static void main( String args[] ) {
        Bilingual pBilingual = new Bilingual();
        pBilingual.converse();
    }
}

interface AlienLanguage {
    default void whatsup(){
        System.out.println("yada yadda, more yadda yaddda");
    }
}

class Persian {
    protected void whatsUp() {
        System.out.println("che khabar?");
    }
}

class Bilingual extends Persian implements AlienLanguage {
    public void converse() {
        whatsUp();
        AlienLanguage.super.whatsup();
    }
}