package Grokking_java_interview.multipleInheritance;

public class BiLingual implements Punjabi, Marathi {
    public static void main( String args[] ) {
        BiLingual bBiLingual = new BiLingual();
        bBiLingual.converse();
    }

    void converse() {
        sayHello();
    }
}
