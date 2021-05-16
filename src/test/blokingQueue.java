package test;

public class blokingQueue {

}

class bQueue<T> {

    private int capacity;
    private int size;
    private int head;
    private int tail;

    private Object[] queue;

    public bQueue(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        queue = (T[]) new Object[capacity];
        head = 0;
        tail = 0;
    }

    public synchronized void enqueue(T item) throws InterruptedException {

        while(size == capacity)
            wait();

        if(tail == capacity)
            tail = 0;
        size++;
        queue[tail] = item;
        notify();
    }

    public synchronized T dequeue() throws InterruptedException {

        T item = null;
        while(size == 0)
            wait();

        if(head == capacity)
            head = 0;
        size--;
        item = (T)queue[head];
        queue[head] = null;

        notify();

        return item;
    }
}