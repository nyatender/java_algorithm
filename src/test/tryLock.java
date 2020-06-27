package test;

import Grokking_java_interview.Multithreading.ReeEnterant_lock;

import java.util.concurrent.locks.ReentrantLock;

public class tryLock {
    public static void main(String[] args) {
        (new TestFinallyBlock()).fun();
    }
}

class TestFinallyBlock {
    private ReentrantLock lock = new ReentrantLock();
    public void fun() {
        for(int i = 1; i < 10; i++) {
            if(lock.tryLock()) {
                try {
                    if (i < 5)
                        continue;
                } catch (Exception ex) {
                } finally {
                    lock.unlock();
                    System.out.println(" value = " + i);
                }
            }
        }
    }
}
