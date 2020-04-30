package Grokking_java_interview.multipleInheritance;

public interface Language {
    default void sayHello() {
        System.out.println("01101000 01100101 01101100 01101100 01101111 ");
    }
}
