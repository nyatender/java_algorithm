package Multithreading.ExecutorService.sheduler;

import java.util.concurrent.*;

public class scheduledThreadPool {
    static class BeepTask implements Runnable {

        public void run() {
            System.out.println("beep");
        }
    }

    public static void main(String[] args) {
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        final ScheduledFuture<?> beepHandler =
                scheduler.scheduleAtFixedRate(new BeepTask(), 2, 2, TimeUnit.SECONDS);

        scheduler.schedule(new Runnable() {

            @Override
            public void run() {
                beepHandler.cancel(true);
                scheduler.shutdown();
            }
        }, 10, TimeUnit.SECONDS);
    }


}
