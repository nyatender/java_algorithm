package NotesAndLinks.javaFrequentlyAskQuestions;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class defferedCallBack {
}

class deffered {
    private ReentrantLock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();

    private PriorityQueue<Callback> pQueue =
        new PriorityQueue<Callback>((t1, t2) -> (int)(t1.timeToExecute - t2.timeToExecute));

    private long calculateTimeLeft() {
        long currTime = System.currentTimeMillis();
        return pQueue.peek().timeToExecute - currTime;
    }
    public static class Callback {
        private String message;
        private long timeToExecute;

        Callback(String message, long timeToExecute) {
            this.message = message;
            this.timeToExecute = timeToExecute;
        }

        void executeCallback() {
            System.out.println(message + " executed at " + timeToExecute);
        }
    }

    public void registerCallBack(Callback c) {
        lock.lock();
        pQueue.add(c);
        lock.notify();
        lock.unlock();
    }

    public void start() throws InterruptedException {

        lock.lock();

        while(pQueue.size() == 0)
            lock.wait();

        while(pQueue.size() != 0) {

            long timeLeft = calculateTimeLeft();
            if(timeLeft <= 0)
                break;

            cond.await(timeLeft, TimeUnit.MILLISECONDS);

        }

        Callback c = pQueue.poll();
        c.executeCallback();

        lock.unlock();

    }

}
