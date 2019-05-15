package queue;

public class ArrayQueue {

    private final String[] items;

    private int len = 0;

    private int head = 0;

    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        len = capacity;
    }

    public boolean enqueue(String item) {
        if (tail == len) {
            return false;
        }
        items[tail++] = item;
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            return null;
        }
        return items[head++];
    }
}
