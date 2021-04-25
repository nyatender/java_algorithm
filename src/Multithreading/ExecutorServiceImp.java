import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ExecutorService;

class myExcutor implements Runnable {
    private String name;
    myExcutor(String name) {
        this.name = name;
    }
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println(name + " finished ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ExecutorServiceImp {
    static final int MAX_POOL_SIZE = 3;
    public static void main(String[] args) {
        Runnable[] rThread = new Runnable[10];
        for(int i = 0; i < 10; i++) {
            rThread[i] = new myExcutor(" task " + i);
        }
        ExecutorService pool = Executors.newFixedThreadPool(MAX_POOL_SIZE); //(MAX_POOL_SIZE);
        for(int i = 0; i < 10; i++) {
            pool.execute(rThread[i]);
            System.out.println(" next " + i);
        }

        pool.shutdown();
    }
}
