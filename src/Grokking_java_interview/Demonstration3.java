package Grokking_java_interview;

class Demonstration3 {
    public static void main( String args[] ) {
        (new SpecialPerson()).print();
    }
}

class SpecialPerson {

    String fullName = init();
    String name = "batman";

    public SpecialPerson() {
        name = "superMan";
    }

    private String init() {
        return name;
    }

    public void print() {
        System.out.println(fullName);
    }
}

// static initialization block
class EducativeCourse {

    static String courseName;
    static String version;

    // We have two static initialization blocks
    static {
        version = "1.0";
    }

    static {
        courseName = "Java Interview Bible";
    }
}
