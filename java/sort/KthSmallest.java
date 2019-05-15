package sort;

public class KthSmallest {

    private static int kthSmallest(int[] a, int k) {
        if (a == null || a.length < k) {
            return -1;
        }
        int n = a.length - 1;
        int p = partition(a, 0, n);
        while (p != k - 1) {
            if (p < k - 1) {
                p = partition(a, p + 1, n);
            } else {
                p = partition(a, 0, p - 1);
            }
        }
        return a[p];
    }

    private static int partition(int[] a, int l, int r) {
        int pivot = a[r];
        int i = l;
        for (int j = l; j < r; j++) {
            if (a[j] <= pivot) {
                swap(a, i++, j);
            }
        }
        swap(a, i, r);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 1 };
        System.out.println(kthSmallest(a, 4));
    }
}
