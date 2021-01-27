package SynechronAssignmentJava;

public class FirstAssignment_b {
    public static void main(String[] args) {
        EffectiveFinalDemo1 obj1 = new EffectiveFinalDemo1();
        EffectiveFinalDemo2 obj2 = new EffectiveFinalDemo2();
    }
}

class EffectiveFinalDemo1 {
    public static void effectiveFinal(String args[]) {
        String nonEffectiveFinal = "I am non final local variable";
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Using non-final local variable inside anonymous class in Java");
                System.out.println("Value of non-final variable is : " + nonEffectiveFinal);

                // if un-comment below code it will produce compile time error -
                // must be final or effective final inside anonymous class";
                //nonEffectiveFinal = "Can I change non-final variable
            }
        });
        t.start();
    }
}

class EffectiveFinalDemo2 {
    int numberLength = 5;  // <== not *final*
    class PhoneNumber {
        PhoneNumber(String phoneNumber) {
            String ParsephoneNumber = null;
            numberLength = 7;   // <== assignment to numberLength
            String currentNumber = phoneNumber.replaceAll("a", "x");
            if (currentNumber.length() == numberLength)
                ParsephoneNumber = currentNumber;
            else
                ParsephoneNumber = null;
        }
    }
}