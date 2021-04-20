package NotesAndLinks.javaCodingExamples;

// this is example of how we can pass the methods using functional interface.
interface parser {
    String parse(String str);
}
class stringParser {
    public static String convert(String str) {
        if(str.length() <= 3)
            str = str.toUpperCase();
        else
            str = str.toLowerCase();

        return str;
    }
}
class MyPrinter {
    public static void print(String str, parser p) {
        str = p.parse(str);
        System.out.println(str);
    }
}
public class passingMethods {
    public static void main(String[] args) {
        String str = "YaT";
        MyPrinter obj = new MyPrinter();
        obj.print(str, stringParser::convert);
    }
}
