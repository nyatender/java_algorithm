package test;

public class ReadWriteLock {
    int readCount = 0;
    boolean isWriteThread = false;

    public synchronized void ReadLockAquired() throws InterruptedException {
        while(isWriteThread)
            wait();

        readCount++;
    }

    public synchronized void  WriteLockRelease() {
        isWriteThread = false;
        notify();
    }

    public synchronized void ReadLockRelease() {
        readCount--;
        notify();
    }

    public synchronized void WriteLockAquired() throws InterruptedException {

        while (readCount > 0 || isWriteThread)
            wait();

        isWriteThread = true;
        notify();
    }
}
