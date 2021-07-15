package NotesAndLinks.inheritanceGoctha;

//will it compile
interface Language1 {

    default void sayHello() {
        System.out.println("01101000 01100101 01101100 01101100 01101111 ");
    }
}

interface Marathi extends Language1{

}

interface Punjabi extends Language1 {

}

public class Demonstration_1 {
    public static void main(String[] args) {
        System.out.println("Comopiled!!");
    }
}
