package test;

import java.util.HashSet;

class base {
    public void fun1() {
        System.out.println(" in base ");
    }
}
class derived extends base {
    public void fun1() {
        System.out.println(" in derived ");
    }
    public void fun2() {
        System.out.println(" in derived fun 2");
    }
}

public class general_code {
    public static void main(String[] args) {
        base obj1 = new base();
        if( obj1 instanceof derived) {
            globalFun((derived) obj1);
        }

/*        HashSet<Celebrity> set = new HashSet();
        Celebrity realKardashian = new Celebrity("Kim", 17);
        Celebrity kardashianClone = new Celebrity("Kim", 17);
        set.add(realKardashian);
        Celebrity obj = new Celebrity("mm", 20);
        //obj.equals()
        if (set.contains(kardashianClone)) {
            System.out.println("Kim is a celebrity");
        } else {
            System.out.println("Can't find Kim");
        }*/
    }

    static void globalFun(derived obj) {
        obj.fun2();
    }

    private static class Celebrity {
        private String mKim;
        private int age;
        public Celebrity(String kim, int i) {
            mKim = kim;
            age = i;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Celebrity celebrity = (Celebrity) o;

            if (age != celebrity.age) return false;
            return mKim != null ? mKim.equals(celebrity.mKim) : celebrity.mKim == null;
        }

        @Override
        public int hashCode() {
            int result = mKim != null ? mKim.hashCode() : 0;
            result = 31 * result + age;
            return result;
        }
    }
}

interface itesting {
    static int i = 0;
    final int j = 0;
    static void fun() {

    }
}


