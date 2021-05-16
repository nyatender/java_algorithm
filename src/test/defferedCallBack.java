package test;

import javax.security.auth.callback.Callback;
import java.sql.Time;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class defferedCallBack {



}


class defferedsCallBack {

   private ReentrantLock lock = new ReentrantLock();
   private Condition condition = lock.newCondition();
   private PriorityQueue<Callback> blockingQueue = new PriorityQueue<Callback>(new Comparator<Callback>() {
        public int compare(Callback c1, Callback c2) {
            return (int) (c1.enquedTime - c2.enquedTime);
        }
       });
   private long getSleepTime() {
       long CurrentTime = System.currentTimeMillis();
       return blockingQueue.peek().enquedTime - CurrentTime;
   }
   public void start() throws InterruptedException {
       while(true) {

           lock.lock();

           while(blockingQueue.size() == 0)
               condition.await();

           while(blockingQueue.size() != 0) {

               long sleepTime = getSleepTime();

               if(sleepTime <= 0)
                   break;

               condition.await(sleepTime, TimeUnit.MILLISECONDS);
           }

           Callback c = blockingQueue.poll();
           c.execute1();

           lock.unlock();

       }
   }
   public void registerCallBack(Callback callback) {
       lock.lock();
       blockingQueue.add(callback);
       condition.signal();
       lock.unlock();
   }
   static class Callback {
       public int enquedTime;
       private String message;
       
       Callback(int enquedTime, String message) {
            this.enquedTime = enquedTime;
            this.message = message;
       }

       public void execute1() {
           System.out.println(message + " executed at " + enquedTime);
       }
   }
}