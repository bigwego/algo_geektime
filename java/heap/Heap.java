package heap;

public class Heap {

    private final int DEFAULT_CAPACITY = 16;

    private int[] arr;

    private int capacity;

    private int size;

    public Heap() {
        arr = new int[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
        size = 0;
    }

    public Heap(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
        size = 0;
    }

    private Heap(int[] data) {
        arr = new int[data.length];
        for (int i = 0, len = arr.length; i < len; i++) {
            arr[i] = data[i];
        }
        size = arr.length;
        capacity = arr.length;
    }

    public static void main(String[] args) {
        Heap heap = new Heap(new int[]{ 1, 2, 3 });
        heap.heapSort();
        heap.print();
    }

    public void insert(int val) {
        if (size == capacity) {
            resize(2 * capacity);
        }
        arr[size++] = val;
        shiftUp(val, size / 2);
    }

    private void buildHeap() {
        for (int i = size / 2 - 1; i > -1; i--) {
            shiftDown(i, size);
        }
    }

    private void heapSort() {
        buildHeap();
        int pos = size - 1;
        while (pos > 0) {
            swap(0, pos);
            shiftDown(0, pos);
            pos--;
        }
    }

    private void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void shiftUp(int val, int pos) {
        while (pos > 0 && val > arr[pos / 2]) {
            arr[pos] = arr[pos / 2];
            pos /= 2;
        }
        arr[size++] = val;
    }

    private void shiftDown(int pos, int threshold) {
        int val = arr[pos];
        while (pos * 2 + 1 < threshold) {
            int child = pos * 2 + 1;
            if (child + 1 < threshold && arr[child + 1] > arr[child]) {
                child++;
            }
            if (val < arr[child]) {
                arr[pos] = arr[child];
            } else {
                break;
            }
            pos = child;
        }
        arr[pos] = val;
    }

    private void resize(int newCapacity) {
        int[] newArr = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        capacity = newCapacity;
    }

    private void print() {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
