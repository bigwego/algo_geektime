package array;

public class Array {

    private final int[] data;

    // total length of array
    private final Integer len;

    // exact count of elements in array
    private Integer cnt;

    public Array(int capacity) {
        data = new int[capacity];
        len = capacity;
        cnt = 0;
    }

    public int find(int idx) {
        if (idx < 0 && idx >= len) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return data[idx];
    }

    public boolean insert(int idx, int val) {
        if (cnt == len && (idx < 0 || idx >= cnt)) {
            return false;
        }
        for (int i = cnt; i > idx; i--) {
            data[i] = data[i - 1];
        }
        data[idx] = val;
        cnt++;
        return true;
    }

    public boolean delete(int idx) {
        if (cnt == 0 && idx >= cnt) {
            return false;
        }
        for (int i = idx; i < cnt - 1; i++) {
            data[i] = data[idx + 1];
        }
        cnt--;
        return true;
    }
}
