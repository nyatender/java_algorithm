package problems;

public class test {

    public static void main(String[] args)
    {
        abc a = new abc(2);
        abc b = new abc(3);
        System.out.println(" Before swap ");
        System.out.println(a.a + " " + b.a);
        Swap(a, b);
        System.out.println(" After swap ");
        System.out.println(a.a + " " + b.a);
    }
    static void Swap(abc a, abc b)
    {
        int t = a.a;
        a.a = b.a;
        b.a = t;
    }
}

class abc {
    abc(int b) {
        a = b;
    }
    public int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
