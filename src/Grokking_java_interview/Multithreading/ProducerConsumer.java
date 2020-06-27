package Grokking_java_interview.Multithreading;
import java.util.LinkedList;
import java.util.Queue;
//import org.apache.log4j.Logger;

public class ProducerConsumer {

    public static void main(String args[]) {

        final Queue sharedQ = new LinkedList<Integer>();

        Thread producer = new Producer(sharedQ);
        Thread consumer = new Consumer(sharedQ);

        producer.start();
        consumer.start();

    }
}

class Producer extends Thread {
   // private static final Logger logger = Logger.getLogger(Producer.class);
    private final Queue sharedQ;

    public Producer(Queue sharedQ) {
        super("Producer");
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {

        for (int i = 0; i < 4; i++) {

            synchronized (sharedQ) {
                //waiting condition - wait until Queue is not empty
                while (sharedQ.size() >= 1) {
                    try {
                        //logger.debug("Queue is full, waiting");
                        sharedQ.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                //logger.debug("producing : " + i);
                sharedQ.add(i);
                sharedQ.notify();
            }
        }
    }
}

class Consumer extends Thread {
   // private static final Logger logger = Logger.getLogger(Consumer.class);
    private final Queue sharedQ;

    public Consumer(Queue sharedQ) {
        super("Consumer");
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
        while(true) {

            synchronized (sharedQ) {
                //waiting condition - wait until Queue is not empty
                while (sharedQ.size() == 0) {
                    try {
                        //logger.debug("Queue is empty, waiting");
                        sharedQ.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                int number = (int)sharedQ.poll();
               // logger.debug("consuming : " + number );
                sharedQ.notify();

                //termination condition
                if(number == 3){
                    break;
                }
            }
        }
    }
}