package Multithreading.nonBlockingProducerConsumer;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

class NonBlockingProducerConsumer {
    private StampedLock lock = new StampedLock();
    private Map<Integer, Integer> map = new HashMap<>();

    public int tryReadLock(int key) {

        long stam = lock.tryReadLock();
        int result = 0;
        if(stam != 0L) {
            try {
                return map.get(key);
            } finally {
                lock.unlockRead(stam);
            }
        }

        return result;
    }

    public void tryWriteLock(int key, int val) {

        long stam = lock.tryWriteLock();
        int result = 0;
        if(stam != 0L) {
            try {
                map.put(key, val);
            } finally {
                lock.unlockWrite(stam);
            }
        }
    }

    // In case of read heavy operation. optimistic read lock would not locked/unlock again and again
    // instead it returns stamped that should be validate when read is finishes.
    // it validate against the write stamped to validate upto date data.
    public int optimisticReadlock(int key) {

        long stamp = lock.tryOptimisticRead();
        int result = -1;
        if(stamp != 0L) {
            result = map.get(key);
        }

        if(!lock.validate(stamp)) {
            // do something to get latest data
            // this is just a thought
            stamp = lock.tryReadLock();
            result = -1;
            if(stamp != 0L) {
                try {
                    result = map.get(key);
                } finally {
                    lock.unlockRead(stamp);
                }
            }
        }

        return result;
    }
}


public class main {
    public static void main(String[] args) {
        
    }

}
