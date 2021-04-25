


public class BlockingQueue<T> {
    private int head = 0;
    private int tail = 0;
    private int capacity = 0;
    private int size = 0;
    private T[] Queue;

    BlockingQueue(int n) {
        Queue = (T[]) new Object[n];
        capacity = n;
    }

    public synchronized void enqueue(T item) throws InterruptedException {
        while(size == capacity) {
            wait();
        }

        if(tail == capacity)
            tail = 0;

        Queue[tail] = item;
        size++;

        notifyAll();
    }

    public synchronized T deque() throws InterruptedException {
        T item = null;
        while(size == 0) {
            wait();
        }

        if(head == capacity)
            head = 0;

        item = Queue[head];
        Queue[head] = null;
        head++;
        size--;

        notifyAll();

        return item;
    }
}
