package NotesAndLinks.inheritanceGoctha;

class Persian {

    public void whatsUp() {
        System.out.println("che khabar?");
    }
}

interface AlienLanguage {

    default void whatsUp() {
        System.out.println("yada yadda, more yadda yaddda");
    }
}

class Bilingual extends Persian implements AlienLanguage {

    public void converse() {
        // invokes superclass method
        whatsUp();
        // invokes interface's default method
       // AlienLanguage.super.whatsUp();
    }
}


class Demonstration {
    public static void main( String args[] ) {
        (new Bilingual()).converse();
    }
}