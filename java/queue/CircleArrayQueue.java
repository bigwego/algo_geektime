package queue;

public class CircleArrayQueue {

    private final String[] items;

    private final int len;

    private int head = 0;

    private int tail = 0;

    public CircleArrayQueue(int capacity) {
        items = new String[capacity + 1];
        len = capacity;
    }

    public boolean enqueue(String item) {
        if ((tail + 1) % len == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % len;
        return true;
    }

    public String dequeue() {
        if (tail == head) {
            return null;
        }
        String ret = items[head];
        head = (head + 1) % len;
        return ret;
    }
}
