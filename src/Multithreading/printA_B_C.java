package Multithreading;

import java.util.LinkedList;
import java.util.Queue;

    class threading {
        private Queue<String> queue;
        private int count = 0;
        threading(Queue<String> queue) {
            this.queue = queue;
        }
        public void printA() throws InterruptedException {
            synchronized (this) {
                while(count != 0) {
                    wait();
                }
                queue.add("A");
                count++;
                notifyAll();
            }
        }
        public void printB() throws InterruptedException {
            synchronized (this) {
                while(count == 0 || count == 2) {
                    wait();
                }
                queue.add("B");
                count++;
                notifyAll();
            }
        }
        public void printC() throws InterruptedException {
            synchronized (this) {
                while(count == 0 || count == 1) {
                    wait();
                }
                queue.add("C");
                count = 0;
                notifyAll();
            }
        }
    }

    enum TYPE {
        A,
        B,
        C
    }

    class myThread extends Thread {
        threading obj;
        TYPE type;
        myThread(threading obj, TYPE type ) {
            this.obj = obj;
            this.type = type;
        }
        public void run() {
            if(type == TYPE.A) {
                try {
                    obj.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else if(type == TYPE.B) {
                try {
                    obj.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else if(type == TYPE.C) {
                try {
                    obj.printC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public class printA_B_C {
        public static void main(String[] args) {

            Queue<String> Q = new LinkedList<>();
            threading obj = new threading(Q);

            myThread t1 = new myThread(obj, TYPE.A);
            myThread t2 = new myThread(obj, TYPE.B);
            myThread t3 = new myThread(obj, TYPE.C);

            t1.start();
            t2.start();
            t3.start();

            Q.forEach(x -> System.out.println(x));

        }
}
