package NotesAndLinks.inheritanceGoctha;


 interface Vehicle {

    default void whatAmI() {
        System.out.println("I am a vehicle");
    }
}
 interface SevenSeater extends Vehicle {

 }

 interface SUV extends Vehicle {

    default void whatAmI() {
        System.out.println("I am a SUV");
    }
}

 class TeslaModelX implements SUV, SevenSeater {

    public void identifyMyself() {
        whatAmI();
    }
}
public class Demonstration_3 {
    public static void main(String[] args) {

        (new TeslaModelX()).identifyMyself();
    }
}
