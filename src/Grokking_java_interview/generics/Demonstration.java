package Grokking_java_interview.generics;

public class Demonstration {
    public static void main( String args[] ) {
        String[] strArray = Demonstration.<String>createGenericArray(String.class, 10);
    }

    @SuppressWarnings("unchecked")
    static <T> T[] createGenericArray(Class<T> type, int size) {

        // Causes an unchecked cast warning
        T[] arr = (T[]) java.lang.reflect.Array.newInstance(type, size);
        return arr;
    }

}

class NaiveArrayList<T> {

    private T[] array;

    public NaiveArrayList(int size) {
        array = (T[]) new Object[size]; // <--- Generates unchecked cast warning
    }

    public T[] getArray() {
        return array;
    }

    public T getItem(int i) {
        return array[i];
    }

    // ... class body
}
