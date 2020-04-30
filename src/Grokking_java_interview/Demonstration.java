package Grokking_java_interview;

public class Demonstration {

    //variable arguments
    public static void main( String args[] ) {
        childrenNames();
        childrenNames("tom", "nancy");
        childrenNames("trump", "obama", "modi");
    }

    public static void childrenNames(String... names) {
        for (int i = 0; i < names.length; i++)
            System.out.println(names[i]);
    }
}

class Demonstration2 {
    public static void main( String args[] ) {
        System.out.println( "Traditional main method" );
    }

    public static void main( String singleArg) {
        System.out.println( "Method with single arg" );
    }

    public static void main( ) {
        System.out.println( "Method with no args" );
    }
}
