package test.threadTest;

import javax.imageio.plugins.tiff.TIFFImageReadParam;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

class threadPoolWorker implements Runnable {
    BlockingQueue<threadPoolWorker> queue;
    boolean isStop = false;
    Thread thread = new Thread();
    public threadPoolWorker(BlockingQueue queue) {
        this.queue = queue;

    }
    @Override
    public void run() {
        this.thread = Thread.currentThread();
        while(!isStop) {
            try {
                Runnable r = queue.take();
                r.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void doStop() {
        isStop = true;
        this.thread.interrupt();
    }

    public boolean isStop() {
        return isStop;
    }
}

class threadpool {
    BlockingQueue taskQueue = null;
    ArrayList<threadPoolWorker> threadList;
    boolean isStop;
    threadpool(int maxNoOfTasks, int numOfthread) {
        threadList = new ArrayList<>();
        //queue = new ArrayBlockingQueue(capacity);
        taskQueue = new ArrayBlockingQueue(maxNoOfTasks);
        for(int i = 0; i < numOfthread; i++) {
            threadList.add(new threadPoolWorker(taskQueue));
        }
        for(threadPoolWorker t : threadList)
            (new Thread(t)).start();
    }
    void execute(Runnable task) {
        if(isStop)
            throw new IllegalThreadStateException();

        taskQueue.add(task);
    }
    public void waitforAllfinished() {
        while(taskQueue.size() > 0) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void stop() {
        isStop = true;
        for(threadPoolWorker t : threadList)
            t.doStop();
    }
}

public class testmain {
    public static void main(String[] args) {
       // BlockingQueue<threadPoolWorker> queue = new ArrayBlockingQueue<threadPoolWorker>()
        threadpool pool = new threadpool(25, 10);
        for(int i = 0; i < 10; i++) {
          pool.execute(() -> {
              String message = Thread.currentThread().getName() + " created ";
              System.out.println(message);
          });

          pool.waitforAllfinished();
          pool.stop();
        }
    }

}
