package array;

public class GenericArray<T> {

    private Integer size;

    private T[] data;

    private GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public GenericArray() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }

    public int count() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void set(int idx, T e) {
        checkIdx(idx);
        data[idx] = e;
    }

    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    private int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    private void add(int idx, T e) {
        checkIdx(idx);
        if (size == data.length) {
            resize(2 * data.length);
        }
        data[idx] = e;
        size++;
    }

    public void addFirst(T e) {
        add(0, e);
    }

    public void addLast(T e) {
        add(size, e);
    }

    private T remove(int idx) {
        checkIdxForRemove(idx);

        T ret = data[idx];
        for (int i = idx; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;

        if (size == data.length / 4 && data.length > 1) {
            resize(data.length / 2);
        }

        return ret;
    }

    public T removeFirst() {
        return remove(0);
    }

    public void removeElement(T e) {
        int idx = find(e);
        if (idx != -1) {
            remove(idx);
        }
    }

    public T removeLast() {
        return remove(size - 1);
    }

    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private void checkIdx(int idx) {
        if (idx < 0 || idx > size) {
            throw new IllegalArgumentException("require idx >= 0 && idx <= size");
        }
    }

    private void checkIdxForRemove(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IllegalArgumentException("require idx >= 0 && idx < size");
        }
    }
}
