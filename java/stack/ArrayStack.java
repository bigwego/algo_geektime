package stack;

public class ArrayStack {

    private final String[] items;

    private final int length;

    private int pos;

    public ArrayStack(int capacity) {
        items = new String[capacity];
        length = capacity;
        pos = 0;
    }

    public boolean push(String item) {
        if (pos == length) {
            return false;
        }
        items[pos++] = item;
        return false;
    }

    public String pop() {
        if (isEmpty()) {
            return null;
        }
        return items[--pos];
    }

    private boolean isEmpty() {
        return pos == 0;
    }
}
