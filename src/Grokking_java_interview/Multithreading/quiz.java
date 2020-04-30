package Grokking_java_interview.Multithreading;

public class quiz {

    static void main(String[] args)
    {
        spawnThread();
        spawnDaemonThread();
    }
    public static void spawnThread() {

        Thread innerThread = new Thread(new Runnable() {

            public void run() {

                for (int i = 0; i < 100; i++) {
                    System.out.println("I am a new thread !");
                }
            }
        });

        innerThread.start();
        System.out.println("Main thread exiting");
    }
    static void spawnDaemonThread() {

        Thread innerThread = new Thread(new Runnable() {

            public void run() {

                for (int i = 0; i < 100; i++) {
                    System.out.println("I am a daemon thread !");
                }
            }
        });

        innerThread.setDaemon(true);
        innerThread.start();
        System.out.println("Main thread exiting");
    }
}