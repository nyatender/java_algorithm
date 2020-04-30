package Grokking_java_interview;

public abstract class Abstract_class implements Comparable<Abstract_class> {

    int age;
    String firstName;
    String lastName;
    String middleName;

    public Abstract_class() {

    }

    public Abstract_class(int age, String firstName, String middleName, String lastName) {
        this.age = age;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    // Abstract method must be implemented by the subclass.
    abstract void printFullName();

    // Default implementation for defaultAge
    void printAge() {
        System.out.println();
    }
}