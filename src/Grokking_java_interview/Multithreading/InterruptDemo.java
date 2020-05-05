package Grokking_java_interview.Multithreading;

public class InterruptDemo {
    public static void main( String args[] ) throws InterruptedException {
        InterruptExample.example();
    }
}
class InterruptExample {

    static public void example() throws InterruptedException {

        final Thread sleepyThread = new Thread(new Runnable() {

            public void run() {
                try {
                    System.out.println("I am too sleepy... Let me sleep for an hour.");
                    Thread.sleep(1000 * 60 * 60);
                } catch (InterruptedException ie) {
                    System.out.println("The interrupt flag is cleard : " + Thread.interrupted() + " " + Thread.currentThread().isInterrupted());
                    Thread.currentThread().interrupt();
                    System.out.println("Oh someone woke me up ! ");
                    System.out.println("The interrupt flag is set now : " + Thread.currentThread().isInterrupted() + " " + Thread.interrupted());
                    /*
                     Note that there are two methods to check for the interrupt status of a thread.
                     One is the static method Thread.interrupted() and the other is Thread.currentThread().isInterrupted().
                     The important difference between the two is that the static method would return the interrupt status and
                     also clear it at the same time. On line 22 we deliberately call the object method first followed by the static method.
                     If we reverse the ordering of the two method calls on line 22, the output for the line would be true and false,
                     instead of true and true.
                    */
                }
            }
        });

        sleepyThread.start();
        System.out.println("About to wake up the sleepy thread ...");
        sleepyThread.interrupt();
        System.out.println("Woke up sleepy thread ...");

        sleepyThread.join();
    }
}